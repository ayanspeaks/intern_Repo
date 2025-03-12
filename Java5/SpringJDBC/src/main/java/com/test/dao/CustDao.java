package com.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.test.model.Customer;

public class CustDao {
	
	public static void main(String[] args) {
	@Autowired
	public JdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private JdbcTemplate jdbcTemplate;
	
	public int createCustomer(Customer cst) {
		String sql = "insert into customer1 (cst_name, cst_type) values('"+cst.getName()+"', '"+cst.getType()+"')";
		
	     jdbcTemplate.execute(sql);
	}
	
	public int deleteCustomer(Customer cst) {
		
	}
	}
	
}
