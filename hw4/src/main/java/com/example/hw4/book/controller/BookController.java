package com.example.hw4.book.controller;

import com.example.hw4.book.dto.BookCreateDTO;
import com.example.hw4.book.dto.BookReadDTO;
import com.example.hw4.book.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("")
    @Operation(summary = "책 등록",description = "이름을 통해 책을 생성합니다.")
    public String createBook(@RequestBody BookCreateDTO dto){
        bookService.createBook(dto);
        return "create book success";
    }

    @GetMapping("")
    @Operation(summary = "책 목록 불러오기",description = "책 리스트를 출력합니다.")
    public List<BookReadDTO> findAll(){
        return bookService.findAll();
    }
}
