package com.jdc.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.jdc.web.dao.Account;

@WebListener
public class AccountListener implements HttpSessionListener{
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		session.setAttribute("account", new Account("M Myo","myohant"));
	}
}
