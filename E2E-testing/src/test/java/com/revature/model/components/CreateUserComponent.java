package com.revature.model.components;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUserComponent {

	
	private WebDriver driver; 
	private WebDriverWait wdw;
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameField;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordField;
	
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailField; 
	
	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstnameField;
	
	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastnameField;
	
	@FindBy(xpath = "//button[@id='submitBtn']")
	private WebElement submitButton; 
	
	@FindBy(xpath = "//input[@id='userAge']")
	private WebElement ageField;
	
	@FindBy(xpath = "//input[@id='phoneNumber']")
	private WebElement phoneNumberField;
	
	@FindBy(xpath = "//p[@id='submitHelper']")
	private WebElement submitHelper; 

	
	public CreateUserComponent(WebDriver driver) {
		
		this.driver = driver; 
		wdw = new WebDriverWait(this.driver, Duration.ofSeconds(2));
		
		PageFactory.initElements(this.driver, this);
		
	}
	
	public String getUsernameText() {
		
		return this.wdw.until(ExpectedConditions.visibilityOf(usernameField)).getText();
		
	}
	
	public String getPasswordText() {
		
		return this.wdw.until(ExpectedConditions.visibilityOf(passwordField)).getText();
		
	}
	
	public String getEmailText() {
		
		return this.wdw.until(ExpectedConditions.visibilityOf(emailField)).getText();
		
	}
	
	public String getFirstnameText() {
		
		return this.wdw.until(ExpectedConditions.visibilityOf(firstnameField)).getText();
		
	}
	
	public String getLastnameText() {
		
		return this.wdw.until(ExpectedConditions.visibilityOf(lastnameField)).getText();
		
	}
	
	public String getPhoneNumberText() {
		
		return this.wdw.until(ExpectedConditions.visibilityOf(phoneNumberField)).getText();
		
	}
	
	public String getAgeText() {
		
		return this.wdw.until(ExpectedConditions.visibilityOf(ageField)).getText();
		
	}
	
	public String getSubmitHelperText() {
		
		return this.wdw.until(ExpectedConditions.visibilityOf(submitHelper)).getText();
		
	}
	
	public void clickSubmit() {
		
		this.wdw.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
		
	}
	
	public void setUsernameField(String username) {
		
		this.wdw.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
		
	}
	
	public void setPasswordField(String password) {
		
		this.wdw.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
		
	}
	

	public void setEmailField(String email) {
		
		this.wdw.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
		
	}
	
	public void setFirstnameField(String firstname) {
		
		this.wdw.until(ExpectedConditions.visibilityOf(firstnameField)).sendKeys(firstname);
		
	}
	
	public void setLastnameField(String lastname) {
		
		this.wdw.until(ExpectedConditions.visibilityOf(lastnameField)).sendKeys(lastname);
		
	}
	
	public void setPhoneNumberField(String phoneNumber) {
		
		this.wdw.until(ExpectedConditions.visibilityOf(phoneNumberField)).sendKeys(phoneNumber);
		
	}
	
	public void setAgeField(String age) {
		
		this.wdw.until(ExpectedConditions.visibilityOf(ageField)).sendKeys(age);
		
	}
	
	
	
	
}
