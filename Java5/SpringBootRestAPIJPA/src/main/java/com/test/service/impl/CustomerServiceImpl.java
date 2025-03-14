package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.CustomerDao;
import com.test.entity.Customer;
import com.test.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer createCustomer(Customer cst) {
		// TODO Auto-generated method stub
		
		try {
			if(cst != null) {
				customerDao.createCustomer(cst);
			}
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		return cst;
	}

	@Override
	public List<Customer> readAllCustomers() {
		
		List<Customer> list = customerDao.readAllCustomers();
		
		if(list.size() < 0) {
			System.out.println("no content");
		}
		
		return list;
	}

	@Override
	public List<Customer> updateCustomer(Customer cst) {
		
		try {
			if(cst != null) {
				customerDao.updateCustomer(cst);
			}
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		
		return customerDao.readAllCustomers();
	}

	@Override
	public List<Customer> deleteCustomer(int id) {
		
		try {
			if(id != 0) {
				customerDao.deleteCustomer(id);
			}
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		
		return customerDao.readAllCustomers();
	}
	

}
