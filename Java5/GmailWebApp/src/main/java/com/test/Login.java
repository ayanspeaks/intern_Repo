package com.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("user");
		String pass = request.getParameter("pwd");
		
		String driver="com.mysql.jdbc.Driver";
		String urlMySql = "jdbc:mysql://localhost:3306/students";
		String username="root";
		String password = "root@39";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(urlMySql,username, password);
			
			String sql = "select mla_user, mla_pass from user_mla where mla_user = ? and mla_pass = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, name);
			pst.setString(2, pass);
			
			ResultSet rs = pst.executeQuery();
//			boolean b = pst.execute();
			while(rs.next()) {
				
			if(rs.getString(1).equals(name)) {
				RequestDispatcher rd = request.getRequestDispatcher("home.html");
				rd.forward(request, response);
			}
			break;
			}
			if(true) {
				out.println("<center> <h3><font color = 'red'>Login Failed</font></h3> </center>");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
