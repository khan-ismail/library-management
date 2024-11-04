package com.zerotoismail.librarymanagement.models;

import com.zerotoismail.librarymanagement.enums.BookGenreType;
import com.zerotoismail.librarymanagement.enums.BookStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book extends BaseModel{

    private String title;
    private String author;
    private String publisher;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<BookGenreType> genreTypes;

    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;


    @OneToMany(mappedBy = "book")
    private List<UserBorrowBook> borrowedBooks;

    private String isbn;
    private double pageSize;
}
