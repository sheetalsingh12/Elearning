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
import com.training.pom.ELTC_017;
//import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCase2 {

	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private ELTC_017 eltc_017;
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
		eltc_017 = new ELTC_017(driver);
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
		//screenShot.captureScreenShot("First01");
		eltc_017.sendAdminUserName("admin");
		eltc_017.sendAdminPassword("admin@123");
		eltc_017.clickAdminLoginBtn();
		//Thread.sleep(500);
		screenShot.captureScreenShot("Second01");
		eltc_017.clickDropdown11();
		//Thread.sleep(500);
		eltc_017.clickAdminLogoutLink();
	    System.out.println("Pass");
	    
	}
}
