package com.example.Spring_Boot_JPA.repository;

import com.example.Spring_Boot_JPA.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository
        extends JpaRepository<Book,String> {

    Book findByBookId(final String bookId);

    void deleteByBookId(final String bookId);

}