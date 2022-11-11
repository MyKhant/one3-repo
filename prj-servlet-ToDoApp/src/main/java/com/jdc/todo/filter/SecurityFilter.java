package com.jdc.todo.filter;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@WebFilter("/auth/*")
public class SecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		var session = req.getSession(true);
		
		var user = session.getAttribute("user");
		
		if(null == user) {
			req.setAttribute("message", "Please login again!");
			req.getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
		
	}

}



