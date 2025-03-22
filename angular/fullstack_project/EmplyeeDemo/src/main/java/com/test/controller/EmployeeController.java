package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Employee;
import com.test.service.EmployeeService;

@RestController
@RequestMapping("/employee/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	public void setService(EmployeeService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee emp) {
		return service.createEmployee(emp);
	}
	
	@GetMapping("/listall")
	public List<Employee> listAllEmployees(){
		return service.readAllEmployees();
	}
	
	@PutMapping("/update/{id}")
	public List<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable int id){
		emp.setId(id);
		
		return service.updateEmployee(emp);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Employee> deleteEmployee(@PathVariable("id")int id){
		return service.deleteEmployee(id);
	}

}
