package com.example.hw4.user.repo;

import com.example.hw4.user.entity.UserLoanHistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanRepo extends JpaRepository<UserLoanHistory, Long> {
}
