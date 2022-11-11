package com.jdc.life;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletLifeCycle implements Servlet{

	@Override
	public void destroy() {
		System.out.println("Destroy()");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("GetServletConfig()");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("GetServletInfo()");
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service()");
	}

}
