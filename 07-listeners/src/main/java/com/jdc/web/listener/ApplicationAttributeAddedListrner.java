package com.jdc.web.listener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

import com.jdc.web.model.UserModel;

@WebListener
public class ApplicationAttributeAddedListrner implements ServletContextAttributeListener{
	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		String attriName=scae.getName();
		Object attriValue=scae.getValue();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd-hh:mm:ss");
		LocalDateTime dt=LocalDateTime.now();
		
		if(attriValue instanceof UserModel model) {
			scae.getServletContext().log("""
					%s is added on %s
					""".formatted(attriName,dtf.format(dt)) );
		}
	}
}
