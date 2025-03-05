package com.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Exp3 {
	
	public static void main(String a[]) throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root@39");
		
		CallableStatement cst = con.prepareCall("{call readData}");
		
		ResultSet rs = cst.executeQuery();
		
		while(rs.next()) {
	    	System.out.println("ID :"+ rs.getInt(1)+"Name : "+rs.getString(2)+"Age : "+rs.getInt(3)+"Marks : "+rs.getInt(4)+ "City : "+rs.getString(5));
	    	
	    }
	}

}
