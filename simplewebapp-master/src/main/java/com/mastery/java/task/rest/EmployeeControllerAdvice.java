package com.mastery.java.task.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mastery.java.task.service.exceptions.EmptyResultDataAccessException;
import com.mastery.java.task.service.exceptions.ExistsEmployeeException;
import com.mastery.java.task.service.exceptions.InvalidFormatException;

@ControllerAdvice(basePackageClasses = EmployeeController.class)
public class EmployeeControllerAdvice extends ResponseEntityExceptionHandler{
		
		@ExceptionHandler(ExistsEmployeeException.class)
		@ResponseBody
	    public ResponseEntity<?> handleExistsEmployeeException(HttpServletRequest request, ExistsEmployeeException ex) {
	        return new ResponseEntity<>(new MyErrorBody(404 ,ex.getMessage()), HttpStatus.BAD_REQUEST);
	    }
	
		@ExceptionHandler(EmptyResultDataAccessException.class)
		@ResponseBody
	    public ResponseEntity<?> handleEmptyResultDataAccessException(HttpServletRequest request, EmptyResultDataAccessException ex) {
	        return new ResponseEntity<>(new MyErrorBody(404 ,ex.getMessage()), HttpStatus.BAD_REQUEST);
	    }
		
		@ExceptionHandler(InvalidFormatException.class)
		@ResponseBody
	    public ResponseEntity<?> handleInvalidFormatException(HttpServletRequest request, InvalidFormatException ex) {
	        return new ResponseEntity<>(new MyErrorBody(404 ,ex.getMessage()), HttpStatus.BAD_REQUEST);
	    }
}
