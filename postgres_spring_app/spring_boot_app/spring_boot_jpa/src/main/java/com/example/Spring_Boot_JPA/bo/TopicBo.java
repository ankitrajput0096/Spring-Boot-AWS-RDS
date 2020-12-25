package com.example.Spring_Boot_JPA.bo;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicBo {
    // Here, Bo => Business Object, which is used
    // at business layer(in service classes).

    @NotNull
    private String id;

    private String name;

    private String description;
}
