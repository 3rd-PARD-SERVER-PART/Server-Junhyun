package com.example.hw3.user.controller;

import com.example.hw3.user.dto.UserDto;
import com.example.hw3.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/burger")
public class Controller {

    private final UserService userService;

    @PostMapping("")
    public String save(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return "저장 성공";
    }

    @GetMapping("/{burgerId}")
    public UserDto readbyId(@PathVariable Long burgerId) {
        return userService.read(burgerId);
    }

    @GetMapping("")
    public List<UserDto> readAll() {
        return userService.readAll();
    }

    @PatchMapping("/{burgerId}")
    public String update(@PathVariable Long burgerId, @RequestBody UserDto userDto) {
        userService.update(burgerId, userDto);
        return "업데이트 성공";
    }
    @DeleteMapping("/{burgerId}")
    public String delete(@PathVariable Long burgerId){
        userService.delete(burgerId);
        return "삭제 성공";
    }

    //JPA

    //이름으로 버거찾기
    @GetMapping("/burgername")
    public List<UserDto> findByName(@RequestParam String name){
        return userService.getburgerName(name);
    }

    //가격으로 버거 찾기
    @GetMapping("/price")
    public List<UserDto> findbByPrice(@RequestParam String price){
        return userService.getburgerPrice(price);
    }

    //세일 유무로 버거 찾기
    @GetMapping("/sale")
    public List<UserDto> findBySale(@RequestParam String sale){
        return userService.getburgersale(sale);
    }

    @GetMapping("/count")
    public String count(){
        return userService.countburger();
    }
}
