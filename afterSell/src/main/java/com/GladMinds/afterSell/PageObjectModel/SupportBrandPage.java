package com.GladMinds.afterSell.PageObjectModel;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.GladMinds.afterSell.GenericLib.GenericFunctions;

public class SupportBrandPage {
	@FindBy(xpath=".//*[@id='side']/li[3]/a")
	WebElement my_company_detail_link;
	@FindBy(xpath=".//*[@id='page-wrapper']/div/div[2]/div[4]/div/a/div/i")
	WebElement support_Brand_btn;
	@FindBy(xpath=".//*[@id='page-wrapper']/div/div[2]/div/div/div[1]/a/div")
	WebElement add_Breand;
	@FindBy(xpath=".//*[@id='spUserform']/div/select")
	WebElement picklist;
	@FindBy(xpath=".//*[@id='spUserform']/button")
	WebElement submit_btn;
	@FindBy(xpath="(.//input[@class='support-brand-id'])[1]")
	WebElement deleteing_element;
	@FindBy(xpath=".//*[@id='deleteSupportBrand']")
	WebElement delete_brand;
	
	
	public void check_add_brand() {
		GenericFunctions.implicitly_wait(10);
		my_company_detail_link.click();
		support_Brand_btn.click();
		add_Breand.click();
		Select select_value = new Select(picklist);
		select_value.selectByIndex(0);;

		submit_btn.click();
	}
	public void check_delete_brand() {
		GenericFunctions.implicitly_wait(10);
		my_company_detail_link.click();
		support_Brand_btn.click();
		deleteing_element.click();
		delete_brand.click();
		
	}
}
