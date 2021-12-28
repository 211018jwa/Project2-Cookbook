package com.revature.model.modules;

import org.openqa.selenium.WebDriver;

import com.revature.model.components.CookbookDetailedComponent;
import com.revature.model.components.NavbarComponent;
import com.revature.model.components.RecipeSummaryComponent;

public class CookbookPage {

	public NavbarComponent navbar; 
	public CookbookDetailedComponent cookbook;
	public RecipeSummaryComponent recipe;	//Actually could potentially have many recipe components, but for testing we really only need to represent one, if any
	
	public CookbookPage(WebDriver driver) {
	
		this.navbar = new NavbarComponent(driver);
		this.cookbook = new CookbookDetailedComponent(driver);
		this.recipe = new RecipeSummaryComponent(driver);
		
	}
	
}
