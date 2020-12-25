package com.example.Spring_Boot_JPA.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

// NOTE : Prefer this way to create entity classes

@Entity
@Table(name="book")
// This will be the name to
// table to store 'book' objects in db.
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    // This will be the name of column to store
    // 'id' member field of book object in db table
    private Integer id;

    @NotNull
    @Column(name = "book_id", nullable = false, unique = true)
    // This will be the name of column to store
    // 'id' member field of book object in db table
    // and 'unique=true' field makes this column always have unique values
    private String bookId;

    @Column(name = "book_name")
    // This will be the name of column to store
    // 'name' member field of book object in db table
    private String name;

    // storing java object as string in db
    @Column(name = "book_metadata", columnDefinition = "text")
    private String bookMetadata;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    @LastModifiedDate
    private Date updatedAt;
}