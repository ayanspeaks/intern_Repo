package com.test;

public class User {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
		if(name == null) {
			throw new IllegalArgumentException("username can't be blank");
		} else {
			if(name.length() < 3) {
				throw new IllegalArgumentException("name is too short");
			} else if(name.length() > 30){
				throw new IllegalArgumentException("name is too long");
			}
		}
		this.name= name;
	}

}
