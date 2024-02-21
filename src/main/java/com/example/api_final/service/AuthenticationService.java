package com.example.api_final.service;

import com.example.api_final.dto.request.SignUpRequest;
import com.example.api_final.dto.request.SigninRequest;
import com.example.api_final.dto.response.user.JwtAuthenticationResponse;

public interface AuthenticationService {
	
	/** REGISTRO */
    JwtAuthenticationResponse signup(SignUpRequest request);
    /** ACCESO a Token JWT */
    JwtAuthenticationResponse signin(SigninRequest request);
}
