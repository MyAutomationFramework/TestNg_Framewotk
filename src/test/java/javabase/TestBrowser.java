package javabase;
// browser code flow  1)  env main stg---->property reader main stg-config.properties-->
// return method bhee stg main browesr kee value
// ki returnkarayga ----> browserFctory package main Browserjava class main call hua hain propertyreader 
// switchcase main chrome aya aur chrome insteance bana 
// ab yaha hum extends kur rhay hain 
// testng run kur rhaha hain 
	import org.testng.annotations.Test;

			
			public class TestBrowser extends JavaBase{
				@Test
				   public void google() {
					driver.get("https://www.google.com/");  
				   }
   
			}
