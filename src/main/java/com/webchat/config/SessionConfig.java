package com.webchat.config;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class SessionConfig implements HttpSessionListener {

    private static final Map<String, HttpSession> sessionMap = new ConcurrentHashMap<>();

    //중복 로그인 비교
    public synchronized static String getSessionCheck(String keyName,String checkId){
        String result = "";
        System.out.println("메소드 값 확인 : " + keyName +  " / " + checkId);
        System.out.println("세션 : " + sessionMap.keySet().size());
        for(String key : sessionMap.keySet()){
            HttpSession httpSession = sessionMap.get(key);
            if(httpSession != null &&  httpSession.getAttribute(keyName) != null && httpSession.getAttribute(keyName).toString().equals(checkId) ){
                result =  key.toString();
            }
        }
        System.out.println("결과값 : " + result);
        removeDoubleLogin(result);
        return result;
    }

    //중복시 삭제
    private static void removeDoubleLogin(String userId) {
        System.out.println("remove userId : " + userId);
        if (userId != null && userId.length() > 0) {
            sessionMap.get(userId).invalidate();
            sessionMap.remove(userId);
        }
    }

    //로그인
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("로그인");
        sessionMap.put(se.getSession().getId(), se.getSession());
    }

    //로그아웃
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("로그아웃");
        if(sessionMap.get(se.getSession().getId()) != null){
            sessionMap.get(se.getSession().getId()).invalidate();
            sessionMap.remove(se.getSession().getId());
        }
    }
}
