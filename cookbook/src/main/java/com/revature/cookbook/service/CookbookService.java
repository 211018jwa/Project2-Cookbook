package com.revature.cookbook.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cookbook.dao.CookbookDao;
import com.revature.cookbook.dao.UserDao;
import com.revature.cookbook.model.Cookbook;
import com.revature.cookbook.model.User;


@Service
public class CookbookService {
	
	@Autowired
	private CookbookDao cookbookDao;
	
	@Autowired
	private UserDao userDao; 
	
	
	private Logger logger = LoggerFactory.getLogger(CookbookService.class);
	
	public CookbookService() {
		
		
		
	}

	public Cookbook createNewCookbook(Cookbook newCookbook, int userId) throws IllegalArgumentException, Exception{
		
		//check to see user we are trying to create a cookbook for actually exists; 
		
		User user = userDao.getUserById(userId);
		
		if( user == null) {	//uh oh, user we are trying to create cookbook for doesnt exist!
			
			
			throw new IllegalArgumentException("Cannot create cookbook for user with id of " + userId + ". User does not exist");
			
		}
		
		Cookbook createdCookbook = new Cookbook();
		createdCookbook.setName(newCookbook.getName());
		createdCookbook.setUser(user);
		
		createdCookbook = cookbookDao.createNewCookbook(createdCookbook);
		
		if(createdCookbook.getUser().getId() != userId) {	//if for some reason the userId we want to associate with this cookbook isnt actually the userId associated 
			
			throw new Exception("COOKBOOK DAO: Shouldnt ever get here. For some reason userId passed in argument didnt set in created cookbook");
			
		}
		
		
		return createdCookbook;
	}

	
	@Transactional
	public Cookbook addRecipeToCookbook(int cookbookId, int recipeId) {
		
		Cookbook cookbook = cookbookDao.getCookbookById(cookbookId);
		
		if(cookbook == null) {
			
			throw new IllegalArgumentException("COOKBOOK SERVICE: Unable to update cookbook. Cookbook does not exist");
			
		}
		
		cookbookDao.addRecipeToCookbook(cookbook, recipeId);
		
		return cookbook; 
		
		
	}

	public Cookbook getCookbook(int cookbookId) {
		
		Cookbook cookbook = cookbookDao.getCookbookById(cookbookId);
		
		if(cookbook == null) {
			
			throw new IllegalArgumentException("COOKBOOK SERVICE: Unable to get cookbook. Cookbook with id " + cookbookId + " does not exist");
			
		}
		
		return cookbook; 
		
		
	}

}
