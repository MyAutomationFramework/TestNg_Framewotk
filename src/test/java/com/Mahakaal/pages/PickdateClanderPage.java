package com.Mahakaal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javabase.JavaBase;

public class PickdateClanderPage {
	
	public WebDriver driver;
	
   @FindBy(xpath="//span[text()='18']")
public	WebElement pickdate;
   
   @FindBy(xpath="//a[text()='Privacy Policy']")
  public  WebElement privacyPolicy;
 
// scrool by element
   @FindBy(xpath="//span[text()='28']")
   public	WebElement pickdate1;
   
//	  @FindBy(xpath="//div[text()=' Next ']")
//	  WebElement NextBtn;
	
//	 @FindBy(xpath="/html/body/app-root/app-bhasmarti/app-registration-form/div/div/div[4]/div/div/mwl-calendar-month-view/div/div/div[1]/div/mwl-calendar-month-cell[5]/div/div[1]/span") 
//	   WebElement date2;

	public PickdateClanderPage(WebDriver driver){
	     this.driver=driver;
}
	
	
	public void click_ArtiDate()  {
		  JavaBase.clickOn("pickdate",pickdate,10);
	}
	

//	public void click_nextButton() {
//	    JavaBase.clickOn(NextBtn);
//}
	
//	public void click_July2nd() {
//		date2.click();
//		//JavaBase.clickOn(date2);
//	}
}