package com.zak.springboot.course.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zak.springboot.course.model.Course;
import com.zak.springboot.course.repository.CourseRepository;

@Service	//<================= business services are singleton
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
			.forEach(courses::add);
		return courses;
	}
	
//	public Course getCourse(String id) {
//		return courseRepository.findOne(id);
//	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}
		
	public void updateCourse(Course course) {
		courseRepository.save(course);	//<====== 'save' also does the add and the update
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}

}
