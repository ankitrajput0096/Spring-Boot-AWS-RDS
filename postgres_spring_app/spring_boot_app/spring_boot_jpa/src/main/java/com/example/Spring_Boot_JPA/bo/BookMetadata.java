package com.example.Spring_Boot_JPA.bo;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookMetadata {

    private String bookId;
    private String bookName;
}
