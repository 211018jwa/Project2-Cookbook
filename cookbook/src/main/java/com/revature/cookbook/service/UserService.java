package com.revature.cookbook.service;

import org.springframework.stereotype.Service;

import com.revature.cookbook.dao.UserDao;
import com.revature.cookbook.model.User;

import javax.security.auth.login.LoginException;


import com.revature.cookbook.exception.*;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	

	public List<User> getAllUsers() {
		List<User> users = userDao.getAllUsers();

		return users;
	}

	public void deleteUserById(int id) throws UserNotFoundException {
		User user = userDao.getUserById(id);
		
		if(user == null) {
			logger.info("USER SERVICE: Cannot delete user. User with Id of " + id + " does not exist");
			throw new UserNotFoundException("User with id " + id + "does not exist");
		}
		userDao.deleteUserById(id);
		logger.info("USER SERVICE: User with id of "  + id + " successfully deleted");
	}
	
	
	
	
	public User addNewUser(User user) throws IllegalArgumentException, NoSuchAlgorithmException {
		
		//first check if anything is empty and/or null
		
		if(user.getUsername() == null || user.getUsername().length() == 0) {
			
			logger.info("USER SERVICE: Cannot create user. Username is empty");
			throw new IllegalArgumentException("Unable to create user. Username is empty");	
			
		}
		
		if(user.getPassword() == null || user.getPassword().length() == 0 ) {
			
			logger.info("USER SERVICE: Cannot create user. Password is empty");
			throw new IllegalArgumentException("Unable to create user. Password is empty");
			
		}
		
		if(user.getEmail() == null || user.getEmail().length() == 0 ) {
			
			logger.info("USER SERVICE: cannot create user. Email is empty");
			throw new IllegalArgumentException("Unable to create user. Email is empty");
			
		}
		
		if(!(user.getFirstName() == null) && user.getFirstName().length() > 0 ) {	//first name isn't null, so we can trim 
			
			user.setFirstName(user.getFirstName().trim());
			
			if(user.getFirstName().length() > 255) {
				
				logger.info("USER SERVICE: Cannot create new user. First name is too long (greater than 255 characters)" );
				throw new IllegalArgumentException("Cannot create new user. First name is too long (greater than 255 characters)");
				
			}
			
		}
		
		if(!(user.getLastName() == null) && user.getLastName().length() > 0 )  {
			
			user.setLastName(user.getLastName().trim());
			if(user.getLastName().length() > 255) {
				
				logger.info("USER SERVICE: Cannot create new user. Last name is too long (greater than 255 characters)" );
				throw new IllegalArgumentException("Cannot create new user. Last name is too long (greater than 255 characters)");
				
			}
			
		}
		
		if(!(user.getPhoneNumber() == null) && user.getPhoneNumber().length() > 0 ) {
			
			user.setPhoneNumber(user.getPhoneNumber().trim());
			
			if(user.getPhoneNumber().length() > 255) {
				
				logger.info("USER SERVICE: Cannot create new user. Phone number is too long (greater than 255 characters)" );
				throw new IllegalArgumentException("Cannot create new user. Phone number is too long (greater than 255 characters)");
				
			}
			
		}
		
		//next check if anything is too long (greater than 255 characters). Dont need to check username and password. Since theyre hashed with sha256, they will always fit
		

		
		
		if(user.getEmail().length() > 255) {
			
			logger.info("USER SERVICE: Cannot create new user. Email is too long (greater than 255 characters)" );
			throw new IllegalArgumentException("Cannot create new user. Email is too long (greater than 255 characters)");
			
		}
		
		
		
		user.setUsername(user.getUsername().trim());
		user.setEmail(user.getEmail().trim());
		
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(user.getUsername().getBytes(StandardCharsets.UTF_8));
		byte[] digest = md.digest();
		
		user.setUsername(String.format("%064x", new BigInteger(1, digest))); //Ok we just set the username to its hash
		
		//gotta hash before we check if username or email exists. Since we only store hashed username. Actually email is fine plaintext
		
		if(!(userDao.getUserByUsername(user.getUsername()) == null)) {	//If we find a user in our database with same username, throw exception. Shouldn't have users with same username
			
			logger.info("USER SERVICE: Cannot create user. User with username already exists");
			throw new IllegalArgumentException("Cannot create new user. User with username already exists");
			
		}
		
		if(!(userDao.getUserByEmail(user.getEmail()) == null)) {	//same thing for email
			
			logger.info("USER SERVICE: Cannot create user. User with email already exists");
			throw new IllegalArgumentException("Cannot create new user. User with email already exists");
			
		}
		
		
		
		//Ok we've already hashed the username. Now lets salted and hash the password using email as salt
		
		String passwordWithSalt = user.getPassword() + user.getEmail(); 
		
		md.update(passwordWithSalt.getBytes(StandardCharsets.UTF_8));
		byte[] digest2 = md.digest();
		
		user.setPassword(String.format("%064x", new BigInteger(1, digest2)));
		
		User newUser = userDao.addUser(user);
		
		logger.info("USER SERVICE: User successfully created");
		return newUser;
			
		}
	
	public User getUserByUsernameAndPassword(String username, String password) throws LoginException, NoSuchAlgorithmException {
		
		
		if(username == null || username.length() == 0) {
			
			logger.info("USER SERVICEL: Cannot get user by username and password. Username is empty or null");
			throw new IllegalArgumentException("Cannot get user by username and password. Username is empty or null");
			
			
		} else if(password == null || password.length() == 0) {
			
			logger.info("USER SERVICE: Cannot get user by username and password. Password is empty or null");
			throw new IllegalArgumentException("Cannot get user by username and password. Password is empty or null");
			
		}
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(username.getBytes(StandardCharsets.UTF_8));
		byte[] digest = md.digest();
		
		String hashedUsername = String.format("%064x", new BigInteger(1, digest));
		
		User user = userDao.getUserByUsername(hashedUsername);
		
		if(user == null) {
			
			logger.info("USER SERVICE: No user with that username");
			throw new LoginException("Failed to login, please check username and/or password");
			
		}
		
		//ok gotta salt and hash the password now
		
		String saltedPassword = password + user.getEmail();
		md.update(saltedPassword.getBytes(StandardCharsets.UTF_8));
		byte[] digest2 = md.digest();
		
		String hashedSaltedPassword = String.format("%064x", new BigInteger(1, digest2));
		
		user = userDao.getUserByUsernameAndPassword(hashedUsername, hashedSaltedPassword);
		
		if(user == null) {
			logger.info("USER SERVICE: No matching username password combination");
			throw new LoginException("Failed to login, please check username and/or password");
		}
		logger.info("USER SERVICE: Successfully retrieved user by username and password");
		return user;
	}
		
		
		
	}

