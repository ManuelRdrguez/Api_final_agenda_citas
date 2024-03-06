package com.example.api_final.error.exception;

public class CitaNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public CitaNotFoundException(String mensaje) { 
    	super(mensaje);
    }
}
