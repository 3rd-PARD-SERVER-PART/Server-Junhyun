package com.example.hw4.book.entity;

import com.example.hw4.book.dto.BookCreateDTO;
import com.example.hw4.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String name;

    @ColumnDefault("0")
    private boolean isLoan;

    public Book(BookCreateDTO dto, User user){
        this.name = dto.getName();
        this.bookId = dto.getUserId();
        this.isLoan = false;
    }
    /*public static Book toEntity(BookCreateDTO dto, User user) {
        return Book.builder()
                .name(dto.getName())
                .isLoan(true)
                .build();
    }*/

}
