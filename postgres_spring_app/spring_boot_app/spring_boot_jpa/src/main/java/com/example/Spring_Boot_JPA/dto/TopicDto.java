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
public class TopicDto {

    @NotNull
    @JsonProperty(value = "topic_id")
    private String id;

    @JsonProperty(value = "topic_name")
    private String name;

    @JsonProperty(value = "topic_desc")
    private String description;
}
