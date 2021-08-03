package com.ocesales.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ocesales.pageObjects.LoginPage;

public class TC_LoginLogout_003 extends BaseClass
{
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		//driver.get(baseURL);
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickButton();
		logger.info("login successfully");
		
		lp.clickUserProfile();
		logger.info("Clicked on Veiw profile");
		
		lp.clickLogOut();
		logger.info("Clicked on Logout.");
		
		if(driver.getTitle().equals("Sign in |  Salesforce"))
		{
			Assert.assertTrue(true);
			logger.info("Logout test Passed");
		}
		else 
		{
			captureScreen(driver, "loginLogout");
			Assert.assertTrue(false);
			logger.info("Logout test Failed");
		}
	}

}
