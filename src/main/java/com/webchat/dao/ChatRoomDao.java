package com.webchat.dao;

import com.webchat.vo.ChatRoomVo;

import java.util.List;

public interface ChatRoomDao {

    //채팅방 생성
    int insertChatRoom(ChatRoomVo chatRoomVo) throws Exception;

    //채팅방 업데이트
    void updateChatRoom(ChatRoomVo chatRoomVo) throws Exception;

    //채팅방 삭제
    void deleteChatRoom(int roomNo) throws Exception;

    //채팅방 목록
    List<ChatRoomVo> selectChatRoomList();

    //채팅방 메세지 목록
    ChatRoomVo selectChatRoomMessageList(int roomNo);
}
