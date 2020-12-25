package com.example.Spring_Boot_JPA.repository;


import com.example.Spring_Boot_JPA.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository
		extends JpaRepository<Topic,String> {
	
	@Query("SELECT top FROM Topic top WHERE top.id=:id")
	public Topic getById(@Param("id") String id);
	
	@Query("SELECT t FROM Topic t WHERE t.id=:id AND t.name=:name")
	public Topic getByIdAndName(
			@Param("id") String id,
			@Param("name") String name);
}
