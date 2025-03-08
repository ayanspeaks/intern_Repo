package com.test;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("user");
		
		//Cookie ck = new Cookie("info", name);
		
		//response.addCookie(ck);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("info", name);
		
		ServletContext ctx = getServletContext();
		
		int t = (int)ctx.getAttribute("total");
		int c = (int)ctx.getAttribute("current");
		
		out.println("from login page : "+name);
		
		out.println("Total users : "+t);
		out.println("Current users : "+c);
		
		out.println("<br><a href = 'Logout'> logout here </a>");
	}

}
