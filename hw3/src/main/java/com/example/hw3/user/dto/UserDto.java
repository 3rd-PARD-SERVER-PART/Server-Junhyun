package com.example.hw3.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDto {
    private String burgerName;
    private String price;
    private String sale;
}
