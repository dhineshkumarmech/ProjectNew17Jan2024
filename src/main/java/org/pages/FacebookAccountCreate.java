package org.pages;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookAccountCreate extends BaseClass{

	public FacebookAccountCreate() {

		PageFactory.initElements(driver, this);	
     }
	
	@FindBy(name = "firstname")
	private WebElement fname;
	
	@FindBy(name = "lastname")
	private WebElement lname;
	
	@FindBy(name = "reg_email__")
	private WebElement mobnum;
	
	@FindBy(name = "reg_passwd__")
	private WebElement acpass;
	
	@FindBy(id = "day")
	private WebElement sDay;
	
	@FindBy(id = "month")
	private WebElement sMonth;
	
	@FindBy(id = "year")
	private WebElement sYear;
	
	@FindBy(xpath = "//input[@value='1']")
	private WebElement female;
	
	@FindBy(xpath = "//input[@value='2']")
	private WebElement male;
	
	@FindBy(xpath = "//input[@value='-1']")
	private WebElement custom;
	
	@FindBy(xpath = "(//button[text()='Sign Up'])[1]")
	private WebElement signUp;
	

	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname;
	}

	public WebElement getMobnum() {
		return mobnum;
	}

	public WebElement getAcpass() {
		return acpass;
	}

	public WebElement getsDay() {
		return sDay;
	}

	public WebElement getsMonth() {
		return sMonth;
	}

	public WebElement getsYear() {
		return sYear;
	}

	public WebElement getFemale() {
		return female;
	}

	public WebElement getMale() {
		return male;
	}

	public WebElement getCustom() {
		return custom;
	}

	public WebElement getSignUp() {
		return signUp;
	}
	
	
}
