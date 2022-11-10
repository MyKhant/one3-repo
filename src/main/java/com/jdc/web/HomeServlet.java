package com.jdc.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/file-upload")
@MultipartConfig
public class HomeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		try {
//			var part=req.getPart("upload");
//			Path path=Paths.get(part.getInputStream().toString(),part.getSubmittedFileName());
//			List<Item> list=Files.lines(path).skip(1).map(Item::new).toList();
//			req.setAttribute("items", list);
//			resp.sendRedirect(getServletContext().getRequestDispatcher("/index.jsp").toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		var part = req.getPart("upload");
		List<Item> result=new ArrayList<>();
		try (BufferedReader br=new BufferedReader(new InputStreamReader(part.getInputStream()))){
			String line=null;
			while(null!=(line=br.readLine())) 
				result.add(new Item(line));
				
			req.setAttribute("items", result);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
