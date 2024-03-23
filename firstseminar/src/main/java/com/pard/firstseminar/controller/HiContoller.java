package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + ResponceBody를 합한거.

public class HiContoller {
    @RequestMapping("/hi")
    public String hi() {
        return "hello.html";
    }
}
// @Controller 을 했을 때랑 결과값이 다르다. @Controller -> 안녕하세요 / @RestController -> hello.html
// @Controller 은 static에서 hello.html이 있는지 확인해서 있으면 그 값을 출력한다.