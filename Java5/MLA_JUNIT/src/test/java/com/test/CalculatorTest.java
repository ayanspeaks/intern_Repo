package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	
	Calculator obj;
	
	static int x;
	static int y;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("BEFORE ALL THE TEST CASES ONLY ONE TIME");
		
		x = 10;
		y = 50;
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("AFTER ALL THE TEST CASES ONLY ONE TIME");
		
		x=0;
		y=0;
	}
	
	@Before
	public void setUp() {
		System.out.println("executes every test method before execution");
		
		obj = new Calculator();
	}
	
	@After
	public void setDown() {
		System.out.println("executes every test method after execution");
		
		obj = null;
	}
	
	@Test
	public void testAdd() {
		System.out.println("testAdd method");
		
	     	int rslt = obj.add(x,  y);
		
		assertEquals(60, rslt);
	}
	
	
	@Test
	public void testSub() {
		System.out.println("testSub method");
		
        int rslt = obj.sub(x,  y);
		
		assertEquals(-40, rslt);
	}
	
	@Test
	public void testMul() {
		System.out.println("testMul method");
		
        int rslt = obj.mul(x,  y);
		
		assertEquals(500, rslt);
	}
	
	@Test
	public void testGreetUser() {
		System.out.println("testGreetUser method");
		
		assertEquals("hi hello", obj.greetUser("hi hello"));
	}

}
