package com.example.hw4.user.service;

import com.example.hw4.book.dto.BookReadDTO;
import com.example.hw4.user.dto.UserDTO;
import com.example.hw4.user.dto.UserLoanDTO;
import com.example.hw4.user.entity.UserLoanHistory;
import com.example.hw4.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.hw4.user.entity.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public void createUser(UserDTO.Create dto){
        userRepo.save(User.toEntity(dto));
    }

    public List<UserDTO.Read> readAll(){
        return userRepo.findAll()
                .stream()
                .map(user -> new UserDTO.Read(user))
                .collect(Collectors.toList());
    }


}
