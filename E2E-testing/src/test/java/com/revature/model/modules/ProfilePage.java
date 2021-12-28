package com.revature.model.modules;

import org.openqa.selenium.WebDriver;

import com.revature.model.components.CookbookDetailedComponent;
import com.revature.model.components.NavbarComponent;

public class ProfilePage {

	public NavbarComponent navbar;
	private CookbookDetailedComponent cookbookDetailed; 
	
	
	public ProfilePage(WebDriver driver) {
		
		this.navbar = new NavbarComponent(driver);
		this.cookbookDetailed = new CookbookDetailedComponent(driver);
		
	}
	
}
