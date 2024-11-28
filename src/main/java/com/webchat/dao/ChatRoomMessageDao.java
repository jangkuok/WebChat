package com.webchat.dao;

import com.webchat.vo.ChatRoomMessageVo;

public interface ChatRoomMessageDao {

    //채팅 내용 등록
    int insertChatRoomMessage(ChatRoomMessageVo chatRoomMessageVo);
}
