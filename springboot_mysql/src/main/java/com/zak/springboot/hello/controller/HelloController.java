package com.zak.springboot.hello.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(produces = { "application/json", "application/xml" })	//<=== not needed !!!
public class HelloController {

	@GetMapping("/hello")
	public String sayHi() {
//		return "Springboot_mysql: Hi from spring boot-99";
		return "Springboot_mysql: Hi from spring boot-99";
	}
	
}
