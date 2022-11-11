package com.jdc.web.listener;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.jdc.web.dao.Account;
import com.jdc.web.dao.User;
import com.jdc.web.model.UserModel;

@WebListener
public class ApplicationLifeCycleListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String path=sce.getServletContext().getRealPath("/WEB-INF/user.txt");
		UserModel model=UserModel.getInstance();
		sce.getServletContext().setAttribute("model", model);
		try (BufferedReader br=new BufferedReader(new FileReader(path))){
			String line=null;
			while(null!=(line=br.readLine())) {
				model.add(new User(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
