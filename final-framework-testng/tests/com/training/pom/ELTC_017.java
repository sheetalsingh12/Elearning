package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_017 {
private WebDriver driver; 
	
	public ELTC_017(WebDriver driver)
	 {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="login")
	private WebElement adminusername; 
	
	@FindBy(id="password")
	private WebElement adminpassword;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement adminloginBtn; 
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement dropdown11;
	
	@FindBy(id="logout_button")
	private WebElement adminlogoutink;
	
	
	public void sendAdminUserName(String userName) {
		this.adminusername.clear();
		this.adminusername.sendKeys(userName);
	}
	
	public void sendAdminPassword(String password) {
		this.adminpassword.clear(); 
		this.adminpassword.sendKeys(password); 
	}
	
	public void clickAdminLoginBtn() {
		this.adminloginBtn.click(); 
	}
	
	public void clickDropdown11() {
		this.dropdown11.click(); 
	}
	
	public void clickAdminLogoutLink() {
		this.adminlogoutink.click();
	}
}
