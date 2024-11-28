package com.webchat.vo;


import lombok.*;
import org.springframework.context.annotation.Configuration;

@Getter
@ToString
@NoArgsConstructor
@Configuration
public class ChatRoomMessageVo {
    private int messageNo;
    private String code;
    private String id;
    private String receiver;
    private String content;
    private String sendDate;

    private int roomNo;

    private ChatRoomVo chatRoomVo;

    public void changeMessageNo(int messageNo) {
        this.messageNo = messageNo;
    }

    public void changeCode(String code) {
        this.code = code;
    }

    public void changeId(String id) {
        this.id = id;
    }

    public void changeReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void changeContent(String content) {
        this.content = content;
    }

    public void changeSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public void changeRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public void changeChatRoomVo(ChatRoomVo chatRoomVo) {
        this.chatRoomVo = chatRoomVo;
    }


}
