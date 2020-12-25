package com.example.Spring_Boot_JPA.service;

import com.example.Spring_Boot_JPA.bo.BookBo;
import com.example.Spring_Boot_JPA.bo.BookMetadata;
import com.example.Spring_Boot_JPA.bo.TopicBo;
import com.example.Spring_Boot_JPA.dto.BookDto;
import com.example.Spring_Boot_JPA.dto.TopicDto;
import com.example.Spring_Boot_JPA.mappers.impl.BookDtoBoMapper;
import com.example.Spring_Boot_JPA.mappers.impl.TopicDtoBoMapper;
import com.example.Spring_Boot_JPA.serviceInterface.BooksAndTopicsSpringIface;
import com.example.Spring_Boot_JPA.serviceInterface.DataManagerBook;
import com.example.Spring_Boot_JPA.serviceInterface.DataManagerTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksAndTopicsSpringService
        implements BooksAndTopicsSpringIface {

    @Autowired
    private DataManagerTopic dataManagerTopic;

    @Autowired
    private DataManagerBook dataManagerBook;

    @Autowired
    private TopicDtoBoMapper topicDtoBoMapper;

    @Autowired
    private BookDtoBoMapper bookDtoBoMapper;

    public List<TopicBo> getAllTopics() {
        return this.dataManagerTopic.getAllTopics();
    }

    public List<TopicDto> getAllTopicsDtos() {
        return this.getAllTopics().stream()
                .map(e -> this.topicDtoBoMapper.toDto(e))
                .collect(Collectors.toList());
    }

    public TopicBo getTopic(String id) {
        return this.dataManagerTopic.getTopic(id);
    }

    public TopicDto getTopicDto(String id) {
        return this.topicDtoBoMapper.toDto(this.getTopic(id));
    }

    public void addTopic(TopicBo topicBo) {
        this.dataManagerTopic.addTopic(topicBo);
    }

    public void addTopicDto(TopicDto topicDto) {
        this.addTopic(this.topicDtoBoMapper.toBo(topicDto));
    }

    public void updateTopic(TopicBo topicBo, String id) {
        this.dataManagerTopic.updateTopic(topicBo, id);
    }

    public void updateTopicDto(TopicDto topicDto, String id) {
        this.updateTopic(this.topicDtoBoMapper.toBo(topicDto), id);
    }

    public void deleteTopic(String id) {
        this.dataManagerTopic.deleteTopic(id);
    }

    public TopicBo getById(String id) {
        return this.dataManagerTopic.getById(id);
    }

    public TopicDto getByIdDto(String id) {
        return this.topicDtoBoMapper.toDto(this.getById(id));
    }

    public TopicBo getByIdAndName(String id, String name) {
        return this.dataManagerTopic.getByIdAndName(id, name);
    }

    public TopicDto getByIdAndNameDto(String id, String name) {
        return this.topicDtoBoMapper.toDto(this.getByIdAndName(id, name));
    }

    public List<BookBo> getAllBooks() {
        return this.dataManagerBook.getAllBooks();
    }

    public List<BookDto> getAllBookDtos() {
        return this.getAllBooks().stream()
                .map(e -> this.bookDtoBoMapper.toDto(e))
                .collect(Collectors.toList());
    }

    public BookBo getBook(String id) {
        return this.dataManagerBook.getBook(id);
    }

    public BookDto getBookDto(String id) {
        return this.bookDtoBoMapper.toDto(this.getBook(id));
    }

    public void addBook(BookBo bookBo) {
        // setting metadata for the bookBo
        bookBo.setBookMetadata(BookMetadata.builder()
                .bookId(bookBo.getBookId())
                .bookName(bookBo.getBookName())
                .build());
        this.dataManagerBook.addBook(bookBo);
    }

    public void addBookDto(BookDto bookDto) {
        this.addBook(this.bookDtoBoMapper.toBo(bookDto));
    }

    public void updateBook(BookBo bookBo, String id) {
        bookBo.setBookMetadata(BookMetadata.builder()
                .bookId(bookBo.getBookId())
                .bookName(bookBo.getBookName())
                .build());
        this.dataManagerBook.updateBook(bookBo, id);
    }

    public void updateBookDto(BookDto bookDto, String id) {
        this.updateBook(this.bookDtoBoMapper.toBo(bookDto), id);
    }

    public void deleteBook(String id) {
        this.dataManagerBook.deleteBook(id);
    }

    @Transactional
    public void transactionOne() {
        // db statement one
        this.dataManagerTopic.addTopic(TopicBo.builder()
                .id("topic_1")
                .name("topic_1_name")
                .description("topic_1_description")
                .build());
        // db statement two
        this.dataManagerBook.addBook(BookBo.builder()
                .bookId("book_1_id")
                .bookName("book_1_name")
                .build());

        // Some more logic here, then throw runtime error
        throw new RuntimeException("This is runtime error");

        // So, both db statements one and two will be rolled back.
    }

    @Transactional(timeout = 10000,
            // This will make function wait only
            // 10 seconds to fetch data from db,
            // if it takes more than 10 seconds
            // then it will throw error
    rollbackFor = Exception.class)
    // Can also use any other custom error class
    public void transactionTwo() throws Exception{
        // db statement one
        this.dataManagerTopic.addTopic(TopicBo.builder()
                .id("topic_2")
                .name("topic_2_name")
                .description("topic_2_description")
                .build());
        // db statement two
        this.dataManagerBook.addBook(BookBo.builder()
                .bookId("book_2_id")
                .bookName("book_2_name")
                .build());

        // Some more logic here, then throw 'Exception' error
        throw new Exception("this is exception class");

        // So, both db statements one and two will be rolled back.
    }

    @Transactional(timeout = 10000,
            // This will make function wait only 10
            // seconds to fetch data from db,
            // if it takes more than 10 seconds then it will throw error
            rollbackFor = Exception.class,
            // Can also use any other custom error class
            noRollbackFor = ArithmeticException.class)
    // If error thrown is 'ArithmeticException'
    // then, we don't want to roll back db statements
    public void transactionThree() throws Exception {
        // db statement one
        this.dataManagerTopic.addTopic(TopicBo.builder()
                .id("topic_3")
                .name("topic_3_name")
                .description("topic_3_description")
                .build());
        // db statement two
        this.dataManagerBook.addBook(BookBo.builder()
                .bookId("book_3_id")
                .bookName("book_3_name")
                .build());

        // Some more logic here, then throw 'Arithmetic' error
        throw new ArithmeticException("this is an arithmetic " +
                "exception, so no roll back for db");
        // So, both db statements one and two will not be rolled back.
    }

    @Transactional(timeout = 10000,
            // This will make function wait only
            // 10 seconds to fetch data from db,
            // if it takes more than 10 seconds
            // then it will throw error
            rollbackFor = Exception.class,
            // Can also use any other custom error class
            noRollbackFor = ArithmeticException.class,
            // If error thrown is 'ArithmeticException'
            // then, we don't want to roll back db statements
            propagation = Propagation.REQUIRED)
    // With This annotation, the transaction
    // will happen in same single Transaction.
    public void transactionFour() throws Exception {
        // db statement one - Audit entry which you want in db,
        // even if there is exception raised in this function on
        // later lines and roll back other db transaction but not this one.
        this.dataManagerTopic.saveTopic(TopicBo.builder()
                // This function will execute in
                // different transaction, so will not be rolled back
                .id("topic_4")
                .name("topic_4_name")
                .description("topic_4_description")
                .build());
        // db statement two
        this.dataManagerBook.addBook(BookBo.builder()
                .bookId("book_4_id")
                .bookName("book_4_name")
                .build());

        // Some more logic here, then throw 'Exception' error
        throw new Exception("this is an exception error, so " +
                "db statement two will be rolled back from db");

        // So, db statement one will not be rolled back but
        // db statement two will be rolled back.
    }

}
