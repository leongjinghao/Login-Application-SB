package com.example.demo.service;

import com.example.demo.controller.dto.UserRegistrationDto;
import com.example.demo.model.User;

public interface UserServiceInterface {
	User save(UserRegistrationDto registrationDto);
}
