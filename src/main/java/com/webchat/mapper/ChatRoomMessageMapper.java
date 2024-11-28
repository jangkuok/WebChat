package com.webchat.mapper;

import com.webchat.vo.ChatRoomMessageVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatRoomMessageMapper {

    //채팅 내용 등록
    int insertChatRoomMessage(ChatRoomMessageVo chatRoomMessageVo);
}
