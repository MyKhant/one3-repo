package com.jdc.direct;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/include")
public class IncludeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		pw.append("<h1>Include Servlet</h1>").flush();
		RequestDispatcher dis =req.getRequestDispatcher("/message");
		//dis=getServletContext().getRequestDispatcher("/message");
		dis=getServletContext().getNamedDispatcher("Message");
		dis.include(req, resp);
	}

}
