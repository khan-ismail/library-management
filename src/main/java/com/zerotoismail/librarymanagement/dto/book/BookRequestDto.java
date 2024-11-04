package com.zerotoismail.librarymanagement.dto.book;

import com.zerotoismail.librarymanagement.enums.BookGenreType;
import com.zerotoismail.librarymanagement.enums.BookStatus;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequestDto {
    private String title;
    private String author;
    private String publisher;
    private List<BookGenreType> genreTypes;
    private BookStatus bookStatus;
    private String isbn;
    private double pageSize;
}
