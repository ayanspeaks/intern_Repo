package com.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.CustDao;
import com.test.model.Customer;

public class StoreData {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		Customer obj = new Customer();
		
		obj.setName("Ayan");
		obj.setType("Regular");
		
		CustDao cst = ctx.getBean("custDao", CustDao.class);
				
		cst.createCustomer(obj);
	}

}
