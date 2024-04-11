package com.example.hw3.user.service;

import com.example.hw3.user.dto.UserDto;
import com.example.hw3.user.entity.User;
import com.example.hw3.user.repo.UserReopsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserReopsitory userRepository;

    public void save(UserDto userDto){
        User user = User.builder()
                .burgerName(userDto.getBurgerName())
                .price(userDto.getPrice())
                .sale(userDto.getSale())
                .build();
        userRepository.save(user);
    }

    public UserDto read(Long userId){
        User user = userRepository.findById(userId).get();
        return UserDto.builder()
                .burgerName(user.getBurgerName())
                .price(user.getPrice())
                .sale(user.getSale())
                .build();
    }

    public List<UserDto> readAll(){
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user ->
                UserDto.builder()
                        .burgerName(user.getBurgerName())
                        .price(user.getPrice())
                        .sale(user.getSale())
                        .build()).toList();
        return userDtos;
    }

    public void update(Long burgerId, UserDto userDto){
        User user = userRepository.findById(burgerId).get();
        user.setBurgerName(userDto.getBurgerName());
        user.setPrice(userDto.getPrice());
        user.setSale((userDto.getSale()));
        userRepository.save(user);
    }

    public void delete(Long userId){
        userRepository.deleteById(userId);
    }
    //JPA

    // 이름으로 버거찾기
    public List<UserDto> getburgerName(String name){
        List<User> user = userRepository.findByburgerName(name);
        List<UserDto> userDtos = user.stream().map(users->
                UserDto.builder()
                        .price(users.getPrice())
                        .burgerName(users.getBurgerName())
                        .sale(users.getSale())
                        .build()).toList();
        return userDtos;
    }
    // 가격으로 버거찾기
    public List<UserDto> getburgerPrice(String price){
        List<User> user = userRepository.findByPrice(price);
        List<UserDto> userDtos = user.stream().map(users ->
                UserDto.builder()
                        .price(users.getPrice())
                        .burgerName(users.getBurgerName())
                        .sale(users.getSale())
                        .build()).toList();
        return userDtos;
    }

    //세일중인 버거찾기
    public List<UserDto> getburgersale(String sale) {
        List<User> user = userRepository.findBySale(sale);
        List<UserDto> userDtos = user.stream().map(users ->
                UserDto.builder()
                        .price(users.getPrice())
                        .burgerName(users.getBurgerName())
                        .sale(users.getSale())
                        .build()).toList();
        return userDtos;
    }

    public String countburger(){
        Long burgerCount = userRepository.count();
        return "메뉴의 개수는 : " + burgerCount + "개";
    }

}
