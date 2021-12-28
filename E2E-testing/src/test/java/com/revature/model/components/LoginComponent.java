package com.revature.model.components;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginComponent {

	
	private WebDriver driver; 
	private WebDriverWait wdw; 
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameField;
	
	@FindBy(xpath = "//input[@id='pwd']")
	private WebElement passwordField; 
	
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	private WebElement submitButton;
	
	@FindBy(xpath = "//div[@id='error-message']")
	private WebElement submitHelper; 
	
	public LoginComponent(WebDriver driver) {
		
		this.driver = driver; 
		wdw = new WebDriverWait(this.driver, Duration.ofSeconds(2));
		
		PageFactory.initElements(this.driver, this);
		
	}
	
	public String getUsernameText() {
		
		return wdw.until(ExpectedConditions.visibilityOf(usernameField)).getText();
		
	}
	
	public String getPasswordText() {
		
		return wdw.until(ExpectedConditions.visibilityOf(passwordField)).getText();
		
	}
	
	public String getSubmitHelperText() {
		
		return wdw.until(ExpectedConditions.visibilityOf(submitHelper)).getText();
		
	}
	
	public void clickSubmit() {
		
		wdw.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
		
	}
	
	public void setUsernameField(String username) {
		
		this.wdw.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
		
	}
	
	public void setPasswordField(String password) {
		
		this.wdw.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
		
	}
	
	
}
