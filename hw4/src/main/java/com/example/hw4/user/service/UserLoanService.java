package com.example.hw4.user.service;

import com.example.hw4.book.repo.BookRepo;
import com.example.hw4.user.dto.UserLoanDTO;
import com.example.hw4.user.entity.UserLoanHistory;
import com.example.hw4.user.repo.UserLoanRepo;
import com.example.hw4.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserLoanService {
    private final UserRepo userRepo;
    private final BookRepo bookRepo;
    private final UserLoanRepo userLoanRepo;

    public void createLoan(UserLoanDTO.Create dto){
        userRepo.save(dto.getUser());
    }

    public List<UserLoanDTO.Update> findAll(){
        return userLoanRepo.findAll()
                .stream()
                .map(userLoanHistory -> new UserLoanDTO.Update(userLoanHistory))
                .collect(Collectors.toList());
    }


}
