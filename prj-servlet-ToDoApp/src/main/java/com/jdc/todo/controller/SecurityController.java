package com.jdc.todo.controller;

import java.io.IOException;

import com.jdc.todo.model.repository.TodoException;
import com.jdc.todo.model.repository.UserRepo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login", "/logout"})
public class SecurityController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserRepo userRepo;
	
	@Override
	public void init() throws ServletException {
		userRepo = UserRepo.getInstance();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getServletPath();
		HttpSession session = req.getSession(true);
		
		switch(path) {
			case "/login" -> {
				
				try {
					// get login id from form
					String loginId = req.getParameter("loginId");
					
					// get password from form
					String password = req.getParameter("password");
					
					var user = userRepo.findUser(loginId, password);
					
					if(null == user ||
							!user.getLoginId().equals(loginId) ||
							!user.getPassword().equals(password)
							)
						throw new TodoException("User not found!");
					
					session.setAttribute("user", user);
										
				} catch (Exception e) {
					req.setAttribute("info", e.getMessage());
					getServletContext().getRequestDispatcher("/views/login.jsp").forward(req, resp);
					return;
				}
				
				
			}
			case "/logout" -> {
				session.invalidate();
			}
		}
		
		resp.sendRedirect(getServletContext().getContextPath().concat("/home"));
		
	}

}
