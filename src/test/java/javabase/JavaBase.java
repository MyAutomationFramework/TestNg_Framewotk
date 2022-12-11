package javabase;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.Mahakaal.extentReport.Extent;
import com.Mahakaal.extentReport.ExtentManager;
import com.Mahakaal.utility.PropertyReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
 

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaBase  {
public	String browsersave;
public  static WebDriver driver;
public static Logger 	log;

public static JavascriptExecutor   js;
public static SoftAssert soft;



@BeforeSuite
	public void browserSetUp() {
	
   browsersave=	 PropertyReader.getConfigProperty("BROWSER");
	switch(browsersave) {
	
	case" chrome":
	{
		WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
	}
	break;
	
	case"safari":	
	{
		WebDriverManager.safaridriver().setup();
		  driver=new SafariDriver();
		
	}
	break;
	
	case"edge":
	{
		WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
	}
	break;
	
	default:
	
		WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  break;
	}
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	 driver.manage().deleteAllCookies();
	 
		log = LogManager.getLogger("BhasamArtiBookingTestcases.class");	
		log.info("*********************************************************************************************************************");
		log.info("Bhasam Arti Excution Started");
		log.info(" Browser launched");
	}

public static void openUrl(String url) {
	
	driver.get(PropertyReader.getConfigProperty("url"));
	 //Extent.getTest().log(Status.INFO,"Url Opened --> " +url);
	//Extent.getTest().log(Status.PASS,"Click On --> " +element.getText());
	 log.info("url opend");
	
}



@BeforeMethod
public  void setUpReport(Method method)
{

		ExtentReports reports=ExtentManager.getExtentReportsInstance();
		ExtentTest extentTest=reports.createTest(method.getName());	
	    Extent.setTest(extentTest);
}

public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
             //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/reports/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

@AfterMethod
protected void afterMethod(ITestResult result,Method method)
{
	
	
	if(result.getStatus()==ITestResult.FAILURE)
	{
		try {
			 
			 
			String screenshotPath = JavaBase.getScreenhot(driver, result.getName());
			//To add it in the extent report 
			

	        Extent.getTest().log(Status.FAIL,"Test Case Failed is "+result.getName());
	        Extent.getTest().fail("Captured Screenshot is below:"+Extent.getTest().addScreenCaptureFromPath(screenshotPath));
	            		 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	 
	}
	
	else if(result.getStatus()==ITestResult.SKIP)
	{
		Extent.getTest().log(Status.SKIP,"Test Skipped "+result.getThrowable());
		Extent.getTest().log(Status.SKIP, "Test Case Skipped is "+result.getName());
		
	}
	else
	{
		Extent.getTest().log(Status.PASS, result.getName()+  " ->Test Case Passed ");		
	}
  }


@AfterSuite
public  void setUpFlushed()
{
		ExtentManager.getExtentReportsInstance().flush();
	
}
	
 
								//// Scroll method-1 by postion 
public  static void scrollBardown(int position) 
{
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    js  = (JavascriptExecutor)driver;		
   
    js.executeScript("window.scrollBy(0,'"+position+"')");
    Extent.getTest().log(Status.INFO, "Page Scrolled ->"  +position);	
 
}
//// Scroll method-2 by visible element 
public static void scrollByWebElement(WebElement element) {
	
	 try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Actions act=new Actions(driver);
			  act.moveToElement(element);
			   act.perform();
		
}



  
   public void softAssert() {
	   soft=new SoftAssert();
   }
   

// send keys 
     public static void sendKeys(String elementName, WebElement element, String testData,int timeout) 
 	{
    	 WebElement element2=null;
 		try
 		{
 		 element2=WaitForVisibilityOf(element,timeout);
 		element2.sendKeys(testData);
 		Extent.getTest().log(Status.PASS,"Enter Value in -- "+elementName+"  "+element2.getText()+ "Test Data is :   " +testData+"    Step Passed");
 		 
 		}
 		catch (Exception e) {
 		e.printStackTrace();
        Extent.getTest().log(Status.FAIL,"Enter Value in--"+elementName+"  "+element2.getText()+"Test Data is :  "+testData+ "   Step Passed");
 		}
 		}
     
     // dependeing method -sendy method call
     public static WebElement WaitForVisibilityOf(WebElement element1, int timeout) 
 	{
 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
 		WebElement element = wait.until(ExpectedConditions.visibilityOf(element1));
 		return element;
 	}
     
    
     
     // clickon
     public static void clickOn( String elementName,WebElement element,int timeout) { // first paramaert for webelement for print , we sent value in string so , here alos gave String data ty 	{
    	 WebElement element1=null;
 		try																																		// second is webelement for clcik , thied is for time out.
 		{
 		 element1=WaitForElementClickable(element,timeout);
 		 element1.click();
      
 		  Extent.getTest().log(Status.PASS, " Click On  --"+elementName+"  "+element1.getText()+"  -->Step Passed"); // get text method will pick actaul UI text
 		}
 		catch (Exception e) 
 		{
 		e.printStackTrace();
        Extent.getTest().log(Status.FAIL," Click On --"+elementName+"  "+element1.getText()+"  --->Step Failed ");
 		
 	}
 	}
     
     
     // relavent click
     public static WebElement WaitForElementClickable(WebElement element1 , int timeout) 
 	{
 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
 		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(element1));
 		
 		return element;
 	}
     
   
     
//     public void captureScreenShot(WebDriver driver ,String testName) throws IOException {
//    	      // step-1 convert weddriver object to take screenshot interface
//    	                TakesScreenshot      screenshot     =  ( (TakesScreenshot) driver);           
//    	                // step2 call getScreenshots method to create image file
//    	                 File src   = screenshot.getScreenshotAs(OutputType.FILE);
//    	                 // destination 
//    	                  File destination  =   new File( System.getProperty("user.dir"+"//Screenshots//"+testName+".png"));               
//    	                // step copy image file to destination
//    	                   FileUtils.copyFile(src, destination);
//    	  
//     }
     
     public static void clickBy_javaExcutu(WebElement element ,int timeout) {
    	 
    WebElement	 element1=WaitForElementClickable(element,timeout);                   
    	 JavascriptExecutor executor = (JavascriptExecutor)driver;
    	 
    	 
    	 executor.executeScript("arguments[0].click();", element1);
    	 
     }
     
   
      
      // visibility
     
     
     
     
     
  
     public void tearDown() {
   	  driver.close();
   	  log.debug("Browser got closed and  Test Excution completed");
   	  
    } 
		
     
     
     
}
