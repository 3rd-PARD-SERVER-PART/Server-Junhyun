package com.example.hw4.user.service;

import com.example.hw4.book.dto.BookReadDTO;
import com.example.hw4.book.entity.Book;
import com.example.hw4.book.repo.BookRepo;
import com.example.hw4.user.dto.UserDTO;
import com.example.hw4.user.dto.UserLoanDTO;
import com.example.hw4.user.entity.UserLoanHistory;
import com.example.hw4.user.repo.UserLoanRepo;
import com.example.hw4.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserLoanService {
    private final UserRepo userRepo;
    private final BookRepo bookRepo;
    private final UserLoanRepo userLoanRepo;

    public void createLoan(UserLoanDTO.Create dto){
        userLoanRepo.save(UserLoanHistory.toEntity(dto,
                userRepo.findById(dto.getUserId()).orElseThrow(),
                bookRepo.findById(dto.getBookId()).orElseThrow()));
    }

    public List<UserLoanDTO.Update> findAll(){
        return userLoanRepo.findAll()
                .stream()
                .map(userLoanHistory -> new UserLoanDTO.Update(userLoanHistory,
                        new UserDTO.Read(userLoanHistory.getUser()),
                        new BookReadDTO(userLoanHistory.getBook())))
                .collect(Collectors.toList());
    }

    public boolean checkBorrow(UserLoanDTO.Create dto){
        return bookRepo.findById(dto.getBookId()).get().isLoan();
    }// isloan값을 리턴하는 함수
    // userloandto를 받아 getbookId로 dto에 있는 bookId 받고, bookId로 해당 bookId의 isLoan값을 받아 리턴한다.

    public boolean checkReturn(UserLoanDTO.Create dto){
        if(!checkBorrow(dto)) return true;
        else return false;
    } //책이 반납상태인지 확인

    public void changeBookLoanToUserLoanDTO(UserLoanDTO.Create dto,boolean loan){
        Book book = bookRepo.findById(dto.getBookId()).orElseThrow();
        book.change(loan);
        bookRepo.save(book);
    }//book의 isloan값을 바꾸는 함수
    //UserLoanDto를 받아 getBookId로 dto로 book 객채를 만들고 book entity에서 만든 change메소드로 isloan값을 바꾸고 save한다.

    public boolean check(Long loanKey){
        UserLoanHistory userLoanHistory = userLoanRepo.findById(loanKey).orElseThrow(()-> new IllegalArgumentException("Book not found"));
        return userLoanHistory.isReturn();
    }//userLoanHistory의 isReturn값을 리턴
    //Book Id를 받아 UserLoan에 있는 해당 book id를 가진 loan 상태를 return한다.

    public void changeUserLoan(Long loanKey,boolean loan){
        UserLoanHistory userLoanHistory = userLoanRepo.findById(loanKey).orElseThrow();
        userLoanHistory.change(loan);
        userLoanRepo.save(userLoanHistory);
    }//userLoan의 loan 값을 바꿈
    //Book Id랑 boolean값을 받고 UserLoan 테이블에서 bookId를 가진 값의 loan값을 입력받은 boolean값으로 바꾼다.

    public void changeBookLoanToBookId(Long loanKey,boolean loan){
        long bookId = userLoanRepo.findById(loanKey).orElseThrow().getBook().getBookId();
        Book book = bookRepo.findById(bookId).orElseThrow();
        book.change(loan);
        bookRepo.save(book);
    }// book의 isloan값을 바꿈
    //loanKey값을 이용해 userLoanRepo에서 bookId값을 찾고 찾은 bookId로 book객채를 생성하고 loan값을 바꾼뒤 save한다.
}
