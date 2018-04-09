package com.zak.springboot.topic.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zak.springboot.topic.model.Topic;
import com.zak.springboot.topic.service.TopicService;

@RestController
//@RequestMapping(produces = { "application/json", "application/xml" })	//<=== not needed !!!
//@RequestMapping("/rest")	//<=== http://localhost:8080/rest..... rest/topics... rest/topics/{id}
public class TopicController {

	@Autowired
	private TopicService topicService;
	
// http://localhost:3000/topics
	
	@GetMapping("/topics")	//<==================================== "GET" request
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();				
	}
		
	
// http://localhost:8080/topics/spring
	
//	@RequestMapping("/topics/{foo}")
//	public Topic getTopic(@PathVariable("foo") String id) {		
//	public Topic getTopic(@PathVariable String id) {		
//		return topicService.getTopic(id);
//	}
//--
//	@GetMapping("/topics/{id}")
//	public ResponseEntity<Topic> getTopic(@PathVariable String id) {		
//		return ResponseEntity.ok(topicService.getTopic(id));
//	}
	//--
	@GetMapping("/topics/{id}")
	public @ResponseBody ResponseEntity<Topic> getTopic(@PathVariable String id) {		
		return new ResponseEntity<Topic>(topicService.getTopic(id), HttpStatus.OK);
	}

//	@RequestMapping(method=RequestMethod.POST, value="/topics") //<==== "POST" ADD new request
//	public void addTopic(@RequestBody Topic topic) {
//		topicService.addTopic(topic);
//	}	
	@PostMapping("/topics") //<==== "POST" ADD new request
	public ResponseEntity<Object> addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return new ResponseEntity<Object>("POST Response", HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}") //<==== "PUT" update request
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}") //<==== "DELETE" delete request
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	
}
