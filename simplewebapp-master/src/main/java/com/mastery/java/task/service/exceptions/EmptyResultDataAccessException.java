package com.mastery.java.task.service.exceptions;

public class EmptyResultDataAccessException extends RuntimeException{

	public EmptyResultDataAccessException() {
		super("EmptyResult, employee not found");
	}

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 7702763466423592867L;

}