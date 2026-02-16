package com.ibm.spring.springmvc.sarada;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet {

	
	ServletConfig config = null ;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("Servlet is inisatialized");
	}


	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		PrintWriter bhargav = res.getWriter();
		
		bhargav.println("<html><body>");
		bhargav.println("<B> HI this is Servlet service");
		bhargav.println("</body></html>");
		
		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "config";
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet is destroyed");
	}
	
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
}
