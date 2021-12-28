package com.revature.model.components;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecipeSummaryComponent {

	private WebDriver driver; 
	private WebDriverWait wdw; 
	
	@FindBy(xpath = "")
	private WebElement titleElement;
	
	@FindBy(xpath = "")
	private WebElement likesElement;
	
	@FindBy(xpath = "")
	private WebElement followersElement;
	
	@FindBy(xpath = "")
	private WebElement pictureElement;
	
	public RecipeSummaryComponent(WebDriver driver) {
		
		this.driver = driver;
		
		wdw = new WebDriverWait(this.driver, Duration.ofSeconds(2));
		
		PageFactory.initElements(this.driver, this);
		
	}
	
	public void getPicture() {
		
		//stub
		
	}
	
	public String getTitleText() {
		
		return wdw.until(ExpectedConditions.visibilityOf(titleElement)).getText();
			
	}
	
	public int getNumLikes() {
		
		String likesString = wdw.until(ExpectedConditions.visibilityOf(likesElement)).getText();
		return Integer.parseInt(likesString);
		
	}
	
	public int getNumFollowers() {
		
		String followersString = wdw.until(ExpectedConditions.visibilityOf(followersElement)).getText();
		return Integer.parseInt(followersString);
		
	}
	
	
}
