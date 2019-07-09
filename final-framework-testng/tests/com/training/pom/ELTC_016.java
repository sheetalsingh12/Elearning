package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_016 {
	private WebDriver driver; 
	
	public ELTC_016(WebDriver driver)
	 {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName1; 
	
	@FindBy(id="password")
	private WebElement password1;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn1; 
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement dropdown;
	
	@FindBy(id="logout_button")
	private WebElement logoutink;
	
	public void sendUserName1(String userName) {
		this.userName1.clear();
		this.userName1.sendKeys(userName);
	}
	
	public void sendPassword1(String password) {
		this.password1.clear(); 
		this.password1.sendKeys(password); 
	}
	
	public void clickLoginBtn1() {
		this.loginBtn1.click(); 
	}
	
	public void clickDropdown() {
		this.dropdown.click(); 
	}
	
	public void clickLogoutLink() {
		this.logoutink.click(); 
	}

  }

