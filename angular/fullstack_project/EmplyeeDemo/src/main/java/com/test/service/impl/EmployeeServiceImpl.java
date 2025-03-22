package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.EmployeeDao;
import com.test.entity.Employee;
import com.test.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao customerDao;

	@Override
	public Employee createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		try {
			if(emp != null) {
				customerDao.createEmployee(emp);
			}
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Employee> readAllEmployees() {
		
		List<Employee> list = customerDao.readAllEmployees();
		
		if(list.size() < 0) {
			System.out.println("no content");
		}
		
		return list;
	}

	@Override
	public List<Employee> updateEmployee(Employee cst) {
		
		try {
			if(cst != null) {
				customerDao.updateEmployee(cst);
			}
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		
		return customerDao.readAllEmployees();
	}

	@Override
	public List<Employee> deleteEmployee(int id) {
		
		try {
			if(id != 0) {
				customerDao.deleteEmployee(id);
			}
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		
		return customerDao.readAllEmployees();
	}
	

}
