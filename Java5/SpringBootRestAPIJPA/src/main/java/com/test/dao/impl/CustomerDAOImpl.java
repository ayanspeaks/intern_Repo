package com.test.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.CustomerDao;
import com.test.entity.Customer;
import com.test.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDao{

	@Autowired
	private CustomerRepository repository;
	
	
	@Override
	public Customer createCustomer(Customer cst) {
		// TODO Auto-generated method stub
		return repository.save(cst);
	}

	@Override
	public List<Customer> readAllCustomers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Customer> updateCustomer(Customer cst) {
		// TODO Auto-generated method stub
		repository.save(cst);
		
		return repository.findAll();
	}

	@Override
	public List<Customer> deleteCustomer(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
		return repository.findAll();
	}
	
	

}
