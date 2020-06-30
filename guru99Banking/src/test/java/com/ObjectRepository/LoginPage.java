package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	@FindBy(xpath = "//input[@name='uid']")
	private WebElement loginTextBox;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passTextBox;
	
	@FindBy(xpath = "//input[@name='btnLogin']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//input[@name='btnReset']")
	private WebElement resetbutton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterUser(String un)
	{
		loginTextBox.sendKeys(un);
	}
	public void enterPassword(String pw)
	{
		passTextBox.sendKeys(pw);
	}
	public void clickLoginBtn()
	{
		loginButton.click();
	}
	public void clickresetBTN()
	{
		resetbutton.click();
	}

}
