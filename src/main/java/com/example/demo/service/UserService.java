package com.example.demo.service;

import java.util.Arrays;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.controller.dto.UserRegistrationDto;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepositoryInterface;

@Service
public class UserService implements UserServiceInterface{

	private UserRepositoryInterface userRepository;
	
	public UserService(UserRepositoryInterface userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(),
				registrationDto.getLastName(),
				registrationDto.getEmail(),
				registrationDto.getPassword(),
				Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
