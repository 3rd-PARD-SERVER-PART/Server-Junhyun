package com.example.hw5.user.entity;

import com.example.hw5.book.entity.Book;
import com.example.hw5.user.dto.UserLoanDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false, name = "user_id")
    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false ,name = "book_id")
    private Book book;

    @ColumnDefault("0")
    private boolean isReturn;

    public static UserLoanHistory toEntity(UserLoanDTO.Create dto,User user, Book book){
        return UserLoanHistory.builder()
                .id(dto.getId())
                .user(user)
                .book(book)
                .isReturn(dto.isReturn())
                .build();
    }
    public void change(boolean loan){
        this.isReturn = loan;
    }

}
