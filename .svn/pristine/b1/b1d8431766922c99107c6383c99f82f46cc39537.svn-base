package com.utils;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class ExecuteResult {
    public static final int SUCCESS_STATUS = 200;
    public static final int ERROR_STATUS = 300;
    public static final int LOGIN_OUT = 301;
    public static final int ERROR_ELSE_STATUS = 500;
    /**
     *   填写操作状态码
     * @param statusCode
     * @return
     */
    public static JSONObject jsonReturn(int statusCode) {
        return jsonReturn(statusCode, null, false, null, null);
    }

    /**
     * 创建返回的 json
     *
     * @param statusCode           [必填]         返回的状态码
     * @param forward              [必填]         请求转发的地址
     * @return
     */
    public static JSONObject jsonReturn(int statusCode, String forward) {
        return jsonReturn(statusCode, forward, false, null, null);
    }

    /**
     * 操作状态码，是否关闭当前窗口
     * @param statusCode
     * @param closeCurrent
     * @return
     */
    public static JSONObject jsonReturn(int statusCode, boolean closeCurrent) {
        return jsonReturn(statusCode, null, closeCurrent, null, null);
    }

    /**
     * 创建返回的 json
     *
     * @param statusCode [必填]状态，200=操作成功；其他=操作失败
     * @param forward    [必填]转发显示页面
     * @param msg        [非必填]提示消息，如果填写了这个字段，会在提示框中显示
     * @param sendData   [非必填]发送到浏览器的数据，可用于浏览器端接受操作数据。
     * @return 返回Map对象，这个对象通过Spring mvc可以转换成浏览器可以使用的json对象
     */
    public static JSONObject jsonReturn(int statusCode, String forward, boolean closeCurrent, String msg, Map sendData) {

        JSONObject jsonObj = new JSONObject();

        msg = CommonValidate.isEmpty(msg) ? "" : ("：" + msg);

        if (statusCode == 200) {
            jsonObj.put("statusCode", "200");
            jsonObj.put("message", "操作成功 " + msg);
        } else if (statusCode == 301) {
            jsonObj.put("statusCode", "301");
            jsonObj.put("message", "操作失败" + msg);
        } else {
            jsonObj.put("statusCode", "300");
            jsonObj.put("message", "操作失败" + msg);
        }

        if (forward != null) {
            jsonObj.put("forward", forward);
        }
        if (sendData != null) {
            jsonObj.put("sendData", sendData);
        }
        jsonObj.put("closeCurrent", closeCurrent);
        return jsonObj;
    }

    /**
     * 带数据返回
     *
     * @param status
     * @param sendData
     * @return
     */
    public static JSONObject jsonReturnOnData(int status, Map sendData) {
        return jsonReturn(status, null, false, null, sendData);
    }

    /**
     * 当捕捉到 AppException 时候调用这个方法获得返回的 jsonObj , 为 ExceptionResolver 定制
     *
     * @param status
     * @param msg
     * @return
     */
    public static JSONObject jsonReturnCallOnAppException(int status, String msg) {
        return jsonReturn(status, null, false, msg, null);
    }
}
