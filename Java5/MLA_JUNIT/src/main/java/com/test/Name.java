package com.test;

public class Name {
	
	public void setName(String name) {
		if(name == null || name.isBlank()) throw new IllegalArgumentException("username can't be blank");
		
		if(name.length() < 3) throw new IllegalArgumentException("Name is too short");
	}

}
