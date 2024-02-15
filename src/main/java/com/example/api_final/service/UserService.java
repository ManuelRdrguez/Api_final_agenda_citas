package com.example.api_final.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.api_final.response.user.UserResponse;


public interface UserService {
    UserDetailsService userDetailsService();
    List<UserResponse> getAllUsers();
}
