package com.example.Spring_Boot_JPA.mappers.impl;

import com.example.Spring_Boot_JPA.bo.BookBo;
import com.example.Spring_Boot_JPA.dto.BookDto;
import com.example.Spring_Boot_JPA.mappers.DtoBoMapperIface;
import org.springframework.stereotype.Service;

@Service
public class BookDtoBoMapper
        implements DtoBoMapperIface<BookBo, BookDto> {

    @Override
    public BookBo toBo(BookDto bookDto) {
        return BookBo.builder()
                .bookId(bookDto.getId())
                .bookName(bookDto.getName())
                .build();
    }

    @Override
    public BookDto toDto(BookBo bookBo) {
        return BookDto.builder()
                .id(bookBo.getBookId())
                .name(bookBo.getBookName())
                .build();
    }
}
