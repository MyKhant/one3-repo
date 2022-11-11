package com.jdc.todo.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home", "/auth/todo-form"})
public class TodoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getServletPath();
		String view = null;
		
		if(path.equals("/home")) {
			
			var session = req.getSession(true);
			
			var user = session.getAttribute("user");
			
			if(null != user) {
				// if user had in session scope, show to do list
				view = "/views/todo-list.jsp";
				
			} else {
				// else redirect to login page
				view = "/views/login.jsp";
			}
			
			
		} else {
			view = "/views/todo-form.jsp";
		}
		
		getServletContext().getRequestDispatcher(view).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		resp.sendRedirect(getServletContext().getContextPath().concat("/home"));
	}

}
