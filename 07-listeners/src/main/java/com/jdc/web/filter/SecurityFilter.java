package com.jdc.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jdc.web.dao.Account;

@WebFilter("/auth/*")
public class SecurityFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpSession session = req.getSession(true);
		
		Account acc=(Account)session.getAttribute("account");
		
		if(acc.getLoginId().equals("M Myo")&& acc.getPassword().equals("myokhant")) {
			chain.doFilter(request, response);
		}else {
			req.setAttribute("message", "Can't log in");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}
