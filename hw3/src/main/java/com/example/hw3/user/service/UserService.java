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
                .bugerName(userDto.getBugerName())
                .price(userDto.getPrice())
                .sale(userDto.getSale())
                .build();
        userRepository.save(user);
    }

    public UserDto read(Long userId){
        User user = userRepository.findById(userId).get();
        return UserDto.builder()
                .bugerName(user.getBugerName())
                .price(user.getPrice())
                .sale(user.getSale())
                .build();
    }

    public List<UserDto> readAll(){
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user ->
                UserDto.builder()
                        .bugerName(user.getBugerName())
                        .price(user.getPrice())
                        .sale(user.getSale())
                        .build()).toList();
        return userDtos;
    }

    public void update(Long bugerId, UserDto userDto){
        User user = userRepository.findById(bugerId).get();
        user.setBugerName(userDto.getBugerName());
        user.setPrice(userDto.getPrice());
        user.setSale((userDto.getSale()));
        userRepository.save(user);
    }

    public void delete(Long userId){
        userRepository.deleteById(userId);
    }
    //JPA

    // 이름으로 버거찾기
    public List<UserDto> getbugerName(String name){
        List<User> user = userRepository.findBybugerName(name);
        List<UserDto> userDtos = user.stream().map(users->
                UserDto.builder()
                        .price(users.getPrice())
                        .bugerName(users.getBugerName())
                        .sale(users.getSale())
                        .build()).toList();
        return userDtos;
    }
    // 가격으로 버거찾기
    public List<UserDto> getbugerPrice(String price){
        List<User> user = userRepository.findByPrice(price);
        List<UserDto> userDtos = user.stream().map(users ->
                UserDto.builder()
                        .price(users.getPrice())
                        .bugerName(users.getBugerName())
                        .sale(users.getSale())
                        .build()).toList();
        return userDtos;
    }

    //세일중인 버거찾기
    public List<UserDto> getbugersale(String sale) {
        List<User> user = userRepository.findBySale(sale);
        List<UserDto> userDtos = user.stream().map(users ->
                UserDto.builder()
                        .price(users.getPrice())
                        .bugerName(users.getBugerName())
                        .sale(users.getSale())
                        .build()).toList();
        return userDtos;
    }

    public String countbuger(){
        Long bugerCount = userRepository.count();
        return "메뉴의 개수는 : " + bugerCount + "개";
    }

}
