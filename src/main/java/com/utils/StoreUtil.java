package com.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.Socket;

public class StoreUtil {
    /**
     * http方式请求柜子接口
     * @param method：请求的方法名称
     * @param cab：柜子编号
     * @param box：箱子编号
     */
    public static String postToWebserviceByHttp(String postpath, String host, String method, String cab, String box) {
        String returnStr = "";
        InputStream is = null;
        HttpClient client = new HttpClient();
//		PostMethod postMethod = new PostMethod("http://192.168.1.100:8090/WebService1.asmx/" + method);
//		postMethod.setRequestHeader("Host", "192.168.1.100:8090");
        PostMethod postMethod = new PostMethod(postpath + "/" + method);
        postMethod.setRequestHeader("Host", host);
        postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        if(!cab.isEmpty()||cab!=""){
            postMethod.setParameter("cab", cab);
        }
        if(box.isEmpty()||box!=""){
            postMethod.setParameter("box", box);
        }
        try {
            client.executeMethod(postMethod);
            is = postMethod.getResponseBodyAsStream();
            Document document = Jsoup.parse(is,"utf-8","");
            returnStr = document.getElementsByTag("string").html();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            postMethod.releaseConnection();
            try {
                if(is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return returnStr;
    }
    /**
     * 打开单个箱子
     * @param boxNo
     * @throws Exception
     */
    public static void openBox(int boxNo, String host) throws Exception{
        //字节数组（需要发送的指令）
        byte[]   b2Box   =   new   byte[10];
        b2Box[0]   =   (byte)92;
        b2Box[1]   =   (byte)197;
        b2Box[2]   =   (byte)6;
        b2Box[3]   =   (byte)164;
        b2Box[4]   =   (byte)boxNo;
        b2Box[5]   =   (byte)0;
        b2Box[6]   =   (byte)0;
        b2Box[7]   =   (byte)0;
        b2Box[8]   =   (byte)0;
        b2Box[9]   =   (byte)(6 ^ 164 ^ boxNo ^ 0 ^ 0 ^ 0 ^ 0);
        openBoxByTcp(b2Box,host);
    }
    /**
     * 打开所有箱子
     * @param host 箱子地址
     * @throws Exception
     */
    public void openAllBox(String host) throws Exception{
        //字节数组（需要发送的指令）
        byte[]   b2Box   =   new   byte[10];
        b2Box[0]   =   (byte)92;
        b2Box[1]   =   (byte)197;
        b2Box[2]   =   (byte)6;
        b2Box[3]   =   (byte)165;
        b2Box[4]   =   (byte)1;
        b2Box[5]   =   (byte)0;
        b2Box[6]   =   (byte)0;
        b2Box[7]   =   (byte)0;
        b2Box[8]   =   (byte)0;
        b2Box[9]   =   (byte)162;
        openBoxByTcp(b2Box,host);
    }
    /**
     * 打开箱子
     * @param b2Box
     * @param host
     * @throws Exception
     */
    private static void openBoxByTcp(byte[] b2Box, String host) throws Exception{

        //1.建立客户端socket连接，指定服务器位置及端口
        Socket socket =new Socket(host,4001);
        //2.得到socket读写流
        OutputStream os=socket.getOutputStream();
        os.write(b2Box);
        os.flush();
        //输入流
        InputStream is=socket.getInputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
        //3.利用流按照一定的操作，对socket进行读写操作
        int reply = 0;
        while(!((reply = br.read())== 0)){
            System.out.println("接收服务器的信息："+reply);
            byte[] replyByte = intToBytes(reply);
        }
        //4.关闭资源
        br.close();
        is.close();
        os.close();
        socket.close();
    }


    private static byte[] intToBytes( int value ){
        byte[] src = new byte[4];
        src[3] =  (byte) ((value>>24) & 0xFF);
        src[2] =  (byte) ((value>>16) & 0xFF);
        src[1] =  (byte) ((value>>8) & 0xFF);
        src[0] =  (byte) (value & 0xFF);
        return src;
    }
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}
