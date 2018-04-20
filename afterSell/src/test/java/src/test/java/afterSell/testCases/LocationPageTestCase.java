package src.test.java.afterSell.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GladMinds.afterSell.GenericLib.GenericFunctions;
import com.GladMinds.afterSell.PageObjectModel.LocationPage;

public class LocationPageTestCase extends GenericFunctions{
	@Test 
    public void verify_addLocation_Btn() throws Exception {
  
   LocationPage obj=PageFactory.initElements(driver, LocationPage.class);
   obj.allOperations();
   System.out.println("verifying addLocation_Btn...");
   String Actual = "http://qa.aftersell.care/aftersell/service-provider/location";
   String expected = driver.getCurrentUrl();
   Assert.assertEquals(Actual, expected, "ASSERTION FAILED...");
   System.out.println("verified addLocation Btn...");
  
	}
}
