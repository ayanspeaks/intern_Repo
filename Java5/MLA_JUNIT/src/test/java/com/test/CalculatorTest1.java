package com.test;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(value = 5, unit = TimeUnit.SECONDS)
public class CalculatorTest1 {
	
	Calculator obj;
	
	@Test
	@Timeout(value = 3, unit = TimeUnit.SECONDS)
	public void testAdd() {
		System.out.println("before sleep method");
		try {
			TimeUnit.SECONDS.sleep(5);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
