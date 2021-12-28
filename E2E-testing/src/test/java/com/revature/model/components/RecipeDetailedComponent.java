package com.revature.model.components;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecipeDetailedComponent {

	private WebDriver driver;
	private WebDriverWait wdw;
	 
	@FindBy(xpath = "//body[1]/app-root[1]/app-random-recipe[1]/div[1]/div[1]/h1[1]")
	private WebElement titleElement;
	
	@FindBy(xpath = "")
	private WebElement pictureElement;
	
	@FindBy(xpath = "")
	private WebElement authorElement;
	
	@FindBy(xpath = "")
	private WebElement likesElement;
	
	@FindBy(xpath = "")
	private WebElement followersElement;
	
	@FindBy(xpath = "")
	private WebElement ingredientsElement;
	
	@FindBy(xpath = "")
	private WebElement timeElement;
	
	@FindBy(xpath = "")
	private WebElement stepsElement;
	
	
	public RecipeDetailedComponent(WebDriver driver) {
		
		this.driver = driver;
		
		wdw = new WebDriverWait(this.driver, Duration.ofSeconds(2));
		
		PageFactory.initElements(this.driver, this);
		
	}
	
	
	public String getTitleText() {
		
		return wdw.until(ExpectedConditions.visibilityOf(titleElement)).getText();
		
	}
	
	public void getPicture() {
		
		//stub
		
	}
	
	public String getAuthorText() {
		
		return wdw.until(ExpectedConditions.visibilityOf(authorElement)).getText();
		
	}
	
	public int getNumLikes() {
		
		String likesString = wdw.until(ExpectedConditions.visibilityOf(likesElement)).getText();
		
		return Integer.parseInt(likesString);
		
	}
	
	public int getNumFollowers() {
		
		String followersString = wdw.until(ExpectedConditions.visibilityOf(followersElement)).getText();
		
		return Integer.parseInt(followersString);
		
	}
	
	public String getIngredientsText() {
		
		return wdw.until(ExpectedConditions.visibilityOf(ingredientsElement)).getText();
		
	}
	
	public String getTimeText() {	//for returning the amount of time the recipe will take
		
		return wdw.until(ExpectedConditions.visibilityOf(timeElement)).getText();
		
	}

	public String getStepsText() {	//for returning all the steps in cooking the recipe
		
		return wdw.until(ExpectedConditions.visibilityOf(stepsElement)).getText();
		
	}
	
	
	
	
}
