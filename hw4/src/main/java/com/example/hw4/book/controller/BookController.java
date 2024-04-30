package com.example.hw4.book.controller;

import com.example.hw4.book.dto.BookCreateDTO;
import com.example.hw4.book.dto.BookReadDTO;
import com.example.hw4.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("")
    public String createBook(@RequestBody BookCreateDTO dto){
        bookService.createBook(dto);
        return "success";
    }

    @GetMapping("")
    public List<BookReadDTO> findAll(){
        return bookService.findAll();
    }
}
