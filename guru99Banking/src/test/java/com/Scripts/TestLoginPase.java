package com.Scripts;

import org.testng.annotations.Test;

import com.ObjectRepository.LoginPage;
import com.generics.BaseClass;
import com.generics.FWUtills;

public class TestLoginPase extends BaseClass
{
	@Test
	public void loginPage() throws InterruptedException
	{
		String user = FWUtills.read_XL_Data(XL_DATA, "LoginPage",1,0);
		String pass = FWUtills.read_XL_Data(XL_DATA, "LoginPage",1,1);
		String expectedTitle =FWUtills.read_XL_Data(XL_DATA, "LoginPage",1,2);
	    
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(2000);
		lp.enterUser(user);
		lp.enterPassword(pass);
		Thread.sleep(2000);
		lp.clickLoginBtn();
	    FWUtills.verifiePage(driver, expectedTitle);
	
	
	}

}
