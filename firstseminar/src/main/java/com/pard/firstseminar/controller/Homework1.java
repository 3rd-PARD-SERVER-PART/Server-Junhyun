package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Homework1 {

    @RequestMapping("/Introduce")
    public String MyInfo(@RequestParam(defaultValue = "Guest") String name, @RequestParam(defaultValue = "0") Integer age, @RequestParam(defaultValue = "글로벌리더십") String classroom, @RequestParam(defaultValue = "Null") String hobby) {
        return "제 이름은 박준현이고요, 나이는 23살, 학부는 전산전자공학부, 취미는 번개맴버 모집입니다." +
                "제 짝의 이름은 " + name + "고요, 나이는 " + age + "살, 학부는 " + classroom + " 취미는 " + hobby + "입니다.";
    }

}

