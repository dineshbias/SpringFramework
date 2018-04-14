package com.spring.exception;

public class SchoolException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public SchoolException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public SchoolException() {
		super();
	}
}