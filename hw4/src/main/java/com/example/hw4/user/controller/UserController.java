package com.example.hw4.user.controller;

import com.example.hw4.user.dto.UserDTO;
import com.example.hw4.user.dto.UserLoanDTO;
import com.example.hw4.user.entity.UserLoanHistory;
import com.example.hw4.user.service.UserLoanService;
import com.example.hw4.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserLoanService userLoanService;

    @PostMapping("")
    @Operation(summary = "유저등록",description = "이름,학번,나이를 통해 유저를 생성합니다.")
    public String createUser(@RequestBody UserDTO.Create dto){
        userService.createUser(dto);
        return "user create success";
    }

    @GetMapping("")
    @Operation(summary = "유저리스트 불러오기",description = "유저의 정보를 담은 리스트를 출력합니다.")
    public List<UserDTO.Read> readAll(){
        return userService.readAll();
    }

    @GetMapping("/loan")
    @Operation(summary = "도서대출기록 출력하기.",description = "대출 순서, 책정보, 유저정보, 반납여부를 출력합니다.")
    public List<UserLoanDTO.Update> findAll(){
        return userLoanService.findAll();
    }

    @PostMapping("/borrow")
    @Operation(summary = "책 빌리기",description = "빌리려는 유저 id, 빌리고싶은 책 id를 통해 책을 빌립니다.")
    public String borrowBook(@RequestBody UserLoanDTO.Create dto){
        return userLoanService.printBorrowResult(dto);
    }

    @PostMapping("/return")
    @Operation(summary = "책 반납하기",description = "user_loan_history key를 통해 책을 반납합니다.")
    public String returnBook(@RequestParam Long loanKey){
        return userLoanService.printReturnResult(loanKey);
    }

    @GetMapping("/search")
    public UserLoanDTO.Update findById(@RequestParam Long id){
        return userLoanService.findById(id);
    }

    /*
    public String returnBook(@PathVariable Long bookId){
        if(userLoanService.check(bookId)) return "already return";
        else if(!userLoanService.check(bookId)){
            userLoanService.changeUserLoan(bookId,true);
            userLoanService.changeBookLoanToBookId(bookId,false);
            return "return success";
        }
        return "";
    }//bookId를 통해서 책을 반납하기 근데 이걸로하면
    한 유저가 같은 책을 빌리고 반납 후 다시 빌릴수가 없음
    */

}
