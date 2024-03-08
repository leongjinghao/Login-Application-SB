package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.dto.UserRegistrationDto;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute("userRegistration")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("userRegistration") UserRegistrationDto userRegistrationDto) {
		if (userService.checkEmailRegistered(userRegistrationDto.getEmail())) {
			return "redirect:/registration?error";
		}
		else {
			userService.saveUser(userRegistrationDto);
			return "redirect:/registration?success";
		}
	}
}
