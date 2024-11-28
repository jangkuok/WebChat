package com.webchat.dao.impl;

import com.webchat.dao.ChatRoomDao;
import com.webchat.mapper.ChatRoomMapper;
import com.webchat.vo.ChatRoomVo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


@Repository("chatRoomDao")
public class ChatRoomDaoImpl implements ChatRoomDao {

    @Resource(name = "chatRoomMapper")
    private ChatRoomMapper chatRoomMapper;

    //채팅방 생성
    @Override
    public int insertChatRoom(ChatRoomVo chatRoomVo) throws Exception {
        return chatRoomMapper.insertChatRoom(chatRoomVo);
    }
    //채팅방 업데이트
    @Override
    public void updateChatRoom(ChatRoomVo chatRoomVo) throws Exception {
        chatRoomMapper.updateChatRoom(chatRoomVo);
    }
    //채팅방 삭제
    @Override
    public void deleteChatRoom(int roomNo) throws Exception {
        chatRoomMapper.deleteChatRoom(roomNo);
    }
    //채팅방 목록
    @Override
    public List<ChatRoomVo> selectChatRoomList() {
        return chatRoomMapper.selectChatRoomList();
    }
    //회원 채팅방 목록
    @Override
    public ChatRoomVo selectChatRoomMessageList(int roomNo) {
        return chatRoomMapper.selectChatRoomMessageList(roomNo);
    }
}
