package com.crm.qa.testcases;
 
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.utilities.TestUtility;

public class ContactsPageTest extends TestBase {
	LandingPage landingPage;
	HomePage homePage;
	TestUtility testUtility;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	public ContactsPageTest(){
		super();
		
}


		@BeforeMethod
		public void setUp() throws InterruptedException {
			
			initialization();
			testUtility = new TestUtility();
			contactsPage = new ContactsPage();
			landingPage = new LandingPage();
			homePage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
			// TestUtility.runTimeInfo("error", "login successful");
			testUtility.switchToFrame();
			contactsPage = homePage.clickOnContactsBtn();
		}
		
		@Test(priority = 1)
		public void verifyContactsPageLabel(){
			Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
		}
		
		@Test(priority = 2)
		public void selectSingleContactsTest(){
			contactsPage.selectContactsByName("Jon Jones");
		}
		
		@Test(priority = 3)
		public void selectMultipleContactsTest(){
			contactsPage.selectContactsByName("Derek Rose");
			contactsPage.selectContactsByName("Conor McGregor");
		}
		
		@DataProvider
		public Object[][] getCRMTestData() throws InvalidFormatException{
			Object data[][] = TestUtility.getTestData(sheetName);
			return data;
		}
		
		/*@Test(priority = 4)
		public void CreateNewContactTest(){
			homePage.clickOnNewContactDrop();
			contactsPage.createNewContact("Mr.", "Daniel", "Cormier", "UFC");
			
			
		}*/
		
		//this is using the data driven method
		
		@Test(priority=4, dataProvider="getCRMTestData")
		public void validateCreateNewContact(String title, String firstName, String lastName, String company){
			homePage.clickOnNewContactDrop();
			contactsPage.createNewContact(title, firstName, lastName, company);
			
		}
		
		
			
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}

}



