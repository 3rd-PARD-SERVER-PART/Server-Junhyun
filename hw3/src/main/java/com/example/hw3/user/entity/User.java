package com.example.hw3.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long burgerId;
    @Column(name = "burgerName", length = 20)
    private String burgerName;
    @Column(name = "price")
    private String price;
    @Column(name = "sale")
    private String sale;
    @CreationTimestamp //JPA에 db에 저장이 될 때 자동으로 시간을 설정해주는 함수
    private Timestamp userSignupTime;
}
