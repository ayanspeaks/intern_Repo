package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.RemoteUserService;

@RestController
public class MicroServiceClientController {
	
	@Autowired
	private RemoteUserService service;
	
	@GetMapping("/")
	public String getUserResponseTest() {
		return service.getUserResponse();
	}

}
