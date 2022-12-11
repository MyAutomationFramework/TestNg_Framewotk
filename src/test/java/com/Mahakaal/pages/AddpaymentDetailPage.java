package com.Mahakaal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javabase.JavaBase;

public class AddpaymentDetailPage {

	    public WebDriver driver;
	@FindBy(xpath="//input[@name='payer_first_name']")
	  WebElement enterYourName;
	  
	  @FindBy(name="payer_last_name")
	  WebElement enterYourLastName;
	  
	  @FindBy(xpath="//input[@name='payer_contact']")
	  WebElement contactNum;
	  
	  @FindBy(name="payer_email")
	  WebElement enterYouremail;
	  
	  @FindBy(name="payer_address")
	  WebElement EnterYourAddress;
	  
	  @FindBy(xpath="//button[@type='btn']")
	   WebElement proceedToPayment;
	   
	public AddpaymentDetailPage(WebDriver driver) {
		 this.driver=driver;
	}
	
	
	public void addpaymentDetail( String fname ,String lname, String num , String email ,String address) {
		
	JavaBase.sendKeys("enterYourName",enterYourName,fname,2);
		JavaBase.sendKeys("enterYourLastName",enterYourLastName,lname,2);
		JavaBase.sendKeys("contactNum",contactNum,num,1);
		JavaBase.sendKeys("enterYouremail",enterYouremail,email,2);
		JavaBase.sendKeys("EnterYourAddress",EnterYourAddress,address,1);	
	}
	
public void clickon_ProceedPaymentBtn() {
	JavaBase.clickOn("proceedToPayment",proceedToPayment,2);  // "proceedToPayment" this just for print in report
		
	}																										// withoutcot -this webElement
                                                                  											// base kay click on methos main bhee parameter hogay
	
																											// yaha se teen argument bhaj rahay hain , jaba kay method main
  																											// bhee teen parameter hogay , jo en teen value ko catch karay gay 
}
