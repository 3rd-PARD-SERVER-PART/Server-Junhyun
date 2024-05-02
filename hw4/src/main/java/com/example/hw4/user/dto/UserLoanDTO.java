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
        private Long userId;
        private Long bookId;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)

    public static class Update{
        private Long id;
        private boolean isReturn;
        private BookReadDTO book;
        private UserDTO.Read user;

        public Update(UserLoanHistory userLoanHistory){
            this.isReturn = userLoanHistory.isReturn();
        }
        public Update(UserLoanHistory userLoanHistory, UserDTO.Read user){
            this.isReturn = userLoanHistory.isReturn();
            this.user = user;
        }
        public Update(UserLoanHistory userLoanHistory, UserDTO.Read user, BookReadDTO book){
            this.id = userLoanHistory.getId();
            this.isReturn = userLoanHistory.isReturn();
            this.book = book;
            this.user = user;
        }
    }
}
