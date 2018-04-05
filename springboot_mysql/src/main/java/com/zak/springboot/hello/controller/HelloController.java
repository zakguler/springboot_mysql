package com.zak.springboot.hello.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {

//	@RequestMapping("/hello")		// http://localhost:3000/hello
	@RequestMapping("/")			// http://localhost:3000/
	public String sayHi() {
		return "Springboot_mysql: Hi from spring boot";
	}
	
}
