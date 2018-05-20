package src.test.java.afterSell.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GladMinds.afterSell.GenericLib.GenericFunctions;
import com.GladMinds.afterSell.PageObjectModel.LocationPage;

public class LocationPageTestCase extends GenericFunctions {

	@Test
	public void verify_Locations() throws Exception {
		LocationPage obj = PageFactory.initElements(driver, LocationPage.class);
		
		obj.check_Deactivate_Location_Btn();
		System.out.println("deactivate location button is verifying..");
		String actual = "Deactivation Successfull for Locations [Madivala(M1)]";
		String expected = driver
				.findElement(By.xpath(".//strong[text()='Deactivation Successfull for Locations [Madivala(M1)]']"))
				.getText();
		Assert.assertEquals(actual, expected, "this method is fail");
		System.out.println("deactivate location button is verified..");
		/*
		 * obj.allOperations(); System.out.println("verifying addLocation_Btn...");
		 * String Actual ="http://qa.aftersell.care/aftersell/service-provider/location"; 
		 * String expected = driver.getCurrentUrl(); 
		 * Assert.assertEquals(Actual, expected, "ASSERTION FAILED..."); System.out.println("verified addLocation Btn...");
		 */
	}
}
