package com.ocesales.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ocesales.pageObjects.LoginPage;


public class TC_Loging_001 extends BaseClass
{
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		//driver.get(baseURL);
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered Username.");
		
		lp.setPassword(password);
		logger.info("Entered Password.");
		
		logger.info("Clicked on Login and waiting to load the home page.");
		lp.clickButton();
			
		//lp.clickUserProfile();
		//lp.clickLogOut();
	
		/*if(driver.getTitle().equals("Sign in |  Salesforce"))
		{
			Assert.assertTrue(true);
			logger.info("Login test Passed");
		}
		else 
		{
			Assert.assertTrue(false);
			logger.info("Login test Failed");
		}*/
		
		//if webpage is in translation then title is "Startseite | Salesforce"
		//if webpage is in English then title is "Home | Salesforce"
		
		if(driver.getTitle().equals("Home | Salesforce"))
		{

			Assert.assertTrue(true);
			logger.info("User is able to login successfully.....!");
			
		}
		else 
		{
		
			logger.info("Login test Failed....");
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		
			
			
		}
	}
}
