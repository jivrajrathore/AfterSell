package com.GladMinds.afterSell.PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.GladMinds.afterSell.GenericLib.GenericFunctions;
import com.GladMinds.afterSell.GenericLib.ReadExcelData;

public class LocationPage extends GenericFunctions {

	@FindBy(xpath = ".//*[@id='side']/li[3]/a")
	 WebElement my_Company_Details_Link;
	@FindBy(xpath = ".//*[@id='page-wrapper']/div/div[2]/div[1]/div/a/div/i")
	WebElement Locations_Btn;
	@FindBy(xpath = ".//*[@id='page-wrapper']/div/div[2]/div/div/div[1]/a/div[1]")
	WebElement add_Location_Btn;
	@FindBy(xpath = ".//input[@class='form-control model-form' and @name='location_name']")
	WebElement location_Name_Field;
	@FindBy(xpath = "(.//input[@class='form-control model-form'])[2]")
	WebElement location_Code_Field;
	@FindBy(xpath = "//textarea[@class='form-control']")
	WebElement address_Field;
	@FindBy(xpath = "(//select[@class='form-control model-form'])[1]")
	WebElement country_Picklist;
	@FindBy(xpath = "(.//input[@class='form-control model-form'])[3]")
	WebElement state_Field;
	@FindBy(xpath = "(.//input[@class='form-control model-form'])[4]")
	WebElement city_Field;
	@FindBy(xpath = "(.//input[@class='form-control model-form'])[5]")
	WebElement pincode_Field;
	@FindBy(xpath = "(//select[@class='form-control model-form'])[2]")
	WebElement office_Type_Picklist;
	@FindBy(xpath = "(.//input[@class='form-control model-form'])[6]")
	WebElement is_active_Checkbox;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit_Btn;
	
	@FindBy(xpath=".//td/a[text()='M1']")
	WebElement firstRecord;
	@FindBy(xpath=".//input[@id='location-19']")
	WebElement selecteCheckBox;
	@FindBy(xpath=".//*[@id='deactivateServiceproviderlocation']")
	WebElement deactivateLocationBtn;
	
	public void check_Deactivate_Location_Btn() {
		GenericFunctions.implicitly_wait(10);
		my_Company_Details_Link.click();
		Locations_Btn.click();
		firstRecord.click();
		is_active_Checkbox.click();
		submit_Btn.click();
		GenericFunctions.performOnElement(selecteCheckBox);
        deactivateLocationBtn.click();
	}
	
	int i;
	int row;
	private String locationName;
	private String locationCode;
	private String address;
	private String country;
	private String state;
	private String city;
	private String pinCode;
	private String officeType;
	
	
	 public void add_location_method(String locationNameA, String locationCodeA, String addressA, String countryA, String stateA, String cityA, String pincodeA , String officeTypeA) {
		 location_Name_Field.sendKeys(locationNameA);
			location_Code_Field.sendKeys(locationCodeA);
			address_Field.sendKeys(addressA);
			country_Picklist.sendKeys(countryA);
			state_Field.sendKeys(stateA);
			city_Field.sendKeys(cityA);
			pincode_Field.sendKeys(pincodeA);
			office_Type_Picklist.sendKeys(officeTypeA);
			performOnElement(is_active_Checkbox);
			submit_Btn.click(); 
	 }
	
	public void allOperations() throws Exception {
	
	           	int lastRowNum = ReadExcelData.getRowCOunt("location_data");
	             System.out.println("last row number of sheet(location_data) "+lastRowNum);
	
	             row = ReadExcelData.getCellRowNum("location_data", 8, "No");
	             System.out.println("found No in row Number "+row);
	    
	    for( i =row;i<=lastRowNum;i++) {
	         	row =i ;
	         	String val = ReadExcelData.getCellData("location_data", 8, i);
    	    	if(val.equalsIgnoreCase("No")) {
	    		
	    		locationName = ReadExcelData.getCellData("location_data", 0, i);
	    		locationCode = ReadExcelData.getCellData("location_data", 1, i);
	    		address      = ReadExcelData.getCellData("location_data", 2, i);
	    		country      = ReadExcelData.getCellData("location_data", 3, i);
	    		state        = ReadExcelData.getCellData("location_data", 4, i);
	    		city         = ReadExcelData.getCellData("location_data", 5, i);
	    		pinCode      = ReadExcelData.getCellData("location_data", 6, i);
	    		officeType   = ReadExcelData.getCellData("location_data", 7, i);
	    		
	    		my_Company_Details_Link.click();
	    		Locations_Btn.click();
	    		GenericFunctions.elementToBeClickeble(add_Location_Btn, 20);
	    		add_Location_Btn.click();
	    		
	    		add_location_method(locationName, locationCode, address, country, state, city, pinCode, officeType);
	    		ReadExcelData.setCellValue("location_data", 8, row, "ADDED");
	    		System.out.println("location succesfully Added");
	    			    	}
    	    	else {
	    			System.out.println("location is not added");
	    		}

	    }
	}
	
	
}
