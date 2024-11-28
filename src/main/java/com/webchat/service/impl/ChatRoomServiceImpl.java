package com.webchat.service.impl;

import com.webchat.dao.ChatRoomDao;
import com.webchat.service.ChatRoomService;
import com.webchat.vo.ChatRoomVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("chatRoomService")
public class ChatRoomServiceImpl implements ChatRoomService {


    private static final Logger logger = LoggerFactory.getLogger(ChatRoomServiceImpl.class);

    @Resource(name = "chatRoomDao")
    private ChatRoomDao chatRoomDao;

    //채팅방 생성
    @Override
    public int insertChatRoom(ChatRoomVo chatRoomVo) throws Exception {
        logger.info("=========> ChatRoomServiceImpl insertChatRoom() 기능 처리");
        return chatRoomDao.insertChatRoom(chatRoomVo);
    }
    //채팅방 업데이트
    @Override
    public void updateChatRoom(ChatRoomVo chatRoomVo) throws Exception {
        logger.info("=========> ChatRoomServiceImpl updateChatRoom() 기능 처리");
        chatRoomDao.updateChatRoom(chatRoomVo);
    }
    //채팅방 삭제
    @Override
    public void deleteChatRoom(int roomNo) throws Exception {
        logger.info("=========> ChatRoomServiceImpl deleteChatRoom() 기능 처리");
        chatRoomDao.deleteChatRoom(roomNo);
    }
    //채팅방 목록
    @Override
    public List<ChatRoomVo> selectChatRoomList() {
        logger.info("=========> ChatRoomServiceImpl selectChatRoomList() 기능 처리");
        return chatRoomDao.selectChatRoomList();
    }
    //채팅방 메세지 목록
    @Override
    public ChatRoomVo selectChatRoomMessageList(int roomNo) {
        logger.info("=========> ChatRoomServiceImpl selectChatRoomMessageList() 기능 처리");
        return chatRoomDao.selectChatRoomMessageList(roomNo);
    }
}
