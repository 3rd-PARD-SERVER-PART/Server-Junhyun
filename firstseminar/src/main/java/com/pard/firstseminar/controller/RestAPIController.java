package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class RestAPIController {
    @GetMapping("/{userid}")
    public String hi(@PathVariable Integer userid){
        return "Get으로 온 컨트롤러" + userid;
    }
    @GetMapping
    public String userAll(){
        return "Get : userAll";
    }

    @PostMapping
    public String userCreate(){
        return "Post : userCreate";
    }

    @PutMapping
    public String userUpdate(){
        return "Put : user Update";
    }

    @PatchMapping
    public String userUpdateByPatch(){
        return  "Path : user Update";
    }

    @DeleteMapping
    public String userDelete(){
        return "Delete : user Delete";
    }

}
