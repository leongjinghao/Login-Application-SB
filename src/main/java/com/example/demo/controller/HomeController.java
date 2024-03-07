package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.controller.dto.UserRegistrationDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class HomeController {
	
	private UserService userService;
	
	public HomeController(UserService userService) {
		this.userService = userService;
	}

	// handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }
}
