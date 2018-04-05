package com.zak.springboot.topic.repository;

import org.springframework.data.repository.CrudRepository;

import com.zak.springboot.topic.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, String>
{ 
	//<String is the @Id in Topic class
}
