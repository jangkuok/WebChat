package com.webchat.dao.impl;

import com.webchat.dao.ChatRoomMessageDao;
import com.webchat.mapper.ChatRoomMessageMapper;
import com.webchat.vo.ChatRoomMessageVo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("chatRoomMessageDao")
public class ChatRoomMessageDaoImpl implements ChatRoomMessageDao {

    @Resource(name = "chatRoomMessageMapper")
    private ChatRoomMessageMapper chatRoomMessageMapper;

    //채팅 내용 등록
    @Override
    public int insertChatRoomMessage(ChatRoomMessageVo chatRoomMessageVo) {
        return chatRoomMessageMapper.insertChatRoomMessage(chatRoomMessageVo);
    }
}
