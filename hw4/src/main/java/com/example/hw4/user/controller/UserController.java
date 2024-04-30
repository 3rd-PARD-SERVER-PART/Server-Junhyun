package com.example.hw4.user.controller;

import com.example.hw4.user.dto.UserDTO;
import com.example.hw4.user.dto.UserLoanDTO;
import com.example.hw4.user.service.UserLoanService;
import com.example.hw4.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserLoanService userLoanService;

    @PostMapping("")
    public String createUser(@RequestBody UserDTO.Create dto){
        userService.createUser(dto);
        return "success";
    }
// 여기 밑에 두개가 왜 에러가 나는걸까요,,,,,,
    @PostMapping("")
    public List<UserDTO> findAll(){
        return userService.readAll();
    }

    @PostMapping("/loan")
    public List<UserLoanDTO> findAll(){
        return userLoanService.findAll();
    }
}
