package com.crm.qa.testcases;
/*
 * Author = Jolomi Thompson
 * 
 */
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;

public class LandingPageTest extends TestBase {
	LandingPage landingPage;
	HomePage homepage;
	
	public LandingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LandingPage();	
	}
	
	@Test(priority = 1)
	public void landingPageTitleTest() {
		String title = landingPage.validateLandingPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority = 2)
	public void crmLogoTest() {
		boolean flag = landingPage.validateCRMLogo();
		Assert.assertTrue(flag);	
	}
	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		homepage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

