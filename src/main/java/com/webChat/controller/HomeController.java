package com.webChat.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j
public class HomeController {
    @GetMapping("/test")
    public String test(){
        log.info("테스트입니다");
        return "test";
    }
}
