package com.test;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;


@WebFilter("/Admin")
public class MyFilter extends HttpFilter implements Filter {
       

    public MyFilter() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void destry() {
    	System.out.println("destroy()");
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("before servlet execution");

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		System.out.println("after servlet execution");
	}


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init()");
	}

}
