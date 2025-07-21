package com.spring_boot.spring_boot.Learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${welcome.message}")
	public String msg;
	
	@GetMapping("/")
	public String helloWorld() {
		return msg;
	}
	
}