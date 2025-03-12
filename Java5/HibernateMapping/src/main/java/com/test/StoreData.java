package com.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	public static void main(String[] args) {
		//1. create configuration class object
				Configuration cfg = new Configuration();
				cfg.configure("hibernate.cfg.xml");
				
				//2. create SessionFactory Object
				SessionFactory sf = cfg.buildSessionFactory();
				
				//3.create session object
				Session session = sf.openSession();
				
				//4.transaction object
				Transaction t = session.beginTransaction();
				
				//transient state
//				Address adr1= new Address();
//				adr1.setCity("Chennai");
//				adr1.setState("TN");
//				adr1.setCountry("India");
//				
//				Employee e = new Employee();
//				e.setEmp_name("Rohit");
//				e.setEmp_email("rohit@example.com");
//				e.setAddress(adr1);
//				adr1.setEmployee(e);
				
				Skills skl1 = new Skills();
				skl1.setS_name("Spring");

				Skills skl2 = new Skills();
				skl2.setS_name("Hibernate");
				
				List<Skills> listSkl = new ArrayList<>();
				listSkl.add(skl1);
				listSkl.add(skl2);
				
				Student std = new Student();
				std.setStd_name("Rohit");
				std.setSkills(listSkl);
				
				
				//5 execute the object
				session.save(std);	//persistent state
				
				t.commit();	//inserting
				
				System.out.println("Done");
				
				//6. close session object
				session.close();//detached state
	}
}