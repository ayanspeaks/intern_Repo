package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.User;
import com.test.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository repository;

	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) {
		return repository.save(user);
	}
	
	
	@GetMapping("/byemail/{email}")
	public User findUserByEmail(@PathVariable("email") String email) {
		return repository.getUserByEmail(email);
	}
	
	@GetMapping("/byfname/{fname}")
	public List<User> findUsersByFirstName(@PathVariable("fname") String firstName){
		return repository.getUserByEndsWith(firstName);
	}
	
	@GetMapping("/getalluser")
	public List<User> getAllUsers(){
		return repository.getAllUsers();
	}

}
