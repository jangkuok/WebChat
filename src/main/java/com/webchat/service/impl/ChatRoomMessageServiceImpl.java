package com.webchat.service.impl;

import com.webchat.dao.ChatRoomMessageDao;
import com.webchat.service.ChatRoomMessageService;
import com.webchat.vo.ChatRoomMessageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("chatRoomMessageService")
public class ChatRoomMessageServiceImpl implements ChatRoomMessageService {

    @Resource(name = "chatRoomMessageDao")
    private ChatRoomMessageDao chatRoomMessageDao;

    //채팅 내용 등록
    @Override
    public int insertChatRoomMessage(ChatRoomMessageVo chatRoomMessageVo) {
        return chatRoomMessageDao.insertChatRoomMessage(chatRoomMessageVo);
    }
}
