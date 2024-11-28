package com.webchat.vo;

import lombok.*;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Getter
@ToString
@NoArgsConstructor
@Configuration
public class ChatRoomVo {

    private int roomNo;
    private String roomName;
    private String leaderId;

    private List<ChatRoomMessageVo> chatRoomMessageVoList;

    public void changeRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public void changeRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void changeLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    public void changeChatRoomMessageVos(List<ChatRoomMessageVo> chatRoomMessageVoList) {
        this.chatRoomMessageVoList = chatRoomMessageVoList;
    }
}
