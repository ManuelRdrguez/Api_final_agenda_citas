package com.example.api_final.error.exception;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException(String mensaje) {
		super(mensaje);
	}
}
