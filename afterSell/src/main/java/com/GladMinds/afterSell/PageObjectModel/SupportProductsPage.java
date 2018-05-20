package com.GladMinds.afterSell.PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.GladMinds.afterSell.GenericLib.GenericFunctions;


public class SupportProductsPage {
@FindBy(xpath=".//*[@id='side']/li[3]/a")
WebElement my_company_detail_link;
@FindBy(xpath=".//*[@id='page-wrapper']/div/div[2]/div[3]/div/a/div/i")
WebElement support_product_btn;
@FindBy(xpath=".//*[@id='page-wrapper']/div/div[2]/div/div/div[1]/a/div")
WebElement addProduct_btn;
@FindBy(xpath=".//*[@id='spUserform']/div/select/option[1]")
WebElement Building_btn;
@FindBy(xpath=".//*[@id='spUserform']/button")
WebElement submit_btn;

@FindBy(xpath="(.//input[@class='support-product-id'])[1]")
WebElement first_checkBox;
@FindBy(xpath=".//*[@id='deleteSupportProduct']")
WebElement delete_product_btn;


public void check_addProduct_btn() {
	GenericFunctions.implicitly_wait(10);
	my_company_detail_link.click();
	support_product_btn.click();
	addProduct_btn.click();
	Building_btn.click();
	submit_btn.click();
}

public void delete_Product() {
	GenericFunctions.implicitly_wait(10);
	my_company_detail_link.click();
	support_product_btn.click();
	first_checkBox.click();
	delete_product_btn.click();
}
}