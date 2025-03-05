package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Student {
	
	public static void main(String a[]) {
		
		try
		{
			//1. load the driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. create connection object
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root@39");
			
			//3. create statement object
		    Statement stmt = con.createStatement();
		    
		    
		    
		    //String sql = "create table student(id int, name varchar(50), age int, marks int, city varchar(50))";
		    
		    //String sql = "insert into student values(1, 'ayan', 76, 100, 'kolkata')";
		    
		    
		    //String sql1 = "insert into student values(2, 'aya', 77, 29, 'pune')";
		    //String sql2 = "insert into student values(5, 'ay', 23, 10, 'hyderabad')";
		    //String sql3 = "insert into student values(6, 'Anil', 26, 99, 'dhaka')";
		    //String sql4 = "insert into student values(7, 'Anik', 32, 81, 'jalandhar')";
		    //String sql5 = "insert into student values(8, 'Barun', 67, 88, 'gurgaon')";
		    //String sql6 = "insert into student values(5, 'Vivek', 34, 15, 'delhi')";
		    //String sql7 = "insert into student values(90, 'Sahely', 12, 92, 'mumbai')";
		    //String sql8 = "insert into student values(9, 'Anwesha', 46, 10, 'chennai')";
		    //String sql9 = "insert into student values(12, 'Soumili', 45, 11, 'goa')";
		    
		    
		    
		    
		    
		    
		    //4. execute query
		    //stmt.execute(sql1);
		    //stmt.execute(sql2);
		    //stmt.execute(sql3);
		    //stmt.execute(sql4);
		    //stmt.execute(sql5);
		    //stmt.execute(sql6);
		    //stmt.execute(sql7);
		    //stmt.execute(sql8);
		    //stmt.execute(sql9);
		    
		    //String update = "update student set age = 30 where name = 'aya'";
		    
		    //stmt.execute(update);
		    
		    String sql = "select * from student";
		    
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    while(rs.next()) {
		    	System.out.println("ID :"+ rs.getInt(1)+"Name : "+rs.getString(2)+"Age : "+rs.getInt(3)+"Marks : "+rs.getInt(4)+ "City : "+rs.getString(5));
		    	
		    }
		    
		    ResultSetMetaData rsd = (ResultSetMetaData) rs.getMetaData();
	    	
	    	System.out.println(rsd.getColumnCount());
	    	
	    	System.out.println(rsd.getColumnType(1));
	    	System.out.println(rsd.getColumnClassName(1));
		    
		    
		    
		    
		    
		    System.out.println("Done.");
		    
		  //5. close the connection object
		    con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
