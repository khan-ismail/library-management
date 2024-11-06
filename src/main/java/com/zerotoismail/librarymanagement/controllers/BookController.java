package com.zerotoismail.librarymanagement.controllers;

import com.zerotoismail.librarymanagement.dto.ResponseDto;
import com.zerotoismail.librarymanagement.dto.book.BookRequestDto;
import com.zerotoismail.librarymanagement.dto.book.BookResponseDto;
import com.zerotoismail.librarymanagement.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BookResponseDto>> getAllBooks(){
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable UUID id){
        BookResponseDto book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/books/search")
    public ResponseEntity<List<BookResponseDto>> searchBookByTitle(@RequestParam String title){
        List<BookResponseDto> book = bookService.searchBookByTitle(title);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto bookDto){
        BookResponseDto book = bookService.createOrUpdateBook(null, bookDto.getTitle(), bookDto.getAuthor(),
                bookDto.getPublisher(), bookDto.getGenreTypes(), bookDto.getBookStatus(),
                bookDto.getIsbn(), bookDto.getPageSize());
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookResponseDto> updateBook(@PathVariable UUID id, @RequestBody BookRequestDto bookDto){
        BookResponseDto book = bookService.createOrUpdateBook(id, bookDto.getTitle(), bookDto.getAuthor(),
                bookDto.getPublisher(), bookDto.getGenreTypes(), bookDto.getBookStatus(),
                bookDto.getIsbn(), bookDto.getPageSize());
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<ResponseDto> deleteBook(@PathVariable UUID id){
        boolean deleted = bookService.deleteBook(id);
        if(deleted){
            ResponseDto response = ResponseDto.builder()
                    .statusCode(HttpStatus.OK.value())
                    .message("Book deleted successfully").build();

            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
