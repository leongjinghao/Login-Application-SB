package com.example.demo.controller.dto;

import java.util.Collection;

import com.example.demo.model.Role;

public class UserDetailsDto {
	private String firstName;
	private String lastName;
	private String email;
	private String roles;

	public UserDetailsDto() { }
	
	public UserDetailsDto(String firstName, String lastName, String email, String roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roles = roles;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRoles() {
		return roles;
	}
	
	public void setRoles(String roles) {
		this.roles = roles;
	}
}
