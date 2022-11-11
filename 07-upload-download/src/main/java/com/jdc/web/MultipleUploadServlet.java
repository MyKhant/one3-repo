package com.jdc.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/multiple-upload")
@MultipartConfig
public class MultipleUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var parts = req.getParts();
		
		List<String> imgs = new ArrayList<>();
		
		if(!parts.isEmpty()) {
			
			for(var part : parts) {
				
				String fileName = part.getSubmittedFileName();
				String realPath = getServletContext().getRealPath(fileName);
				
				Files.copy(part.getInputStream(), Paths.get(realPath), StandardCopyOption.REPLACE_EXISTING);
				
				imgs.add(getServletContext().getContextPath().concat("/" + fileName));
				
			}
			
		}
		
		req.setAttribute("imgs", imgs);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}

}






