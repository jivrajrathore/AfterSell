package com.GladMinds.afterSell.PageObjectModel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.GladMinds.afterSell.GenericLib.GenericFunctions;

public class AMCServicePage {
@FindBy(xpath=".//*[@id='side']/li[2]/a")
WebElement service_link;
@FindBy(xpath=".//*[@id='page-wrapper']/div/div[2]/div[1]/div/a/div/i")
WebElement amc_service;
@FindBy(xpath=".//*[@id='page-wrapper']/div/div[2]/div[2]/div/a/div/i")
WebElement amc_detail;
@FindBy(xpath="(.//input[@class='amc-detail-id'])[2]")
WebElement checkBox;
@FindBy(xpath=".//*[@id='init_amc_update_modal']/div")
WebElement amc_detail_btn;
@FindBy(xpath=".//*[@id='amc_rate']")
WebElement rate;
@FindBy(xpath=".//*[@id='amc_amount']")
WebElement amount;
@FindBy(xpath=".//*[@id='amc_detail_start_date']")
WebElement startDate;
@FindBy(xpath=".//*[@id='amc_detail_end_date']")
WebElement endDate;
@FindBy(xpath=".//*[@id='amcdetailUpdate']")
WebElement submit_btn;


public void check_AMC_Detail() {
	GenericFunctions.implicitly_wait(10);
	service_link.click();
	amc_service.click();
	amc_detail.click();
	GenericFunctions.performOnElement(checkBox);
	amc_detail_btn.click();
	rate.sendKeys("10");
	amount.sendKeys("10000");
	startDate.sendKeys("2017-01-01");
	startDate.sendKeys(Keys.TAB);
	endDate.sendKeys("2018-01-01");
	endDate.sendKeys(Keys.TAB);
	submit_btn.click();
	
}
}
