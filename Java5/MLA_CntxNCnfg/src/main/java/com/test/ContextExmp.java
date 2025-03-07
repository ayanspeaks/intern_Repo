package com.test;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//@WebServlet("/ContextExample")
public class ContextExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletContext ctx = getServletContext();
		
		String ct = ctx.getInitParameter("city");
		String st = ctx.getInitParameter("state");
		
		String details = ct +" "+st;
		ctx.setAttribute("info", details);
		
		out.println("City: "+ct+"  State: "+st);
		
		
		ServletConfig cfg = getServletConfig();
		String name = cfg.getInitParameter("user");
		String pass = cfg.getInitParameter("pwd");
		
		out.println("<br> Name: "+name+" Password: "+pass);
		out.println("<br><br><a href = 'Servlet2'> go to next page</a> ");
	}

}
