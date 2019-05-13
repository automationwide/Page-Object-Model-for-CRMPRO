package com.crm.qa.testcases;
/*
 * Author - Jolomi Thompson
 * 
 */
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.utilities.TestUtility;

public class HomePageTest extends TestBase {
	LandingPage landingPage;
	HomePage homePage;
	TestUtility testUtility;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtility = new TestUtility();
		landingPage = new LandingPage();
		contactsPage = new ContactsPage();
		homePage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitle() {
		log.info("***************Veriying Home Page Title**************");
		String homePageTitle = homePage.verifyHomPageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "The Home Page title is incorrect");
		
		
	}
	
	@Test(priority = 2)
	public void verifyCorrectUsername() {
		testUtility.switchToFrame();
		boolean correctUser = homePage.verifyUserName();
		Assert.assertTrue(correctUser);
		
	}
	@Test(priority =  3)
	public void verifyContactLinkTest() {
		testUtility.switchToFrame();
		contactsPage = homePage.clickOnContactsBtn();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
