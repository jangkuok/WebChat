package com.webchat.websocket;

import com.google.gson.Gson;
import com.webchat.service.ChatRoomMessageService;
import com.webchat.vo.ChatRoomMessageVo;
import org.springframework.messaging.Message;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ServerEndpoint("/chatting")
public class SocketServer {

    private static List<Session> sessionList = new ArrayList<Session>();

    @OnOpen
    public void handleOpen(Session session) {
        System.out.println("클라이언트가 접속했습니다.");
        sessionList.add(session);
        for (int i = 0; i <= sessionList.size(); i++){
            System.out.println(session);
        }
        checkSessionList(); //접속자 list
        clearSessionList(); // 퇴장한 접속자 삭제
    }

    @OnMessage
    public void handleMessage(String msg, Session session) {

        System.out.println("클라이언트가 보낸 메시지: " + msg);

        Gson gson = new Gson();
        ChatRoomMessageVo chatRoomMessageVo = gson.fromJson(msg, ChatRoomMessageVo.class);

        if(chatRoomMessageVo.getCode().equals("1")){
            System.out.println("들어왔다!!");
            for(Session s : sessionList){
                if(s != session){
                    try {
                        s.getBasicRemote().sendText(msg);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }else if (chatRoomMessageVo.getCode().equals("2")) {
            System.out.println("나갔다!!");
            sessionList.remove(session);
            for (Session s : sessionList) {
                try {
                    s.getBasicRemote().sendText(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (chatRoomMessageVo.getCode().equals("3")) {
            //보낸 사람빼고 나머지 사람에게 전달한다.
            for (Session s : sessionList) {
                if (s != session) {
                    try {
                        s.getBasicRemote().sendText(msg);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    @OnClose
    public void handleClose() {
        System.out.println("클라이언트가 종료했습니다.");
    }

    @OnError
    public void handleError(Throwable e) {
        System.out.println("에러 발생 " + e.getMessage());
    }

    private void checkSessionList(){
        System.out.println("==========================");
        System.out.println("[SESSION LIST]");
        for (Session session : sessionList) {
            System.out.println(session.getId());
        }
        System.out.println("==========================");
    }

    private void clearSessionList() {

        Iterator<Session> iter = sessionList.iterator();

        while(iter.hasNext()) {
            if(!(iter.next()).isOpen()) {
                //혹시 연결이 끊어진 세션이 있으면 리스트에서 제거한다.
                iter.remove();
            }
        }
    }

}
