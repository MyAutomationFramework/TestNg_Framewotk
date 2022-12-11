package com.Mahakaal.NewTestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Mahakaal.pages.DonationPage;
import com.Mahakaal.pages.HomePage;
import com.Mahakaal.pages.TextFieldPage;
import com.Mahakaal.utility.PropertyReader;

import javabase.JavaBase;

public class Donation extends JavaBase {
	
	public DonationPage	 donation ;
	public TextFieldPage       textFields;

	@Test
	public void verify_MoneyDonation() throws InterruptedException  {
		 HomePage  obj  = PageFactory.initElements(driver, HomePage.class);
		 donation  =PageFactory.initElements(driver,DonationPage.class);
		 textFields =   PageFactory.initElements(driver,TextFieldPage.class);
		 
		 driver.get(PropertyReader.getConfigProperty("url"));
	      obj.click_donationLink();	
	  		donation.click_donateMoneyLink();
	  	
	  		scrollBardown(500);
	  		textFields.enter_firstName(PropertyReader.getDataProperty("First_Name"));
	    textFields.enter_LastName(PropertyReader.getDataProperty("Last_Name"));
	    
	    donation.enter_FatherName(PropertyReader.getDataProperty("Fath_Name"));
	       donation.enter_MobileNumber(PropertyReader.getDataProperty("MobileNumber"));
	       donation.enter_email(PropertyReader.getDataProperty("Email"));
	       donation.enter_address(PropertyReader.getDataProperty("Address"));
	       donation.enter_country(PropertyReader.getDataProperty("Country"));
	      
	       textFields.state(PropertyReader.getDataProperty("State"));
		   textFields.city(PropertyReader.getDataProperty("City"));
		   
		 
	     donation.enter_zipCode(PropertyReader.getDataProperty("ZipCode"));
	     donation.enter_DonationPurpose(PropertyReader.getDataProperty("DoPurpose"));
	     donation.enter_DonationAmount(PropertyReader.getDataProperty("DoAmount"));
	     donation.id_proofType(PropertyReader.getDataProperty("IDProofType"));
	     donation.id_proofnumber(PropertyReader.getDataProperty("IDProofNumber"));
	     donation.enter_PanCardNumber(PropertyReader.getDataProperty("PANCardNumber"));
	     try {
			donation.upload_id();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     Thread.sleep(4000);
	     try {
			donation.upload_pic();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     scrollBardown(300);
	     
	    
	     donation.Click_submitNowButton();
	    
	}

}
