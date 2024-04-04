package com.pard.hw2.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class FoodDto {
    private Integer cost;
    private String foodName;
    private String size;
}
