package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
	public class StdConfig{
		
		@Bean
		public static Student getStdObj() {
			return new Student();
		}
		
		@Bean
		public static Order getOrderObj() {
			return new Order(501, "lenovo", 234);
		}
		
	}

