package com.revature.model.components;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookbookDetailedComponent {

	
	private WebDriver driver; 
	private WebDriverWait wdw; 
	
	@FindBy(xpath = "")
	private WebElement pictureElement; 
	
	@FindBy(xpath = "")
	private WebElement titleElement;
	
	@FindBy(xpath = "")
	private WebElement descriptionElement;
	
	@FindBy(xpath = "")
	private WebElement likesElement; 
	
	@FindBy(xpath = "")
	private WebElement followersElement;
	
	
	public CookbookDetailedComponent(WebDriver driver) {
		
		this.driver = driver; 
		wdw = new WebDriverWait(this.driver, Duration.ofSeconds(2));
		
		PageFactory.initElements(this.driver, this);
		
	}

	
	public String getTitleText() {
		
		return this.wdw.until(ExpectedConditions.visibilityOf(titleElement)).getText();
		
	}
	
	public String getDescriptionText() {
		
		return this.wdw.until(ExpectedConditions.visibilityOf(descriptionElement)).getText();
		
	}
	
	public int getNumLikes() {
		
		String likesString = this.wdw.until(ExpectedConditions.visibilityOf(likesElement)).getText();
		
		int numLikes = Integer.parseInt(likesString);
		
		return numLikes; 
		
	} 
	
	public int getNumFollowers() {
		
		String followersString = this.wdw.until(ExpectedConditions.visibilityOf(followersElement)).getText();
		
		int numFollowers = Integer.parseInt(followersString);
		
		return numFollowers; 
		
	}
	
	
	public void getPicture() {
		
		return; //I dont think we'll even need to implement this
		
	}
	
	
}
