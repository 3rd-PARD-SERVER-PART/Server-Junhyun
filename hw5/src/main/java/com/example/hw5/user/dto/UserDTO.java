package com.example.hw5.user.dto;

import com.example.hw5.book.dto.BookReadDTO;
import com.example.hw5.user.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserDTO {

    @Getter
    @Setter
    public static class Create{
        private String name;
        private String email;

        public Create(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Read{
        private Long id;
        private String name;
        private String email;
        private List<BookReadDTO> books;

        public Read(User user){
            this.id = user.getUserId();
            this.name = user.getName();
            this.email = user.getEmail();
        }

        public Read(User user, List<BookReadDTO> books){
            this.id = user.getUserId();
            this.name = user.getName();
            this.email = user.getEmail();
            this.books = books;
        }
    }
}

