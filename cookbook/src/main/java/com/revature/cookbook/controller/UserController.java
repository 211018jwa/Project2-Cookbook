package com.revature.cookbook.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cookbook.model.User;
import com.revature.cookbook.service.UserService;

import com.revature.cookbook.exception.UserNotFoundException;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class UserController {

	@Autowired
	private UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class); 
	
	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@DeleteMapping(path = "/users/{id}")
	public Object deleteUserById(@PathVariable("id") int id) {
		try {
			userService.deleteUserById(id);
			
			return "Successfully deleted User with id " + id;
		}catch(UserNotFoundException e) {
			return e.getMessage();
		}
	}
	
	@PostMapping(path = "/users", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addNewUser(@RequestBody User newUser) throws NoSuchAlgorithmException {
		
		try {
			
			User user = userService.addNewUser(newUser);
			
			return ResponseEntity.status(201).body(user);
			
		} catch(IllegalArgumentException e) {
			
			return ResponseEntity.status(400).body(e.getMessage());
			
		}

		
	}
	
}
