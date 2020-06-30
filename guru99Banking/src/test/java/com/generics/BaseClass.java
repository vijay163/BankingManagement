package com.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass implements IAutoConstants
{
	static
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
		System.setProperty(IE_KEY,IE_VALUE);
	}
	public static WebDriver driver;
	static int pass_count=0;
	static int fail_count=0;
	@BeforeClass
	@Parameters("browser")
	public static void launchBrowser(String browser)
	{
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new InternetExplorerDriver();
		}
	}
	@BeforeMethod
	public static void openApplication()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(ETO,TimeUnit.SECONDS);
		driver.get(URL);
	}
	@AfterMethod
	public static void colseApp(ITestResult result)
	{
		String testName = result.getName();
		int status = result.getStatus();
		if(status==1)
		{
			pass_count++;
		}
		else
		{
			fail_count++;
			String screen = PHOTO_PATH+testName+".png";
			FWUtills.takeScreenShot(driver,screen);
			
		}
	driver.close();
	

	}

}
