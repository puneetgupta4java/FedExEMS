package com.example.demo.exception;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
public class UserException extends RuntimeException{

	String message;

	
	public UserException() {
	}
	
	public UserException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
}
