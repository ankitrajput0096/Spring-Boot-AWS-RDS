package com.example.Spring_Boot_JPA.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.Spring_Boot_JPA.bo.TopicBo;
import com.example.Spring_Boot_JPA.mappers.impl.TopicBoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Spring_Boot_JPA.repository.TopicRepository;
import com.example.Spring_Boot_JPA.serviceInterface.DataManagerTopic;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersistentDataManagerTopic
        implements DataManagerTopic {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicBoEntityMapper topicBoEntityMapper;

    // With @Transaction, if any Runtime Error is thrown then,
    // this db action will be rolled back (default functionality)
    @Transactional(readOnly = true,
            // will make sure the result is only for
            // reading and not to update or delete
            timeout = 10000)
    // will wait for 10 sec for db fetch result or else throw error
    public List<TopicBo> getAllTopics() {
        return topicRepository.findAll().stream()
                .map(e -> this.topicBoEntityMapper.toBo(e))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TopicBo getTopic(String id) {
        return this.topicBoEntityMapper.toBo(topicRepository.findOne(id));
    }

    @Transactional(readOnly = false)
    public void addTopic(TopicBo topicBo) {
        topicRepository.save(this.topicBoEntityMapper.toEntity(topicBo));
    }

    @Transactional(readOnly = false,
    propagation = Propagation.REQUIRES_NEW)
    // As propagation is set to 'REQUIRES_NEW', So,
    // this function will be executed in New db transaction
    public void saveTopic(TopicBo topicBo) {
        topicRepository.save(this.topicBoEntityMapper.toEntity(topicBo));
    }

    @Transactional(readOnly = false)
    public void updateTopic(TopicBo topicBo, String id) {
        topicRepository.delete(id);
        topicRepository.save(this.topicBoEntityMapper.toEntity(topicBo));
    }

    @Transactional(readOnly = false)
    public void deleteTopic(String id) {
        topicRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public TopicBo getById(String id) {
        return this.topicBoEntityMapper.toBo(topicRepository.getById(id));
    }

    @Transactional(readOnly = true)
    public TopicBo getByIdAndName(String id, String name) {
        return this.topicBoEntityMapper.toBo(
                topicRepository.getByIdAndName(id, name));
    }
}
