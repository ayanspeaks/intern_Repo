package com.test.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.util.Logger;
import reactor.util.Loggers;

@RestController
public class UserMicroServiceController {
	
	protected Logger logger = Loggers.getLogger(UserMicroServiceController.class.getName());
	
	@GetMapping("/testuser")
	public String userTestService() {
		logger.info("UserMicroService Execution");
		return "Simple Microservice Application";
	}
	
}
