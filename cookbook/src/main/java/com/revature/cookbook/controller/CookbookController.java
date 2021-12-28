package com.revature.cookbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cookbook.model.Cookbook;
import com.revature.cookbook.service.CookbookService;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class CookbookController {

	@Autowired
	private CookbookService cookbookService; 
	
	private Logger logger = LoggerFactory.getLogger(CookbookController.class);
	
	
	@PostMapping(path = "/cookbooks/{userId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createNewCookbook(@RequestBody Cookbook newCookbook, @PathVariable("userId") int userId) {
		
		try {
			
			Cookbook createdCookbook = cookbookService.createNewCookbook(newCookbook, userId);
			logger.info("COOKBOOK CONTROLLER: Create cookbook successful: " + createdCookbook);
			return ResponseEntity.status(200).body(createdCookbook);
			
			
		}
		catch(Exception e) {
			
			logger.info(e.getMessage());
			return ResponseEntity.status(400).body(e.getMessage());
			
		}
		
		
	}
	
	@PostMapping(path = "/cookbooks/{cookbookId}/{recipeId}")
	public ResponseEntity<Object> addRecipeToCookbook(@PathVariable("cookbookId") int cookbookId, @PathVariable("recipeId") int recipeId) {
		
		try {
			
			Cookbook updatedCookbook = cookbookService.addRecipeToCookbook(cookbookId, recipeId);
			logger.info("COOKBOOK CONTROLLER: Recipe added to cookbook successfully " + updatedCookbook);
			return ResponseEntity.status(200).body(updatedCookbook);
			
			
		}
		catch(Exception e) {
			
			logger.info(e.getMessage());
			return ResponseEntity.status(400).body(e.getMessage());
			
		}
		
	}
	
	@GetMapping(path = "/cookbooks/{cookbookId}")
	public ResponseEntity<Object> getCookbook(@PathVariable("cookbookId") int cookbookId){
		
		try {
		
			Cookbook cookbook = cookbookService.getCookbook(cookbookId);
			logger.info("COOKBOOK CONTROLLER: Got cookbook: " + cookbook);
			return ResponseEntity.status(200).body(cookbook);
			
		}
		
		catch(Exception e) {
			
			logger.info(e.getMessage());
			return ResponseEntity.status(400).body(e.getMessage());
			
		}
		
	}
	
}
