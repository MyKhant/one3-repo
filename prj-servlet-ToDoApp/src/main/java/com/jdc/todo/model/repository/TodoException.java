package com.jdc.todo.model.repository;

public class TodoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TodoException(String message) {
		super(message);
	}

}
