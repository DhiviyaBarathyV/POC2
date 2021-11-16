package com.elitehotel.advice;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice  
public class CustomEntityExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public final ResponseEntity<String> handleAllExceptions(EmptyResultDataAccessException ex, WebRequest request)
	{
		return new ResponseEntity<String>("Room number that you entered is already booked",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> ConstraintViolation(ConstraintViolationException ex, WebRequest request)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}


