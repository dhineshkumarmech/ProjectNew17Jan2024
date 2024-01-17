package org.pages;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Facebooklogin extends BaseClass{
	
	public Facebooklogin() {
		PageFactory.initElements(driver,this);	
		}
		
		@FindBy(id="email")
		private WebElement textUserName;
		
		@FindBy(id="pass")
		private WebElement textpass;
		
		@FindBy(name="login")
		private WebElement click;
		
		@FindBy(linkText = "Create new account")
		private WebElement createNewAct;

		

		public WebElement getTextUserName() {
			return textUserName;
		}

		public WebElement getTextpass() {
			return textpass;
		}

		public WebElement getClick() {
			return click;
		}
		
		public WebElement getCreateNewAct() {
			return createNewAct;
		}
		
		

	}

