package com.example.hw5.book.service;

import com.example.hw5.book.dto.BookCreateDTO;
import com.example.hw5.book.dto.BookReadDTO;
import com.example.hw5.book.entity.Book;
import com.example.hw5.book.repo.BookRepo;
import com.example.hw5.user.dto.UserDTO;
import com.example.hw5.user.dto.UserLoanDTO;
import com.example.hw5.user.entity.User;
import com.example.hw5.user.entity.UserLoanHistory;
import com.example.hw5.user.repo.UserLoanRepo;
import com.example.hw5.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepo bookRepo;
    private final UserRepo userRepo;
    private final UserLoanRepo userLoanRepo;

    public void createBook(BookCreateDTO dto){
        bookRepo.save(Book.toEntity(dto));
    }
    public List<BookReadDTO> findAll(){
        return bookRepo.findAll()
                .stream()
                .map(book -> new BookReadDTO(book))
                .collect(Collectors.toList());
    }
}
