package com.Mahakaal.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javabase.JavaBase;

public class TextFieldPage {
	public WebDriver driver;
	
	@FindBy(name="first_name")
	WebElement FirstName;
	
  @FindBy(name="last_name")
	WebElement LastName;
  
  @FindBy(xpath="//input[@name='mobile_no']")
	WebElement contactNumber;
  
  @FindBy(name="state_id")
	WebElement selectState;
  
  @FindBy(xpath="//select[@name='city_id']")
	WebElement selectCity;
  
  @FindBy(xpath="//span[@class='date-ico']")
	WebElement DateOfVisit;
  
  @FindBy(name="no_of_persons")
	WebElement NoPersonDropdown;
  
  @FindBy(name="gender")
  WebElement Gender;
  
  @FindBy(name="id_proof_type_id")
  WebElement idProffTypeID;
  
  @FindBy(name="id_proof_number")
  WebElement idProofNumber;
 
  @FindBy(xpath="//button[text()='Upload A Photo']")
  WebElement uploadPhoto;
  
  @FindBy(xpath="//button[text()='Upload An ID Proof']")
  WebElement  uploadIdproof;
  
  @FindBy(xpath="//button[@type='btn']")
  WebElement submitNowButton;
  
//construtor
	public TextFieldPage(WebDriver driver){
	     this.driver=driver;
}

	public void enter_firstName(String fName)  {
		
	
		JavaBase.sendKeys("FirstName",FirstName, fName,3); //" First Name  this just fot report --padd fail log"
	}
	
	public void enter_LastName(String lName) {
		JavaBase.sendKeys("LastName",LastName, lName,1);
	}
		
	public void  enter_ContactNumber(String number) {
		JavaBase.sendKeys("contactNumbe",contactNumber, number,2);
	}
	
	public void state(String state) {
		JavaBase.sendKeys("selectState",selectState, state,3);
	}
	
	public void city(String city) {
		
		JavaBase.sendKeys("selectCity",selectCity, city,5);
	}
	
	
	public void gender(String gender) {
		JavaBase.sendKeys("Gender", Gender, gender,2);
	}
	
	public void  numberperson(String numberperson) {
		JavaBase.sendKeys( "NoPersonDropdown",NoPersonDropdown,numberperson ,1);
	}
	
	
	 public void id_proofType(String prooftype) {
	    	JavaBase.sendKeys("idProffTypeID",idProffTypeID, prooftype,2);
	    }
		
	   public void id_proofnumber(String profnum) {
		   JavaBase.sendKeys("idProofNumber", idProofNumber, profnum,1);
	    }
		
	   
	   public void upload_pic() {
			Actions actobj =  new Actions(driver);
			  actobj.moveToElement(uploadPhoto).click().perform();
			  try {
				Runtime.getRuntime().exec("C:\\Users\\Brain\\OneDrive - Brain Above InfoSol Pvt. Ltd\\Desktop\\g1.exe");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
			public void upload_id() {
				Actions actobj =  new Actions(driver);
				actobj.moveToElement(uploadIdproof).click().perform();
				try {
					Runtime.getRuntime().exec("C:\\Users\\Brain\\OneDrive - Brain Above InfoSol Pvt. Ltd\\Desktop\\g2.exe");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
		}
	
			public void clickOnSubmit() {		
				JavaBase.clickOn(	"submitNowButton",submitNowButton,2);		      
			}
	

}
//class

//public void Textfields( String fName,  String lName ,String Num ,String state, String city, String gender) {
//JavaBase.sendKeys (FirstName, fName);
//	JavaBase .sendKeys(LastName,lName);																			
//		JavaBase.sendKeys(  contactNumber,Num);																																									
//   JavaBase.sendKeys(selectCity,city);      																																															;
//JavaBase.sendKeys(Gender,gender);
//
//}
