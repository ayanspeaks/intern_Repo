package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Exp1 {
	
	public static void main(String a[]) {
		
		String driverClass = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/students";
		String username = "root";
		String password = "root@39";
		try {
		Class.forName(driverClass);
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		Statement stmt = con.createStatement();
		
		String sql1 = "insert into student values(10, 'Ayann', 45, 67, 'Kolkata')";
		String sql2 = "insert into student values(78, 'Ayannl', 78, 34, 'assam')";
		String sql3 = "insert into student values(25, 'Ayannw',31, 90, 'bihar')";
		
		stmt.addBatch(sql1);
		stmt.addBatch(sql2);
		stmt.addBatch(sql3);
		
		stmt.executeBatch();
		
		String sql11 = "insert into student values(?, ?, ?)";
		
		PreparedStatement pst = con.prepareStatement(sql11);
		
		pst.setInt(1, 90);
		pst.setString(2, "axar");
		pst.setInt(3, 56);
		pst.setInt(4,67);
		pst.setString(5, "okay");
		
		pst.addBatch();
		
		pst.executeBatch();
		
		String sql211 = "insert into student values(?, ?, ?)";
		
		PreparedStatement pst2 = con.prepareStatement(sql211);
		
		pst2.setInt(1, 91);
		pst2.setString(2, "jaddu");
		pst2.setInt(3, 59);
		pst2.setInt(4,62);
		pst2.setString(5, "who");
		
        pst2.addBatch();
		
		pst2.executeBatch();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
