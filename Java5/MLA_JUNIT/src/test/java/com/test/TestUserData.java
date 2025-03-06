package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.rules.ExpectedException;

public class TestUserData {
	
	@Test
	public void testUserNameIsNull() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				User data = new User();
				
				data.setName(null);
			}
		});
	}
	
	@Test
	public void testNameIsNull() {
		Throwable exception = assertThrows(IllegalArgunmentException.class, () -> {
			
			User obj = new User();
			
			obj.setName(null);
		});
		
		assertEquals("username can't be blank", exception.getMessage());
		System.out.println(exception.getMessage());
	}
	
	@Test
	public void testShortLength() {
		Throwable exception = assertThrows(IllegalArgunmentException.class, ()->{
			
			User obj = new User();
			
			obj.setName("ro");
		});
		
		assertEquals("name is too short", exception.getMessage());
		System.out.println(exception.getMessage());
	}
	
	@Test
	public void testLongLength() {
		Throwable exception = assertThrows(IllegalArgunmentException.class, ()->{
			
			User obj = new User();
			
			obj.setName("sgfwerjwktgjwerfqenkfgwelfekro");
		});
		
		assertEquals("name is too long", exception.getMessage());
		System.out.println(exception.getMessage());
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test(expected= IllegalArgumentException.class)
	public void testNameValues() {
		User obj = new User();
		
		obj.setName(null);
	}
	

}
