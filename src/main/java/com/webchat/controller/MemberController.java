package com.webchat.controller;

import com.webchat.config.SessionConfig;
import com.webchat.service.ChatRoomService;
import com.webchat.service.MemberService;
import com.webchat.vo.ChatRoomVo;
import com.webchat.vo.MemberVo;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@Log4j
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Resource(name = "memberService")
    private MemberService memberService;


    @PostMapping("memberJoin")
    public String memberJoin(@ModelAttribute MemberVo memberVo) throws Exception{

        memberService.insertMember(memberVo);
        logger.info("가입완료");
        return "mainPage";
    }

    @PostMapping("login")
    public ModelAndView login(@ModelAttribute MemberVo memberVo, HttpSession session, ModelAndView mv) throws Exception {
        MemberVo vo = memberService.selectMemberId(memberVo.getId());

        if (vo != null && vo.getPw().equals(memberVo.getPw())) {
            String id = SessionConfig.getSessionCheck("id", vo.getId());
            System.out.println("로그인 체크 : " + id);
            session.setAttribute("id", vo.getId());
            session.setAttribute("nickName", vo.getNickName());
            session.setMaxInactiveInterval(60*10);

        }
            mv.setViewName("redirect:/");

        return mv;
    }

    @GetMapping("logout")
    public String logout(HttpSession session){

        session.invalidate();

        return "redirect:/";
    }
}
