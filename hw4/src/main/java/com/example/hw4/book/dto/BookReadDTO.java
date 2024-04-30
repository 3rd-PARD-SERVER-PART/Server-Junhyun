package com.example.hw4.book.dto;

import com.example.hw4.book.entity.Book;
import com.example.hw4.user.dto.UserDTO;
import com.example.hw4.user.dto.UserLoanDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class BookReadDTO {
    private Long bookId;
    private String name;
    private UserDTO.Read user;
    private UserLoanDTO loan;

    public BookReadDTO(Book book){
        this.bookId = book.getBookId();
        this.name = book.getName();
    }

    public BookReadDTO(Book book, UserDTO.Read user){
        this.bookId = book.getBookId();
        this.name = book.getName();
        this.user = user;
    }
    public BookReadDTO(Book book, UserLoanDTO.Update loan){
        this.bookId = book.getBookId();
        this.loan = getLoan();

    }
}
