package com.example.Spring_Boot_JPA.serviceInterface;

import java.util.List;

import com.example.Spring_Boot_JPA.bo.TopicBo;

public interface DataManagerTopic {

	List<TopicBo> getAllTopics();

    TopicBo getTopic(String id);

    void addTopic(TopicBo topicBo);

    void updateTopic(TopicBo topicBo, String id);

    void deleteTopic(String id);

	TopicBo getById(String id);

	TopicBo getByIdAndName(String id, String name);

    void saveTopic(TopicBo topicBo);
}
