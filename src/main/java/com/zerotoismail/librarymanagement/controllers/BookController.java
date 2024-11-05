package com.zerotoismail.librarymanagement.controllers;

import com.zerotoismail.librarymanagement.dto.book.BookRequestDto;
import com.zerotoismail.librarymanagement.models.Book;
import com.zerotoismail.librarymanagement.services.BookService;
import lombok.AllArgsConstructor;
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
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

//    @GetMapping("/books")
//    public ResponseEntity<Book> getBookById(@RequestParam UUID id){
//        Book book = bookService.getBookById(id);
//        return new ResponseEntity<>(book, HttpStatus.OK);
//    }
//
    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody BookRequestDto bookDto){
        Book book = bookService.createOrUpdateBook(null, bookDto.getTitle(), bookDto.getAuthor(),
                bookDto.getPublisher(), bookDto.getGenreTypes(), bookDto.getBookStatus(),
                bookDto.getIsbn(), bookDto.getPageSize());
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

//    @PutMapping("/books")
//    public ResponseEntity<Book> updateBook(@RequestParam UUID id, @RequestBody BookRequestDto bookDto){
//        Book book = bookService.createOrUpdateBook(id, bookDto.getTitle(), bookDto.getAuthor(),
//                bookDto.getPublisher(), bookDto.getGenreTypes(), bookDto.getBookStatus(),
//                bookDto.getIsbn(), bookDto.getPageSize());
//        return new ResponseEntity<>(book, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/books/{id}")
//    public ResponseEntity<Book> deleteBook(@PathVariable UUID id){
//        Book book = bookService.deleteBook(id);
//        return new ResponseEntity<>(book, HttpStatus.OK);
//    }
}
