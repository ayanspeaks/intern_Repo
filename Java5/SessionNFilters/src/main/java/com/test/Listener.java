package com.test;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;


@WebListener
public class Listener implements HttpSessionListener {


	public static int tusers, cusers = 0;
	
	public static ServletContext ctx;


    public void sessionCreated(HttpSessionEvent se)  { 
         
    	tusers++;
    	cusers++;
    	
    	ctx = se.getSession().getServletContext();
    	
    	ctx.setAttribute("total", tusers);
    	ctx.setAttribute("curent", cusers);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
         
    	cusers--;
    	
    	ctx.setAttribute("current", cusers);
    }
	
}
