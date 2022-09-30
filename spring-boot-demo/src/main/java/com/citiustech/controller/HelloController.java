package com.citiustech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
	public class HelloController {

	@GetMapping("/hello")
		public String hello() {
			return "Hello Everyone!!";
		}
	
	@GetMapping("/hello2")
	public String hello2(@RequestParam("name") String name) {
		return "Hello "+name.toUpperCase();
	}
	
	@GetMapping("/hello3")
	public String hello3(@MatrixVariable("name") String name) {
		return "Hello "+name.toUpperCase();
	}
	
	@GetMapping("/hello4")
	public String hello4(@PathVariable("name") String name) {
		return "Hello "+name.toUpperCase();
	}
	}
	
	

