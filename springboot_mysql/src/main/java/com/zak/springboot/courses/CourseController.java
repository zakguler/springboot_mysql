package com.zak.springboot.courses;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zak.springboot.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
// http://localhost:8080/topics/{id}/courses
	
	@RequestMapping("/topics/{id}/courses")	//<==================================== "GET" request
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);				
	}
		
	
// http://localhost:8080/cources/spring
	
//	@RequestMapping("/topics/{topicId}/courses/{foo}")
//	public Topic getCourse(@PathVariable("foo") String id) {		
	@RequestMapping("/topics/{topicId}/courses/{id}")	//<============ "GET" is the default
	public Course getCourse(@PathVariable String id) {		
		return courseService.getCourse(id);	
	}

	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses") //<==== "POST" ADD new request
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}") //<==== "PUT" update request
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topis/{topicId}/courses/{id}") //<==== "DELETE" delete request
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
	
}
