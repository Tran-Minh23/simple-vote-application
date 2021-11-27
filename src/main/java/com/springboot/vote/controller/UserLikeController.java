package com.springboot.vote.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.vote.dto.UserLikeDto;
import com.springboot.vote.service.UserLikeService;

@CrossOrigin
@RestController
public class UserLikeController {
	
	@Autowired
	UserLikeService userLikeService;
	
	// post mapping for adding user and item and count
	// post mapping is called when an user has not voted on the specific item yet
	@PostMapping("/api/userlike")
	public ResponseEntity<Map<String, Object>> createUserLike(@RequestBody UserLikeDto request) {
		LinkedHashMap<String, Object> response= new LinkedHashMap<String, Object>();
		userLikeService.insertToUserLike(request.getItemId(), request.getUserId(), request.getCount());
		
		response.put("errorCode", 0);
		response.put("data", request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	// put mapping for update user count on an item
	// put mapping is called when user has voted at least one 
	@PutMapping("/api/userlike")
	public ResponseEntity<Map<String, Object>> updateUserLike(@RequestBody UserLikeDto request) {
		LinkedHashMap<String, Object> response= new LinkedHashMap<String, Object>();
		
		userLikeService.updateToUserLike(request.getItemId(), request.getUserId(), request.getCount());
		
		response.put("errorCode", 0);
		response.put("data", request);
		return new ResponseEntity<>(response, HttpStatus.OK);	
	}
	
}
