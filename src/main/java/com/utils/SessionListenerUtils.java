package com.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

public class SessionListenerUtils {
	private static HashMap hUserName = new HashMap();// 保存sessionID和username的映射
	private static HashMap hashMapSession = new HashMap();   //保存httpsession
	public void sessionCreated(HttpSessionEvent arg0) {}
	public void sessionDestroyed(HttpSessionEvent arg0) {}
	/**
	  * isAlreadyEnter-用于判断用户是否已经登录以及相应的处理方法 
	  * @param sUserName String-登录的用户名称
	 *   @param session   请求Session
	  * @return boolean-该用户是否已经登录过的标志
	  */
	public static synchronized void isAlreadyEnter(HttpSession session, String sUserName){
		// 如果该用户已经登录过，则使上次登录的用户掉线(依据使用户名是否在hUserName中)
		if(hUserName.containsValue(sUserName)){
			// 遍历原来的hUserName，删除原用户名对应的sessionID(即删除原来的sessionID和username)
			Iterator iter = hUserName.entrySet().iterator();
			Map.Entry entry;
			while (iter.hasNext()){
				entry = (Map.Entry)iter.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				if(((String)val ).equals(sUserName)){
					iter.remove();
					HttpSession httpSession = (HttpSession) hashMapSession.get(key);
					httpSession.invalidate();
					hashMapSession.remove(key);
				}
			}
			hUserName.put(session.getId(),sUserName);  // 添加现在的sessionID和username
			hashMapSession.put(session.getId(), session);
	  }else{
		  	hUserName.put(session.getId(),sUserName);
			hashMapSession.put(session.getId(), session);
	  }
	}

	/**
	 * 退出登录
	 * @param session				[必填]   请求session
	 */
	public static synchronized void logout(HttpSession session)
	{
		if (CommonValidate.isEmpty(session)){
			return;
		}
		Iterator iter = hUserName.entrySet().iterator();
		Map.Entry entry;
		while (iter.hasNext()){
			entry = (Map.Entry)iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			if(((String)val ).equals(hUserName.get(session.getId()).toString())){
				iter.remove();
				HttpSession httpSession = (HttpSession) hashMapSession.get(session.getId());
				httpSession.invalidate();
				hashMapSession.remove(session.getId());
			}
		}
	}
	 /**
	  * isOnline-用于判断用户是否在线 
	  * @param session HttpSession-登录的用户名称 
	  * @return boolean-该用户是否在线的标志
	  */
	 public static boolean isOnline(HttpSession session){
		 boolean flag = true;
		 if(hUserName.containsKey(session.getId())){
			 flag = true;
		 }else{
			 flag = false;
		 }
		 return flag;
	 }

	/**
	 * 返回当前登录的  账号
	 * @param session					[必填]		请求Session
	 * @return
	 */
	public static String getUserName(HttpSession session)
	 {
		 return hUserName.get(session.getId()).toString();
	 }
}
