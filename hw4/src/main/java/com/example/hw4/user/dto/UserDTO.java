package com.example.hw4.user.dto;

import com.example.hw4.book.dto.BookReadDTO;
import com.example.hw4.user.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserDTO {
    @Getter
    @Setter
    public static class Create{
        private String name;
        private Integer age;
        private String major;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Read{
        private Long id;
        private String name;
        private Integer age;
        private String major;
        private List<BookReadDTO> books;

        public Read(User user){
            this.id = user.getUserId();
            this.name = user.getName();
            this.age = user.getAge();
            this.major = user.getMajor();
        }

        public Read(User user, List<BookReadDTO> books){
            this.id = user.getUserId();
            this.name = user.getName();
            this.age = user.getAge();
            this.major = user.getMajor();
            this.books = books;
        }
    }
}

