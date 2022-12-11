package com.Mahakaal.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentManager 
{
	
static public  ExtentSparkReporter  htmlReporter;
static public  ExtentReports reports;
static public	 ExtentTest test;


private ExtentManager()
{
	
}
		 
public synchronized static ExtentReports getExtentReportsInstance()
{
if(reports==null)
{
htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\mahakaal.html");   
htmlReporter.config().setReportName("Mahakaal"); // yeh 17 line main store hoga
htmlReporter.config().setDocumentTitle("Mahakal Bhasam Arti booking Test Report "); 
htmlReporter.config().setTheme(Theme.DARK);
reports=new ExtentReports(); 
reports.setSystemInfo("Operating System", "Windows 11");
reports.setSystemInfo("Tested By", "Deeksha Prajapati");
reports.setSystemInfo("Browser:","chrome");
reports.attachReporter(htmlReporter);
return reports;

}
else
{
return reports;	
}
}
	
	

}
