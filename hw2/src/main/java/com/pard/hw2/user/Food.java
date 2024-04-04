package com.pard.hw2.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Food {
    private Integer cost;
    private String foodName;
    private String size;
}
