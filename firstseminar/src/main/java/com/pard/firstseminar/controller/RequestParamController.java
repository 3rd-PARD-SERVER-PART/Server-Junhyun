package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RequestParamController {
    @RequestMapping("/basic")
    public String requestParam(@RequestParam("name") String hiName, @RequestParam("age") int hiAge) {
        return "requestParam 연습 name : " + hiName + "Age : " + hiAge;
    }

    @RequestMapping("/V2") // 주소에서 변수값을 넣어줄 때 name, age (변수 이름)으로 넣어도 자동으로 인식한다.
    // basic과 다른점 : basic은 hiName을 name = 이름으로 넣어줘야하는데, 그냥 name = 이름으로 해도 된다. 변수이름이 같으면 그냥 생략해도 된다.
    // 주소에 변수 넣을 때 순서는 상관없음
    // 이름따라서 변수의 값을 지정해준다.
    public String requestParamV2(@RequestParam String name, @RequestParam int age){
        return "V2 name" + name + "age : " + age;
    }

    @RequestMapping("/V3") // @RequestParam 까지 생략가능한데 나중에 디버깅 때 혼란 방지를 위해 쓰는걸 추천한다.
    public String requestParamV3(String name, int age){
        return "V3 name" + name + "age : " + age;
    }

    @RequestMapping("/V4") // requried가 원래는 true가 기본 값이지만 이걸 false로 바꾸면 null값이 들어와도 상관 없다.
    //V5에서 쓴 defaultValue를 쓰면 required는 있으나 없으나 상관없다.
    // int는 null 값을 못 받으니 여기서 쓰려면 Integer를 써야한다.
    // 앵간하면 원시함수를 쓰는게 좋다. ex) Integer, Float, Long 등등
    public String requestParamV4(@RequestParam(required = true) String name, @RequestParam(required = false) Integer age){
        return "V4 name" + name + "age : " + age;
    }

    @RequestMapping("/V5") // requried가 원래는 true가 기본 값이지만 이걸 false로 바꾸면 null값이 들어와도 상관 없다.
    // 만약 넘겨주는 값과 변수의 이름을 다르게 하고 defalutValue도 같이 쓰려면 value = "원하는 이름"으로 넣어주면 된다.
    public String requestParamV5(@RequestParam(required = true, defaultValue = "guest") String name, @RequestParam(required = false,defaultValue = "0") int age){
        return "V5 name : " + name + "age : " + age;
    }
    @RequestMapping("/map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){
        return "Vmap name" + paramMap.get("name") + " age : " + paramMap.get("age");
    }
}
