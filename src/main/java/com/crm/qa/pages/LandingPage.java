package com.crm.qa.pages;
/*
 * Author = Jolomi Thompson
 * 
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LandingPage extends TestBase {
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpButton;
	
	@FindBy(xpath = "//a[contains(text(),'Pricing')]")
	WebElement pricingButton;
	
	@FindBy(xpath = "//a[contains(text(),'Features')]")
	WebElement featuresButton;
	
	@FindBy(xpath ="//a[contains(text(),'Features')]")
	WebElement customersButton;
	
	@FindBy(xpath = "//a[contains(text(),'Customers')]")
	WebElement contactsButton;
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement siteLogo;
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLandingPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return siteLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(5000);
		loginButton.click();
		return new HomePage();
	}

}
