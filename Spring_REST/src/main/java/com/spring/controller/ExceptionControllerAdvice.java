/**
 * 
 */
package com.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.exception.ErrorResponse;
import com.spring.exception.Errorargumenttype;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		System.out.println(this.getClass() + " Default exceptionHandler...");
		ErrorResponse error = new ErrorResponse();
		error.setErrorcode("NOT_HANDLED");
		Errorargumenttype type = new Errorargumenttype();
		type.setName(ex.getMessage());
		type.setValue(ex.getLocalizedMessage());
		error.getArguments().add(type);
		return new ResponseEntity<ErrorResponse>(error,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
