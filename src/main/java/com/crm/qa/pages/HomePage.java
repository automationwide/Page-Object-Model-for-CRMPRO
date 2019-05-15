package com.crm.qa.pages;
/*
 * Author - Jolomi Thompson
 * 
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(),'User: Jays slimz')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksBtn;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactBtn;
	
	//Initialising the Page Objects 
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomPageTitle() {
		
		return driver.getTitle();	
	}
	
	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsBtn() {
		contactsBtn.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsBtn() {
		dealsBtn.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksBtn() {
		tasksBtn.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactDrop() {
		Actions actions = new Actions(driver);
		actions.moveToElement(contactsBtn).build().perform();
		newContactBtn.click();
	}

}
