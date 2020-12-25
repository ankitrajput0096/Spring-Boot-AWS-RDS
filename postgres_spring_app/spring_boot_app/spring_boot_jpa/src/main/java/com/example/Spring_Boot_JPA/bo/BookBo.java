package com.example.Spring_Boot_JPA.bo;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookBo {

    private Integer id;

    @NotNull
    private String bookId;

    private String bookName;

    private BookMetadata bookMetadata;

    private Date createAt;
}
