package com.example.Spring_Boot_JPA.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDto {
    // Dto's are the object used to
    // return by controller to client request.

    @JsonProperty("book_id")
    @NotNull
    private String id;

    @JsonProperty("book_name")
    private String name;
}
