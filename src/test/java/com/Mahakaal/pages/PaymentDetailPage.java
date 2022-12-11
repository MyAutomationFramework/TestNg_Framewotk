package com.Mahakaal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javabase.JavaBase;

public class PaymentDetailPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//button[@type='btn']")
	  WebElement paymetdetail;
	
	public PaymentDetailPage(WebDriver driver){
	     this.driver=driver;
}
	
	public void clickonPaymentDetail() {
		JavaBase.clickOn("paymetdetail",paymetdetail,2);
	}
	
	
	
}
