package com.example.Spring_Boot_JPA.service;

import com.example.Spring_Boot_JPA.bo.BookBo;
import com.example.Spring_Boot_JPA.mappers.impl.BookBoEntityMapper;
import com.example.Spring_Boot_JPA.repository.BookRepository;
import com.example.Spring_Boot_JPA.serviceInterface.DataManagerBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersistentDataManagerBook
        implements DataManagerBook {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookBoEntityMapper bookBoEntityMapper;

    @Override
    @Transactional
    public List<BookBo> getAllBooks() {
        return this.bookRepository.findAll().stream()
                .map(e -> this.bookBoEntityMapper.toBo(e))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BookBo getBook(final String id) {
        return this.bookBoEntityMapper.toBo(
                this.bookRepository.findByBookId(id));
    }

    @Override
    @Transactional
    public void addBook(final BookBo bookBo) {
        this.bookRepository.save(this.bookBoEntityMapper.toEntity(bookBo));
    }

    @Override
    @Transactional
    public void updateBook(final BookBo bookBo, final String id) {
        BookBo entityBo = this.bookBoEntityMapper.toBo(
                this.bookRepository.findByBookId(id));
        entityBo.setBookMetadata(bookBo.getBookMetadata());
        entityBo.setBookId(bookBo.getBookId());
        entityBo.setBookName(bookBo.getBookName());
        this.bookRepository.save(
                this.bookBoEntityMapper.toEntity(entityBo));
    }

    @Override
    @Transactional
    public void deleteBook(final String id) {
        this.bookRepository.deleteByBookId(id);
    }
}
