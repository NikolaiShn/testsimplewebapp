package com.mastery.java.task.service.exceptions;

public class ExistsEmployeeException extends RuntimeException {
	
	public ExistsEmployeeException() {
		super("Employee exists");
	}
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1923083757352046446L;
}
