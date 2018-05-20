package src.test.java.afterSell.testCases;


import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GladMinds.afterSell.GenericLib.GenericFunctions;
import com.GladMinds.afterSell.PageObjectModel.AMCServicePage;

public class AMCServiceTestCase extends GenericFunctions{
@Test
public void verify_AMC_Detail() {
	AMCServicePage obj = PageFactory.initElements(driver, AMCServicePage.class);
	obj.check_AMC_Detail();
	String actual = "Welcome krishna priya";
	String expected = driver.findElement(By.xpath(".//*[@id='page-wrapper']/div/div[1]/div/div/h1")).getText().trim();
	Assert.assertEquals(actual, expected);
	System.out.println("verify AMC Detail Button class..");
}
}
