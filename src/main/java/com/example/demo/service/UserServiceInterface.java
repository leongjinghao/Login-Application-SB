package com.example.demo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.controller.dto.UserDetailsDto;
import com.example.demo.controller.dto.UserRegistrationDto;
import com.example.demo.model.User;

public interface UserServiceInterface extends UserDetailsService {
	User saveUser(UserRegistrationDto registrationDto);
	
	User findUserByEmail(String email);

	List<UserDetailsDto> findAllUsers();
}
