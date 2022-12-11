package com.Mahakaal.NewTestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Mahakaal.extentReport.Extent;
import com.Mahakaal.extentReport.ExtentManager;
import com.Mahakaal.pages.AddpaymentDetailPage;
import com.Mahakaal.pages.HomePage;
import com.Mahakaal.pages.PaymentDetailButtonPage;
import com.Mahakaal.pages.PickdateClanderPage;
import com.Mahakaal.pages.TextFieldPage;
import com.Mahakaal.utility.PropertyReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import javabase.JavaBase;

public class BhasamArtiBooking  extends JavaBase{
	public TextFieldPage	textfield;
	public	PaymentDetailButtonPage 	paymentdetail;
	public AddpaymentDetailPage	addpaymentdetail;
	public PickdateClanderPage	date;
	
	@Test
	public void Check_BhasamArtiBooking() 
	{
		   // objects 
		HomePage	home = PageFactory.initElements(driver,HomePage.class);
		PickdateClanderPage	date=PageFactory.initElements(driver,PickdateClanderPage.class);
		textfield=PageFactory.initElements(driver,TextFieldPage.class);
		paymentdetail=PageFactory.initElements(driver,PaymentDetailButtonPage.class);
		
		Extent.getTest().log(Status.INFO,"Test Excution Started ");
		Extent.getTest().log(Status.INFO,"Browser Launched --> "+browsersave);
				driver.get(PropertyReader.getConfigProperty("url"));
				String url = driver.getCurrentUrl();
		         Extent.getTest().log(Status.PASS,"Url Opened --> "+url+"Step Passed");
		         
					home.clickOnBhasamArti_Link();
		
				//scrollByWebElement(date.pickdate);
					scrollBardown(600);
						date.click_ArtiDate();
							
							scrollBardown(500);
		
			  
			textfield.enter_firstName(PropertyReader.getDataProperty("First_Name"));
		
	      //textfield.enter_LastName(PropertyReader.getDataProperty("Last_Name"));
   
//	textfield.enter_ContactNumber(PropertyReader.getDataProperty("Contact_Number"));
					//textfield.state(PropertyReader.getDataProperty("State"));
		
			//textfield.city(PropertyReader.getDataProperty("City"));
			//textfield.gender( PropertyReader.getDataProperty("Gender"));
//	
//				textfield.id_proofType(PropertyReader.getDataProperty("ID_Proof_Type"));	
//				textfield.id_proofnumber(PropertyReader.getDataProperty("ID_Proof_Number"));
////		// uplaod pic
//				textfield.upload_pic();
//			textfield.upload_id();
////					
				//JavaBase.scrollBardown(200);
//					textfield.clickOnSubmit();
//					
//					 		addpaymentdetail.addpaymentDetail(PropertyReader.getDataProperty("First_Name"),
//							 PropertyReader.getDataProperty("Last_Name"),
//							 PropertyReader.getDataProperty("Contact_Number"), 
//							 PropertyReader.getDataProperty("email"),
//							 PropertyReader.getDataProperty("address"));
//						
//					 		addpaymentdetail.clickon_ProceedPaymentBtn();	
		
	}
	

}
