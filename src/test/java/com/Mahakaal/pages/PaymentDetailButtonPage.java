package com.Mahakaal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javabase.JavaBase;

public class PaymentDetailButtonPage {
			public WebDriver driver;

	 @FindBy(xpath="//button[@type='btn']")
	  WebElement paymetDetailBtn;
	 
	 public PaymentDetailButtonPage(WebDriver driver) {
		 this.driver=driver;
	}
	 
	 public void click_PaymentDetailBtn() {
		 JavaBase.clickOn("paymetDetailBtn",paymetDetailBtn,2);
	 }
	
}
