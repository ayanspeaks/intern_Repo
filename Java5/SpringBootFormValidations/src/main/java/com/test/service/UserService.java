package com.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.User;
import com.test.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public static List<User> tempdata = new ArrayList<>();
	
	static {
		String[] food= {"Breakfast", "Lunch", "Dinner"};
		String[] seat = {"M1", "M2", "L1", "L2", "U1", "U2"};
		
		tempdata.add(new User("Rohit", "Sharma", "male", food, "Kolkata", "Chennai", "15/02/2025", seat));
	}
	
	public User reservationRequest(User user) {
		tempdata.add(user);
		return repository.save(user);
	}
	
	public boolean validateCity(User user) {
		boolean ft = user.validate(user.getCityFrom(), user.getCityTo());
		return ft;
	}
}