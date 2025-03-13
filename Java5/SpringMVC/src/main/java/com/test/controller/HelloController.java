package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/homepage")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/greet")
	public String greetUser() {
		return "user";
	}

}
