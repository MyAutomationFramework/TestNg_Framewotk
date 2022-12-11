package com.Mahakaal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javabase.JavaBase;

public class HomePage {
	
	 public WebDriver driver;
	
	@FindBy(xpath="//a[text()='Bhasm Aarti Booking']")
	WebElement BhasmArtiBookinglink;
	
	@FindBy(linkText="About")
	WebElement AboutLink;
	
	@FindBy(partialLinkText="home")
	WebElement Home;
	
	@FindBy(linkText="Information")
	WebElement Information;
	
	@FindBy(linkText="Donation")
	WebElement Donation;
	
	
	// construtor
	public HomePage(WebDriver driver){
	     this.driver=driver;
 }
	
	
	// method
	public void clickOnBhasamArti_Link()
	{
		 JavaBase.clickOn( "BhasmArtiBookinglink",BhasmArtiBookinglink,2);
		 
		 
	}
	
	
    public void click_AboutLink() {
    	
}
    
  public void click_InformationLink() {
    	JavaBase.clickOn("Information",Information,5);
    }
  
  public void click_HomeLink() {
  	JavaBase.clickOn("Home",Home,5);
  }
  
  
  public void click_donationLink() {
	  JavaBase.clickOn("Donation",Donation,10);
  }
    
  
  
  
}
