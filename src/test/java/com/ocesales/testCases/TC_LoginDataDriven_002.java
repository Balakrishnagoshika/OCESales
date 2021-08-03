package com.ocesales.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ocesales.pageObjects.LoginPage;
import com.ocesales.utilities.XLUtils;

public class TC_LoginDataDriven_002 extends BaseClass
{


	@Test(dataProvider="logindata")
	public void loginDataDriven(String user, String pwd) throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		logger.info("URL is opened");
		lp.setUserName(user);
		logger.info("Entered Username");
		lp.setPassword(pwd);
		logger.info("Entered Password");
		lp.clickButton();
		
		if(driver.getTitle().equals("Home | Salesforce"))
		{
			Assert.assertTrue(true);
			logger.info("Login test Passed");
			lp.clickUserProfile();
			logger.info("Clicked on Veiw Profile");
			lp.clickLogOut();
			logger.info("page logout successfully");
			driver.switchTo().defaultContent();
			logger.info("reached to login page");
			
		}
		else
		{
			lp.errorMsg();
			Assert.assertTrue(false);
			logger.info("Login test Failed");
			lp.setUserName("");
			driver.switchTo().defaultContent();
		}
	}


	@DataProvider(name = "logindata")
    String [][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/ocesales/testData/LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", rownum);
		
		String logindata [][] = new String[rownum][colcount];
		
		for(int i=1; i<rownum; i++) 
		{
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return logindata;
		
	}

	
}
