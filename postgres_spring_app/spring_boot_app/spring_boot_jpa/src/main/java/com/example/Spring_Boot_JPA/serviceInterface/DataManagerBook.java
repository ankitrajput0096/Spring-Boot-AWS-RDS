package com.example.Spring_Boot_JPA.serviceInterface;

import com.example.Spring_Boot_JPA.bo.BookBo;

import java.util.List;

public interface DataManagerBook {

    List<BookBo> getAllBooks();

    BookBo getBook(final String id);

    void addBook(final BookBo bookBo);

    void updateBook(final BookBo bookBo, final String id);

    void deleteBook(final String id);
}
