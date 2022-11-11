package com.jdc.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/img-upload")
@MultipartConfig
public class ImageUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var part = req.getPart("imgUpload");
		
		if(part != null) {
			String fileName = part.getSubmittedFileName();
			String realPath = getServletContext().getRealPath(fileName);
					
			Files.copy(part.getInputStream(), Paths.get(realPath), StandardCopyOption.REPLACE_EXISTING);
			
			String imageFile = getServletContext().getContextPath().concat("/" + fileName);
						
			System.out.println(imageFile);
			
			req.setAttribute("img", imageFile);

		}
				
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}

}









