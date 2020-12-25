package com.example.Spring_Boot_JPA.mappers.impl;

import com.example.Spring_Boot_JPA.bo.TopicBo;
import com.example.Spring_Boot_JPA.dto.TopicDto;
import com.example.Spring_Boot_JPA.mappers.DtoBoMapperIface;
import org.springframework.stereotype.Service;

@Service
public class TopicDtoBoMapper
        implements DtoBoMapperIface<TopicBo, TopicDto> {

    @Override
    public TopicBo toBo(TopicDto topicDto) {
        return TopicBo.builder()
                .id(topicDto.getId())
                .name(topicDto.getName())
                .description(topicDto.getDescription())
                .build();
    }

    @Override
    public TopicDto toDto(TopicBo topicBo) {
        return TopicDto.builder()
                .id(topicBo.getId())
                .name(topicBo.getName())
                .description(topicBo.getDescription())
                .build();
    }
}
