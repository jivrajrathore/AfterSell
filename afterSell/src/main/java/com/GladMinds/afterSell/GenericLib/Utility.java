package com.GladMinds.afterSell.GenericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Utility {

	public static void screenShot(WebDriver driver, String name) throws IOException {
		TakesScreenshot sc = (TakesScreenshot) driver;
		File f = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./ScreenShots/"+name+".png"));
		System.out.println("ScreenShot taken");
	}
}
