package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.controller.dto.UserDetailsDto;
import com.example.demo.controller.dto.UserRegistrationDto;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepositoryInterface;

@Service
public class UserService implements UserServiceInterface {

	private UserRepositoryInterface userRepository;
    private PasswordEncoder passwordEncoder;

	public UserService(UserRepositoryInterface userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User saveUser(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

		return userRepository.save(user);
	}
	
	@Override
	public List<UserDetailsDto> findAllUsers() {
		List<User> users = userRepository.findAll();
        return users.stream()
        		.map(user -> mapToUserDetailsDto(user))
        		.collect(Collectors.toList());
	}
	
	private UserDetailsDto mapToUserDetailsDto(User user){
        UserDetailsDto userDetailsDto = new UserDetailsDto();
        userDetailsDto.setFirstName(user.getFirstName());
        userDetailsDto.setLastName(user.getLastName());
        userDetailsDto.setEmail(user.getEmail());
        
        List<String> rolesInList = new ArrayList<String>();
        for (Role role : user.getRoles()) {
        	rolesInList.add(role.getName());
        }
        userDetailsDto.setRoles(String.join(", ", rolesInList));
        return userDetailsDto;
    }
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);

		if (user != null) {
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
					mapRolesToAuthorities(user.getRoles()));
		} else {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
	}
	
	public Boolean checkEmailRegistered(String email) {
		User user = userRepository.findByEmail(email);
		
		return user != null;
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
