package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.dto.UserDetailsDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	private UserService userService;
	
	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute("userDetails")
	public UserDetailsDto userDetailsDto() {
		return new UserDetailsDto();
	}

    @GetMapping
    public String home(@ModelAttribute("userDetails") UserDetailsDto userDetailsDto){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User user = userService.findUserByEmail(auth.getName());
    	
    	userDetailsDto.setFirstName(user.getFirstName());
    	userDetailsDto.setLastName(user.getLastName());
    	userDetailsDto.setEmail(user.getEmail());
        return "home";
    }
}
