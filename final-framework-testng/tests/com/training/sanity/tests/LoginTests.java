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
import com.training.pom.ELTC_017;
import com.training.pom.ELTC_018;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ELTC_016 eltc_016;
	private ELTC_017 eltc_017;
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
		loginPOM = new LoginPOM(driver); 
		eltc_016 = new ELTC_016(driver);
		eltc_017 = new ELTC_017(driver);
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
		loginPOM.sendUserName("sheetal1122");
		loginPOM.sendPassword("Sheetal009933");
		//screenShot.captureScreenShot("First01");
		loginPOM.clickLoginBtn(); 
		//screenShot.captureScreenShot("Second01");
		Thread.sleep(1000);
		eltc_016.clickDropdown();
		Thread.sleep(500);
		//screenShot.captureScreenShot("Third01");
		eltc_016.clickLogoutLink();
		//screenShot.captureScreenShot("First01");
		eltc_017.sendAdminUserName("admin");
		eltc_017.sendAdminPassword("admin@123");
		eltc_017.clickAdminLoginBtn();
		Thread.sleep(500);
		eltc_017.clickDropdown11();
		Thread.sleep(500);
		eltc_017.clickAdminLogoutLink();
		loginPOM.sendUserName("sheetal1122");
		loginPOM.sendPassword("Sheetal009933");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(500);
		eltc_016.clickDropdown();
		eltc_018.clickViewProfile();
		Thread.sleep(500);
		eltc_018.clickEditProfile();
		Thread.sleep(500);
		eltc_018.sendPasswordOld("Sheetal009933");
		Thread.sleep(500);
		eltc_018.sendPasswordNew("Sheetalsingh12");
		Thread.sleep(1000);
		eltc_018.sendPasswordNewConfirm("Sheetalsingh12");
		Thread.sleep(1000);
		eltc_018.clickSaveSettings();
		Thread.sleep(500);	
		String Expectedname = "Your new profile has been saved";
	    String Actualname = eltc_018.verifyPasswordChange();
	    Assert.assertEquals(Actualname, Expectedname);
	    System.out.println("Pass");
	    
	}
}
