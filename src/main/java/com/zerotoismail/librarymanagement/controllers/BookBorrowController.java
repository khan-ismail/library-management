package com.zerotoismail.librarymanagement.controllers;

import com.zerotoismail.librarymanagement.dto.ResponseDto;
import com.zerotoismail.librarymanagement.dto.UserRequestBorrowBookDto;
import com.zerotoismail.librarymanagement.services.UserBorrowBookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BookBorrowController {

    private UserBorrowBookService userBorrowBookService;

    @PostMapping("/borrow")
    public ResponseEntity<?> borrowBook(@RequestBody UserRequestBorrowBookDto borrowDto){
        boolean borrowed =  userBorrowBookService.borrowBook(
                borrowDto.getBookId(),
                borrowDto.getUserId(),
                borrowDto.getBorrowDate(),
                borrowDto.getReturnDate());

        if(borrowed){
            ResponseDto responseDto = ResponseDto.builder()
                    .statusCode(HttpStatus.OK.value())
                    .message("Book borrowed successfully").build();
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PostMapping("/return")
    public ResponseEntity<?> returnBook(@RequestBody UserRequestBorrowBookDto borrowDto){
        boolean returned = userBorrowBookService.returnBook(
                borrowDto.getBookId(),
                borrowDto.getUserId(),
                borrowDto.getReturnDate());

        if(returned){
            ResponseDto responseDto = ResponseDto.builder()
                    .statusCode(HttpStatus.OK.value())
                    .message("Book returned successfully").build();
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
