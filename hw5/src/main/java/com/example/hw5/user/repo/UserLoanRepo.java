package com.example.hw5.user.repo;

import com.example.hw5.user.entity.UserLoanHistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanRepo extends JpaRepository<UserLoanHistory, Long> {
}
