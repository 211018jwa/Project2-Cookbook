package com.revature.model.modules;

import org.openqa.selenium.WebDriver;

import com.revature.model.components.NavbarComponent;
import com.revature.model.components.RecipeDetailedComponent;

public class RecipeDetailedPage {

	public NavbarComponent navbar;
	public RecipeDetailedComponent recipeDetailed; 
	
	
	public RecipeDetailedPage(WebDriver driver) {
		
		this.navbar = new NavbarComponent(driver);
		this.recipeDetailed = new RecipeDetailedComponent(driver);
		
	}
	
}
