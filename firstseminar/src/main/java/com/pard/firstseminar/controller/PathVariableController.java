package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PathVariableController {
    @RequestMapping("/pathV1{name}")
    public String pathVariable(@PathVariable("name") String userName) {
        return "PathVariableV1 연습 name : " + userName;
    }
    @RequestMapping("/pathV2/{name}")
    public String pathVariableV2(@PathVariable String name) {
        return "PathVariableV2 연습 name : " + name;
    }
    @RequestMapping("/pathV3/{name}/{age}")
    public String pathVariableV3(@PathVariable String name, @PathVariable int age ) {
        return "PathVariableV2 연습 name : " + name + "age" + age;
    }

}
