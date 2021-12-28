package com.revature.model.modules;

import org.openqa.selenium.WebDriver;

import com.revature.model.components.CreateUserComponent;


public class RegisterPage {
	
	public CreateUserComponent createUser;
	
	public RegisterPage(WebDriver driver) {
		
		this.createUser = new CreateUserComponent(driver);
		
	}

}
