package com.test.dao;

import java.util.List;

import com.test.entity.Employee;

public interface EmployeeDao {
	
	public Employee createEmployee(Employee emp);
	
	public List<Employee> readAllEmployees();
	
	public List<Employee> updateEmployee(Employee emp);
	
	public List<Employee> deleteEmployee(int id);


}