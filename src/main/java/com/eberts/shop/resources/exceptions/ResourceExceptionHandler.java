package com.eberts.shop.resources.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import com.eberts.shop.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	ResponseEntity<StandardError> badRequestError(ObjectNotFoundException e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(InvalidJwtAuthenticationException.class)
	ResponseEntity<StandardError> HandleInvalidJwtAuthenticationException(InvalidJwtAuthenticationException e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}

	@ExceptionHandler(InvalidJwtAuthenticationException.class)
	public final ResponseEntity<StandardError> handleInvalidJwtAuthenticationExceptions(
			Exception ex, WebRequest request) {
	//Integer status, String msg, long timeStamp
		StandardError exceptionResponse = new StandardError(HttpStatus.FORBIDDEN.value(), ex.getMessage(), System.currentTimeMillis());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<StandardError> Validation(MethodArgumentNotValidException e, HttpServletRequest request){
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Validation Error", System.currentTimeMillis());
		
		for(FieldError error : e.getBindingResult().getFieldErrors()){
			err.addError(error.getField(), error.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}


/*
InvalidJwtAuthenticationException
	
	@ExceptionHandler(DataIntegrityException.class)
	ResponseEntity<StandardError> objectNotFound(DataIntegrityException e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	

	*/
}