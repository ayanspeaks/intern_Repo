package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Employee;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional(value = TxType.REQUIRED)
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	

}