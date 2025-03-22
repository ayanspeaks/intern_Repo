package com.test.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.EmployeeDao;
import com.test.entity.Employee;
import com.test.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private EmployeeRepository repository;
	
	
	@Override
	public Employee createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return repository.save(emp);
	}

	@Override
	public List<Employee> readAllEmployees() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Employee> updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		repository.save(emp);
		
		return repository.findAll();
	}

	@Override
	public List<Employee> deleteEmployee(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
		return repository.findAll();
	}


}
