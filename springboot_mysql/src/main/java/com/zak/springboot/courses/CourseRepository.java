package com.zak.springboot.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> //<=== String is the @Id in Topic class
{ 
	// [String property] use 'findBy[PROPERTY]' in this case 'Course.name'
	public List<Course> findByName(String anyName);	
	public List<Course> findByDescription(String desc);

	// [Object Topic]
	public List<Course> findByTopicId(String topicId);
	
}
