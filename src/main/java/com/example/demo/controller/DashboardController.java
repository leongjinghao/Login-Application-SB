package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.dto.UserDetailsDto;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	private UserService userService;
	
	public DashboardController(UserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute("users")
	public List<UserDetailsDto> userDetailsDto() {
		return new ArrayList<UserDetailsDto>();
	}
	
	@GetMapping
	public String showDashboardPage(@ModelAttribute("users") List<UserDetailsDto> usersDto) {
		usersDto.addAll(userService.findAllUsers());
		return "dashboard";
	}
}
