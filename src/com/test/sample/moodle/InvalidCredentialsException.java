package com.test.sample.moodle;

@SuppressWarnings("serial")
public class InvalidCredentialsException extends RuntimeException {
	
	public InvalidCredentialsException() {
		super("Credentials not found");
	}
	
	public InvalidCredentialsException(String message) {
		super(message);
	}
}
