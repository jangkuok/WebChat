package com.webchat.controller;

import com.webchat.service.ChatRoomService;
import com.webchat.vo.ChatRoomVo;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/chat")
@Log4j
public class ChatRoomController {

    private static final Logger logger = LoggerFactory.getLogger(ChatRoomController.class);

    @Resource(name = "chatRoomService")
    private ChatRoomService chatRoomService;

    @GetMapping("/chatRoom")
    public String chatRoom(Model model){

        List<ChatRoomVo> chatRoomVoList = chatRoomService.selectChatRoomList();
        model.addAttribute("chatRoom",chatRoomVoList);

        return "chat/chatRoom";
    }


    @GetMapping("/chatRoomMessage/{roomNo}")
    public String chatRoomMessage(Model model,@PathVariable("roomNo") int roomNo){

        ChatRoomVo chatRoomVo = chatRoomService.selectChatRoomMessageList(roomNo);

        model.addAttribute("chatRoom",chatRoomVo);

        System.out.println(chatRoomService.selectChatRoomMessageList(roomNo));

        return "chat/chatRoomMessage";
    }


}
