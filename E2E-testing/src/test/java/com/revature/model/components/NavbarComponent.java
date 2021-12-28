package com.revature.model.components;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavbarComponent {

	//Oh this one is going to be complicated.....lots of functionality..yay...
	
	private WebDriver driver; 
	private WebDriverWait wdw; 
	
	@FindBy(xpath = "")
	private WebElement searchField;
	
	@FindBy(xpath = "")
	private WebElement searchButton; 
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	private WebElement homeButton;
	
	@FindBy(xpath = "")
	private WebElement navigationMenuDropdown;
	
	@FindBy(xpath = "//a[contains(text(),'User profile')]")
	private WebElement profileLink;
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	private WebElement signinLink;
	
	@FindBy(xpath = "//a[contains(text(),'Sign up')]")
	private WebElement signupLink;
	
	@FindBy(xpath = "//a[contains(text(),'Sign out')]")
	private WebElement signoutLink;
	
	@FindBy(xpath = "")
	private WebElement filterDropdown;
	
	@FindBy(xpath = "")
	private WebElement categoryDropdown;
	
	@FindBy(xpath = "")
	private WebElement areaDropdown; 
	
	@FindBy(xpath = "")
	private WebElement tagsDropdown;
	
	@FindBy(xpath = "//button[@id='random-recipe']")
	private WebElement randomRecipeButton;
	
	//Need to add other webelements for any links that are under these filter dropdowns
	
	public NavbarComponent(WebDriver driver) {
		
		this.driver = driver;
		
		wdw = new WebDriverWait(this.driver, Duration.ofSeconds(2));
		
		PageFactory.initElements(this.driver, this);
		
	}
	
	
	public String getSearchText() {
		
		return wdw.until(ExpectedConditions.visibilityOf(searchField)).getText();
		
	}
	
	public void clickSearch() {
		
		wdw.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
		
	}
	
	public void clickHome() {
		
		wdw.until(ExpectedConditions.visibilityOf(homeButton)).click();
		
	}
	
	public void hoverNavigationMenu() {		//for hovering over navigation menu dropdown. Need to perform to have access to profile, signout, signin functions
		
		Actions action = new Actions(driver);
		
		action.moveToElement(navigationMenuDropdown).build().perform();
		
	}
	
	public void clickProfileLink() {
		
		wdw.until(ExpectedConditions.elementToBeClickable(profileLink)).click();
		
	}
	
	public void clickSigninLink() {
		
		wdw.until(ExpectedConditions.elementToBeClickable(signinLink)).click();
		
	}
	
	public void clickSignoutLink() {
		
		wdw.until(ExpectedConditions.elementToBeClickable(signoutLink)).click();
		
	}
	
	public void hoverFilterMenu() {		//need to hover over this to have access to search filter buttons
		
		Actions action = new Actions(driver);
		
		action.moveToElement(filterDropdown).build().perform();
		
	}
	
	public void hoverCategoryDropdown() {
		
		Actions action = new Actions(driver);
		
		action.moveToElement(categoryDropdown).build().perform();
		
	}
	
	public void hoverAreaDropdown() {
		
		Actions action = new Actions(driver);
		
		action.moveToElement(areaDropdown).build().perform();
		
	}
	
	public void hoverTagsDropdown() {
		
		Actions action = new Actions(driver);
		
		action.moveToElement(tagsDropdown).build().perform();		
	}
	
	public void setSearchField(String query) {
		
		this.wdw.until(ExpectedConditions.visibilityOf(searchField)).sendKeys(query);
		
	}
	
	public void clickRandomRecipe() {
		
		this.wdw.until(ExpectedConditions.elementToBeClickable(randomRecipeButton)).click();
		
	}
	
	public void clickSignup() {
		
		this.wdw.until(ExpectedConditions.elementToBeClickable(signupLink)).click();
		
	}
	
	
	
	
	//Going to need to add more actions and webelements as this component develops. As of now, I do not know which specific filter options we will provide
	
	
	
	
	
	
}
