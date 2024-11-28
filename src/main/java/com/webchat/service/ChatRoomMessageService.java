package com.webchat.service;

import com.webchat.vo.ChatRoomMessageVo;

public interface ChatRoomMessageService {

    //채팅 내용 등록
    int insertChatRoomMessage(ChatRoomMessageVo chatRoomMessageVo);
}
