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
import com.training.pom.ELTC_018;
//import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCase3 {

	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private ELTC_018 eltc_018;
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
		eltc_018 = new ELTC_018(driver);
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
		eltc_018.sendUserName3("sheetal1122");
		eltc_018.sendPassword3("Sheetal009933");
		eltc_018.clickLoginBtn3(); 
		eltc_018.clickDropdown3();
		//Thread.sleep(500);
		eltc_018.clickViewProfile();
		//Thread.sleep(500);
		eltc_018.clickEditProfile();
		//Thread.sleep(500);
		eltc_018.sendPasswordOld("Sheetal009933");
		//Thread.sleep(500);
		eltc_018.sendPasswordNew("Sheetalsingh12");
		Thread.sleep(1000);
		eltc_018.sendPasswordNewConfirm("Sheetalsingh12");
		//Thread.sleep(1000);
		eltc_018.clickSaveSettings();
		//screenShot.captureScreenShot("Third01");
		//Thread.sleep(500);	
		String Expectedname = "Your new profile has been saved";
	    String Actualname = eltc_018.verifyPasswordChange();
	    Assert.assertEquals(Actualname, Expectedname);
	    System.out.println("Pass");
	    screenShot.captureScreenShot("Third");

	    
	}
}
