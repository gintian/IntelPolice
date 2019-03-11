package com.listener;

import com.utils.SessionListenerUtils;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Administrator on 2018/5/17 0017.
 */
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //session过期
        HttpSession session = httpSessionEvent.getSession();
        System.out.println("session过期 sessionId: " + session.getId());

        SessionListenerUtils.logout(session);

    }
}
