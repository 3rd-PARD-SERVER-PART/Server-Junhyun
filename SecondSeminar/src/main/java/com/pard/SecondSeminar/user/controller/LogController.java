package com.pard.SecondSeminar.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j // log찍는 어노테이션

public class LogController {
    @GetMapping("/log")
    public String log() {
        String name = "Spring";

        log.info("name : {}",name); //중괄호 쓰는 이유 = + 로 해서 쓰면 메모리를 잡아먹음 log 쓰는 이유가 없음
        log.warn("name : {}",name);
        log.error("name : {}",name);
        log.debug("name : {}",name);
        log.trace("name : {}",name);
        return "Hello";
    }
}
