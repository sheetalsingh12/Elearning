package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ELTC_018 {
private WebDriver driver; 
	
	public ELTC_018(WebDriver driver)
	 {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName3; 
	
	@FindBy(id="password")
	private WebElement password3;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn3; 
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement dropdown3;
	
	@FindBy(xpath="//p[@class='name']")
	private WebElement viewprofile;
	
	@FindBy(xpath="//a[@class='btn btn-default btn-sm btn-block']")
	private WebElement editprofile;
	
	@FindBy(id="profile_password0")
	private WebElement passwordenter;
	
	@FindBy(id="password1")
	private WebElement newpasswordenter;
	
	@FindBy(id="profile_password2")
	private WebElement confirmnewpasswordenter;
	
	
	@FindBy(id = "profile_apply_change")
	private WebElement savesettings;
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	private WebElement verify;
	
	
	public void sendUserName3(String userName) {
		this.userName3.clear();
		this.userName3.sendKeys(userName);
	}
	
	public void sendPassword3(String password) {
		this.password3.clear(); 
		this.password3.sendKeys(password); 
	}
	
	public void clickLoginBtn3() {
		this.loginBtn3.click(); 
	}
	
	public void clickDropdown3() {
		this.dropdown3.click(); 
	}
	

	public void clickViewProfile() {
		this.viewprofile.click(); 
	}
	
	public void clickEditProfile() {
		this.editprofile.click(); 
	}
	
	public void sendPasswordOld(String password) {
		this.passwordenter.clear(); 
		this.passwordenter.sendKeys(password);
		
	}
		public void sendPasswordNew(String password) {
			this.newpasswordenter.clear(); 
			this.newpasswordenter.sendKeys(password);
		}
		
			public void sendPasswordNewConfirm(String password) {
				this.confirmnewpasswordenter.clear(); 
				this.confirmnewpasswordenter.sendKeys(password);
			}
			public void clickSaveSettings() {
				this.savesettings.click(); 
			}
		public String verifyPasswordChange() {
			return this.verify.getText();
		}
}

