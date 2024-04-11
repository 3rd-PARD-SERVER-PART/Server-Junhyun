package com.example.hw3.user.repo;

import com.example.hw3.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserReopsitory extends JpaRepository<User, Long> {
    public List<User> findBybugerName(String bugerName);
    public List<User> findByPrice(String price);
    public List<User> findBySale(String sale);
}
