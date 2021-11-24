package com.springboot.vote.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.vote.dto.UserDto;
import com.springboot.vote.model.User;
import com.springboot.vote.service.CustomUserDetailsService;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	// Api for login
	// take user object as parameter and check it from the database
	// if user name and password are correct, respond with error code 0
	// otherwise, respond with error code 1 and Invalid message
	@PostMapping("/api/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody UserDto request) throws Exception {
		Map<String, Object> response= new LinkedHashMap<String, Object>();
		try {
		authenticationManager.authenticate(new 
					UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		}
		catch(Exception e) {
			response.put("errorCode", 1);
			response.put("message", "Invalid username or password");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		response.put("errorCode", 0);
		response.put("user", request.getEmail());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	// Api for register
	// take user object as parameter and save it to the database
	// if register is successful, respond with error 0 and user's data
	// if email already exist, it will respond error 1 and Invalid message
	@PostMapping("/api/register")
	public ResponseEntity<Map<String, Object>> saveUser(@RequestBody UserDto request) {
		Map<String, Object> response= new LinkedHashMap<String, Object>();
		
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		
		try {
			customUserDetailsService.saveUser(user);
		}
		catch(Exception e) {
			response.put("errorCode", 1);
			response.put("message", "Invalid username");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		response.put("errorCode", 0);
		response.put("data", user);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
