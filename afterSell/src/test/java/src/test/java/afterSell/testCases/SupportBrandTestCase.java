package src.test.java.afterSell.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GladMinds.afterSell.GenericLib.GenericFunctions;
import com.GladMinds.afterSell.PageObjectModel.SupportBrandPage;

public class SupportBrandTestCase extends GenericFunctions{
      
	@Test
	public void verify_Support_Brand() {
SupportBrandPage obj = PageFactory.initElements(driver, SupportBrandPage.class);
obj.check_add_brand();
String act = "Service Provider Support Brand Added Successfully";
String exp = driver.findElement(By.xpath(".//*[@id='page-wrapper']/div/div[1]/div[2]/div/strong")).getText();
Assert.assertEquals(act, exp);
System.out.println("Add Brand button working succesfully" );

obj.check_delete_brand();
String actual = "Service Provider Support Brands Deleted Successfully";
String expected = driver.findElement(By.xpath(".//*[@id='page-wrapper']/div/div[1]/div[2]/div/strong")).getText();
Assert.assertEquals(actual, expected );
System.out.println("delete brand button working successfully..");

	}
}
