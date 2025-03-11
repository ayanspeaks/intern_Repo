package com.test;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeRecordConfig {

	@Bean
	public static EmployeeRecord getRecordObj() {
		return new EmployeeRecord(601, "Latham", Arrays.asList("Java-Core", "Java-fsd", "Java-SpringBoot", "JDBC"));
	}
}