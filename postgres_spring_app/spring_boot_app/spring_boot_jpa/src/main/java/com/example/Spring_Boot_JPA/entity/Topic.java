package com.example.Spring_Boot_JPA.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Topic")
public class Topic {
	
	@Id
	@NotNull
	@Column(name="topic_id")
	private String id;
	
	@Column(name="topic_name")
	private String name;
	
	@Column(name="topic_desc")
	private String description;
	
	public Topic() {
	}

	public Topic(
			String id,
			String name,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString()
	{
		return "[id :"+id+", name :"+name+", description :"+description+"]";
	}
}
