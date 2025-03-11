package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
	public static void main(String[] args) {
		
		System.out.println("Using Annotation");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(EmployeeRecordConfig.class);
		EmployeeRecord obj =ctx.getBean("getRecordObj", EmployeeRecord.class);
		System.out.println(obj);
		
		
		System.out.println("\nUsing beans");
		ApplicationContext ctxBeans = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeRecord obj2 = ctxBeans.getBean("getEmpBean3", EmployeeRecord.class);
		System.out.println(obj2);
	}
}