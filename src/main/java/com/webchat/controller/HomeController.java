package com.webchat.controller;

import lombok.Value;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@Log4j
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    //메인페이지
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage() {
        logger.debug("메인페이지 입니다");
        return "mainPage";
    }

    //회원가입 페이지 이동
    @RequestMapping(value = "joinPage", method = RequestMethod.GET)
    public String joinPage(){
        log.debug("회원 가입 페이지 이동");
        return "member/memberJoinPage";
    }
}
