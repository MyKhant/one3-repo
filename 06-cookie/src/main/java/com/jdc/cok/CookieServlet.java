package com.jdc.cok;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/cookies","/info"})
@SuppressWarnings("serial")
public class CookieServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies=req.getCookies();
		HttpSession session= req.getSession(true);
		for(Cookie ck:cookies) {
			session.setAttribute("name", ck.getName());
			session.setAttribute("value", ck.getValue());
			session.setAttribute("version", ck.getVersion());
		}
		getServletContext().getRequestDispatcher("/cook.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		Cookie ck=new Cookie("name", name);
		resp.addCookie(ck);
		resp.sendRedirect("/cook.jsp");
	}
}
