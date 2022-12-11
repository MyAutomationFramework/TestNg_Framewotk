package com.Mahakaal.utility;

import org.testng.annotations.Test;

public class TestDemo {

	 @Test
	     public void test() {
		 // config ---url
		    String saveUrl  =PropertyReader.getConfigProperty("url");
		       System.out.println(saveUrl);
		       
		           String      saveFirstName         = PropertyReader.getDataProperty("First_Name");
		           System.out.println(saveFirstName);
	    	 
	     }
	
		

	}


