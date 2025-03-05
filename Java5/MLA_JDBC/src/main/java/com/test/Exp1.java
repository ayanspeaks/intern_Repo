package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exp1 {
	
	public static void main(String a[]) {
		
		try
		{
			//1. load the driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. create connection object
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Maven", "root", "root@39");
			
			//3. create statement object
		    Statement stmt = con.createStatement();
		    
		    //SQL query
		    //String sql = "create table movies(id int, m_name varchar(50), m_price int)";
		    
		    //String sql = "insert into movies values(101, 'King', 1230)";
		    
		    //String sql = "insert into movies values(102, 'Ki', 123)";
		    
		    String sql = "insert into movies values(100, 'ayan', 129)";
		    
		    //Student std = new Student(306, "ayan", "a@gmail.com");
		    
		    
		    
		    //4. execute query
		    stmt.execute(sql);
		    
		    
		    System.out.println("Done.");
		    
		  //5. close the connection object
		    con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
