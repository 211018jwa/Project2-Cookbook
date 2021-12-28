package com.revature.cookbook.controller;

import java.security.NoSuchAlgorithmException;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cookbook.dto.LoginDTO;
import com.revature.cookbook.model.User;
import com.revature.cookbook.service.UserService;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class AuthenticationController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest req;
	
	private static final String CURRENTUSER = "currentuser";

	

	
	@PostMapping(path = "/login")
	public ResponseEntity<Object> login(@RequestBody LoginDTO dto) throws NoSuchAlgorithmException {
		try {
			User user = this.userService.getUserByUsernameAndPassword(dto.getUsername(), dto.getPassword());
			
			HttpSession session = req.getSession();

			session.setAttribute(CURRENTUSER, user);
			
			return ResponseEntity.status(200).body(user);
		}catch (LoginException e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}	

	@GetMapping(path = "/currentuser")
	public ResponseEntity<Object> getCurrentlyLoggedInUser() {
		User user = (User) req.getSession().getAttribute(CURRENTUSER);

		
		if (user != null) {
			return ResponseEntity.status(200).body(user);
		}
		
		
		return ResponseEntity.status(401).body("Not logged in");
	}
	
	@GetMapping(path = "/loginstatus")
	public ResponseEntity<Object> loginStatus() {
		User currentlyLoggedInUser = (User) req.getSession().getAttribute(CURRENTUSER);
		
		if(currentlyLoggedInUser != null) {
			return ResponseEntity.status(200).body(currentlyLoggedInUser);
		}	
			/*******
			 * If null
			 */
			return ResponseEntity.status(401).body("Not logged in");		
	}
	
	@PostMapping(path = "/logout")
	public ResponseEntity<String> logout() {
		req.getSession().invalidate(); 
		
		return ResponseEntity.status(200).body("Successfully logged out");
	}
	
}

