package com.jdc.redir;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/redirect-form")
public class RedirectFormServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		System.out.println("""
				Name: %s
				Phone: %s
				Email: %s
				Password: %s
				""".formatted(name,phone,email,password));
		resp.sendRedirect("info");
	}
}
