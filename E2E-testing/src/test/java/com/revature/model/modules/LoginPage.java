package com.revature.model.modules;

import org.openqa.selenium.WebDriver;

import com.revature.model.components.CreateUserComponent;
import com.revature.model.components.LoginComponent;

public class LoginPage {

	public LoginComponent login;
	
	
	public LoginPage(WebDriver driver) {
		
		this.login = new LoginComponent(driver);
		
	}
	
}
