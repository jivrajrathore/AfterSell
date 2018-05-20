package src.test.java.afterSell.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GladMinds.afterSell.GenericLib.GenericFunctions;
import com.GladMinds.afterSell.PageObjectModel.SupportProductsPage;

public class SupportProductsTestCase extends GenericFunctions{

	@Test
	public void support_product_btn()
{
		SupportProductsPage obj = PageFactory.initElements(driver, SupportProductsPage.class);
		obj.check_addProduct_btn();
		String Actual = "Service Provider Support Product Added Successfully";
        String expected = driver.findElement(By.xpath(".//*[@id='page-wrapper']/div/div[1]/div[2]/div/strong")).getText();  
        Assert.assertEquals(Actual, expected, "check addProduct btm method failed");
        System.out.println("verified check addProduct btn ..");
        
        obj.delete_Product();
        String Act  = "Service Provider Support Products Deleted Successfully";
        String exp = driver.findElement(By.xpath(".//*[@id='page-wrapper']/div/div[1]/div[2]/div/strong")).getText();
        Assert.assertEquals(Act, exp);
        System.out.println("verified delete_product btn succesfully...");
}
}
