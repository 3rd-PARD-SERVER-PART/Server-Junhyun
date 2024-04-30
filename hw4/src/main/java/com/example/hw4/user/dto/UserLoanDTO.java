package com.example.hw4.user.dto;

import com.example.hw4.book.dto.BookReadDTO;
import com.example.hw4.book.entity.Book;
import com.example.hw4.user.entity.User;
import com.example.hw4.user.entity.UserLoanHistory;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserLoanDTO {
    @Getter
    @Setter
    public static class Create{
        private Long id;
        private boolean isReturn;
        private User user;
        private Book book;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)

    public static class Update{
        private String userName;
        private String bookName;
        private Long id;
        private boolean isReturn;
        private List<BookReadDTO> books;
        private List<UserDTO> users;

        public Update(UserLoanHistory userLoanHistory){
            this.isReturn = userLoanHistory.isReturn();
        }
        public Update(UserLoanHistory userLoanHistory, List<UserDTO> user){
            this.isReturn = userLoanHistory.isReturn();
            this.users = user;
        }
        public Update(UserLoanHistory userLoanHistory, List<UserDTO> user, List<BookReadDTO> books){
            this.id = userLoanHistory.getId();
            this.userName = userLoanHistory.getUser().getName();
            this.isReturn = userLoanHistory.isReturn();
            this.books = books;
        }
    }
}
