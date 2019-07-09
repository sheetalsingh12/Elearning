package com.training.sanity.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.training.generics.ScreenShot;
import com.training.pom.ELTC_016;
//import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCase1 {

	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private ELTC_016 eltc_016;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		//loginPOM = new LoginPOM(driver); 
		eltc_016 = new ELTC_016(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		eltc_016.sendUserName1("sheetal1122");
		eltc_016.sendPassword1("Sheetal009933");
		//screenShot.captureScreenShot("First01");
		eltc_016.clickLoginBtn1(); 
		//screenShot.captureScreenShot("Second01");
		//Thread.sleep(1000);
		eltc_016.clickDropdown();
		//Thread.sleep(500);
		//screenShot.captureScreenShot("Third01");
		eltc_016.clickLogoutLink();
		screenShot.captureScreenShot("First01");
	    System.out.println("Pass");
	    
	}
}
