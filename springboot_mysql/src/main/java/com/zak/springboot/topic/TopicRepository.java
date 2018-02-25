package com.zak.springboot.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String>
{ 
	//<String is the @Id in Topic class
}
