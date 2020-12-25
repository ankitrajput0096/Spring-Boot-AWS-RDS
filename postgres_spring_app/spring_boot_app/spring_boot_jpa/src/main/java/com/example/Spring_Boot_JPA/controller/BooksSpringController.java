package com.example.Spring_Boot_JPA.controller;

import java.util.List;

import com.example.Spring_Boot_JPA.dto.BookDto;
import com.example.Spring_Boot_JPA.dto.TopicDto;
import com.example.Spring_Boot_JPA.service.BooksAndTopicsSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/springBootJpa")
public class BooksSpringController {

    @Autowired
    private BooksAndTopicsSpringService booksAndTopicsSpringService;

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET)
    public ResponseEntity<String> helloMethod() {
        return ResponseEntity.ok().body("hello friends");
    }

    @RequestMapping(value = "/topics")
    public ResponseEntity<List<TopicDto>> listOfTopics() {
        return ResponseEntity.ok().body(
                this.booksAndTopicsSpringService.getAllTopicsDtos());
    }

    @RequestMapping(value = "/topics/{id}")
    public ResponseEntity<TopicDto> getRequiredTopic(
            @PathVariable String id) {
        return ResponseEntity.ok().body(
                this.booksAndTopicsSpringService.getTopicDto(id));
    }

    //In this json object is sent
    /*
     * {
     * 		"topic_id":"java"
     * 		"topic_name":"java programming"
     * 		"topic_desc":"java is easy"
     * }
     */
    @RequestMapping(
            value = "/topics/add",
            method = RequestMethod.POST)
    public ResponseEntity<String> addTopic(
            @RequestBody TopicDto topicDto) {
        this.booksAndTopicsSpringService.addTopicDto(topicDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("the new topic is created with details :" +
                        topicDto.toString());
    }

    @RequestMapping(
            value = "/topics/update/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<String> updateTopic(
            @RequestBody TopicDto topicDto,
            @PathVariable String id) {
        this.booksAndTopicsSpringService.updateTopicDto(topicDto, id);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body("the existing topic is updated with details :" +
                        topicDto.toString());
    }

    //Url "localhost:8080/springBootJpa/topics/delete/java
    @RequestMapping(
            value = "/topics/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTopic(
            @PathVariable String id) {
        this.booksAndTopicsSpringService.deleteTopic(id);
        return ResponseEntity.ok()
                .body("the topic is successfully deleted with id : " +
                        id);
    }

    //Url "localhost:8080/springBootJpa/topics/getById?id=java
    @RequestMapping(
            value = "/topics/getById",
            method = RequestMethod.GET)
    public ResponseEntity<TopicDto> getById(
            @RequestParam(value = "id") String id) {
        return ResponseEntity.ok().body(
                this.booksAndTopicsSpringService.getByIdDto(id));
    }

    @RequestMapping(
            value = "/topics/getByIdAndName",
            method = RequestMethod.GET)
    public ResponseEntity<TopicDto> getByIdAndName(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "name") String name) {
        return ResponseEntity.ok().body(this.booksAndTopicsSpringService
                .getByIdAndNameDto(id, name));
    }


    @RequestMapping(value = "/books")
    public ResponseEntity<List<BookDto>> listOfBooks() {
        return ResponseEntity.ok().body(this.booksAndTopicsSpringService
                .getAllBookDtos());
    }

    @RequestMapping(value = "/books/{id}")
    public ResponseEntity<BookDto> getRequiredBook(
            @PathVariable String id) {
        return ResponseEntity.ok().body(this.booksAndTopicsSpringService
                .getBookDto(id));
    }

    //In this json object is sent
    /*
     * {
     * 		"book_id":"java_book"
     * 		"book_name":"java programming book"
     * }
     */
    @RequestMapping(
            value = "/books/add",
            method = RequestMethod.POST)
    public ResponseEntity<String> addBook(
            @RequestBody BookDto bookDto) {
        this.booksAndTopicsSpringService.addBookDto(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("the new book is created with details :" +
                        bookDto.toString());
    }

    @RequestMapping(
            value = "/books/update/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<String> updateBook(
            @RequestBody BookDto bookDto,
            @PathVariable String id) {
        this.booksAndTopicsSpringService.updateBookDto(bookDto, id);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body("the existing book is updated with details :" +
                        bookDto.toString());
    }

    //Url "localhost:8080/springBootJpa/books/delete/java
    @RequestMapping(
            value = "/books/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBook(@PathVariable String id) {
        this.booksAndTopicsSpringService.deleteBook(id);
        return ResponseEntity.ok()
                .body("the book is successfully deleted with id : " + id);
    }

    //---------------------- Api's to test @Transaction annotation ------------

    @RequestMapping(value = "/transaction/scenario_one")
    public ResponseEntity<String> transactionScenarioOne() {
        this.booksAndTopicsSpringService.transactionOne();
        return ResponseEntity.ok().body("Transaction scenario one : " +
                "testing roll back using Runtime error");
    }

    @RequestMapping(value = "/transaction/scenario_two")
    public ResponseEntity<String> transactionScenarioTwo() {
        try {
            this.booksAndTopicsSpringService.transactionTwo();
        } catch (Exception e) {
            // an error occurred and handled here.
        }
        return ResponseEntity.ok().body("Transaction scenario two : " +
                "testing roll back using java exception error");
    }

    @RequestMapping(value = "/transaction/scenario_three")
    public ResponseEntity<String> transactionScenarioThree() {
        try {
            this.booksAndTopicsSpringService.transactionThree();
        } catch (Exception e) {
            // an error occurred and handled here.
        }
        return ResponseEntity.ok().body("Transaction scenario three : " +
                "testing no roll back using java arithmetic exception error");
    }

    @RequestMapping(value = "/transaction/scenario_four")
    public ResponseEntity<String> transactionScenarioFour() {
        try {
            this.booksAndTopicsSpringService.transactionFour();
        } catch (Exception e) {
            // an error occurred and handled here.
        }
        return ResponseEntity.ok().body("Transaction scenario four : " +
                "testing roll back using java exception error for certain " +
                "db transaction on when exception is raised");
    }
}
