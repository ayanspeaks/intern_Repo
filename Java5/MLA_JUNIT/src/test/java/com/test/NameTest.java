package com.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NameTest {
	
	@Test
	void testNameIsNull() {
		assertThrows(IllegalArgumentException.class, () ->
		new User().setName(null), "username can't be blank");
	}
	
	@Test
	void testShortLength() {
		assertThrows(IllegalArgumentException.class, () ->
		new User().setName("no"), "name is too short");
	}

}
