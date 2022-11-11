package com.jdc.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/file-download")
public class FileDownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var items = """
				[{
					"name": "Jack Daniel",
					"price": 20000,
					"quantity": 2
				},
				{
					"name": "100 Pipers",
					"price": 30000,
					"quantity": 3
				},
				{
					"name": "Martini",
					"price": 36000,
					"quantity": 2
				}]
				""";
		
		resp.setHeader("Content-Type", "application/json");
		resp.setHeader("Content-Disposition", "attachment; filename=\"items.json\"");
		resp.getWriter().append(items);
	}

}






