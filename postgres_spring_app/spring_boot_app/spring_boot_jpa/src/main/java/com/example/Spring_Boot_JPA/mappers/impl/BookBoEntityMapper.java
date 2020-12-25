package com.example.Spring_Boot_JPA.mappers.impl;

import com.example.Spring_Boot_JPA.bo.BookBo;
import com.example.Spring_Boot_JPA.bo.BookBo.BookBoBuilder;
import com.example.Spring_Boot_JPA.bo.BookMetadata;
import com.example.Spring_Boot_JPA.entity.Book;
import com.example.Spring_Boot_JPA.entity.Book.BookBuilder;
import com.example.Spring_Boot_JPA.mappers.BoEntityMapperIface;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@Service
public class BookBoEntityMapper
        implements BoEntityMapperIface<BookBo, Book> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public BookBo toBo(Book book) {
        BookBoBuilder bookBoBuilder = BookBo.builder()
                .id(book.getId())
                .bookId(book.getName())
                .bookName(book.getName())
                .createAt(book.getCreatedAt());

        if(Objects.nonNull(book.getBookMetadata())) {
            try {
                bookBoBuilder.bookMetadata(
                        this.objectMapper.readValue(book.getBookMetadata(),
                                BookMetadata.class));

            } catch (IOException ex) {
                log.error("Error while converting metadata", ex);
            }
        }
        return bookBoBuilder.build();

    }

    @Override
    public Book toEntity(BookBo bookBo) {
        BookBuilder bookBuilder = Book.builder()
                .id(bookBo.getId())
                .bookId(bookBo.getBookId())
                .name(bookBo.getBookName())
                .createdAt(bookBo.getCreateAt());
        if(Objects.nonNull(bookBo.getBookMetadata())) {
            try {
                bookBuilder.bookMetadata(this.objectMapper
                .writeValueAsString(bookBo.getBookMetadata()));
            } catch (IOException ex) {
                log.error("Error while converting metadata", ex);
            }
        }
        return bookBuilder.build();
    }
}
