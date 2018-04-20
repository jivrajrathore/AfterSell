package com.GladMinds.afterSell.PageObjectModel;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.GladMinds.afterSell.GenericLib.ReadProperties;

public class LoginPage {
	@FindBy(xpath = "(.//input[@name='email'])[1]")
	WebElement userName;
	@FindBy(xpath = "(.//input[@name='password'])[1]")
	WebElement passWord;
	@FindBy(xpath = "(.//button[@type='submit'])[1]")
	WebElement logIn;

	public void verifyLogin() throws UnsupportedEncodingException, IOException {
		ReadProperties obj = ReadProperties.getInstence();

		userName.sendKeys(obj.getValue("username"));
		passWord.sendKeys(obj.getValue("password"));
		logIn.click();
	}
}
