package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.controller.dto.UserRegistrationDto;
import com.example.demo.model.User;

public interface UserServiceInterface extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
