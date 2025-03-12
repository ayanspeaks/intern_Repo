package com.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.CustDao;
import com.test.model.Customer;

public class StoreData {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		Customer obj = new Customer();
		obj.setName("Virat");
		obj.setType("Preferred");
		
		CustDao cst = ctx.getBean("custDao", CustDao.class);
//		cst.createCustomer(obj);
		
		
		Customer objUpdate = new Customer();
		obj.setName("Rahul");
		obj.setType("visiting");
		obj.setId(2);
		cst.updateCustomer(objUpdate);
		
		System.out.println("done updating in db");
		
		cst.updateCustomer(obj);
		
		System.out.println("Done.");
		
	}
}