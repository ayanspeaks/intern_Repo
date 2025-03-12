package com.test.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.test.model.Customer;

public class CustDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void createCustomer(Customer cst) {
		String sql = "insert into customer(cst_name, cst_type) values('"+cst.getName()+"', '"+cst.getType()+"')";
		
		jdbcTemplate.execute(sql);
	}
	
	public void updateCustomer(Customer cst) {
		String sql = "update customer set cst_name = '"+cst.getName()+"', cst_type = '"+cst.getType()
				+ "' WHERE id =" + cst.getId();
		jdbcTemplate.execute(sql);
	}
	
	//read customer data
	
	public List<Customer> getAllCustomers(){
		return jdbcTemplate.query("select * from customer1", new ResultSetExtractor<List<Customer>>() {
			{
				@Override
				public List<Customer> extractData(ResultSet rs) throws SQLException,
				DataAccessException{
					
					List<Customer> listData = new ArrayList<>();
					
					while(rs.next()) {
						Customer obj = new Customer();
						
						obj.setId(rs.getInt(1));
						obj.setName(rs.getString(2));
						obj.setType(rs.getString(3));
						
						listData.add(obj);
					}
					
					List<Customer> data = cst.getAllCustmers();
					
					for(Customer cstd : data) {
						System.out.println(cstd);
					}
					return listData;
				}
			}
		});
	}
	
	
}
