package com.GladMinds.afterSell.GenericLib;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.GladMinds.afterSell.PageObjectModel.LoginPage;

public class GenericFunctions {
	public static WebDriver driver;
	static int time = 20;
	public static WebDriverWait waits = null;

	public static void openBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src//main//resources//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browserName.equals("chrome incongnito mode")) {
			System.setProperty("webdriver.driver.chrome", "src//main//resources//drivers//chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			driver.manage().window().maximize();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src//main//resources//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		/*
		 * else if(browserName.equals("firefox private window")) {
		 * System.setProperty("webdriver.gecko.driver",
		 * "src//main//resources//drivers//geckodriver.exe"); FirefoxProfile
		 * firefoxProfile = new FirefoxProfile();
		 * firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);
		 * driver = new FirefoxDriver( firefoxProfile); }
		 */
		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "src//main//resources//drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}

	public static void getURL(String url) {
		driver.navigate().to(url);
	}

	@BeforeClass(description = "this method execute before the class")
	public static void main() throws UnsupportedEncodingException, IOException {
		ReadProperties object = ReadProperties.getInstence();
		// String value = object.getValue("browser");
		openBrowser(object.getValue("browser"));
		// String urlValue = object.getValue("url");
		getURL(object.getValue("url"));
		LoginPage obj = PageFactory.initElements(driver, LoginPage.class);
		obj.verifyLogin();
	}

	/*
	 * @AfterClass public static void close() { driver.quit(); }
	 */
	public static void selectFormDDL(WebElement element, String value) {
		Select select_value = new Select(element);
		select_value.selectByVisibleText(value);
	}

	public static void performOnElement(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}

	public static void implicitly_wait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static void visibility_of_elements( WebElement element, int time) {
		waits = new WebDriverWait(driver, time);
		waits.until(ExpectedConditions.visibilityOf(element));
	}

	public static void elementToBeClickeble(WebElement element, int time) {
		waits = new WebDriverWait(driver, time);
		waits.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void presence_of_located_element(String className, int time) {
		waits = new WebDriverWait(driver, time);
		waits.until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
	}
}
