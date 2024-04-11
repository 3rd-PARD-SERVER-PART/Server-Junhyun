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
@RequestMapping("/buger")
public class Controller {

    private final UserService userService;

    @PostMapping("")
    public String save(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return "저장 성공";
    }

    @GetMapping("/{bugerId}")
    public UserDto readbyId(@PathVariable Long bugerId) {
        return userService.read(bugerId);
    }

    @GetMapping("")
    public List<UserDto> readAll() {
        return userService.readAll();
    }

    @PatchMapping("/{bugerId}")
    public String update(@PathVariable Long bugerId, @RequestBody UserDto userDto) {
        userService.update(bugerId, userDto);
        return "업데이트 성공";
    }
    @DeleteMapping("/{bugerId}")
    public String delete(@PathVariable Long bugerId){
        userService.delete(bugerId);
        return "삭제 성공";
    }

    //JPA

    //이름으로 버거찾기
    @GetMapping("/bugername")
    public List<UserDto> findByName(@RequestParam String name){
        return userService.getbugerName(name);
    }

    //가격으로 버거 찾기
    @GetMapping("/price")
    public List<UserDto> findbByPrice(@RequestParam String price){
        return userService.getbugerPrice(price);
    }

    //세일 유무로 버거 찾기
    @GetMapping("/sale")
    public List<UserDto> findBySale(@RequestParam String sale){
        return userService.getbugersale(sale);
    }

    @GetMapping("/count")
    public String count(){
        return userService.countbuger();
    }
}
