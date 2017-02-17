package com.test.com.test.automation;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo
{
	
	public WebDriver driver = new FirefoxDriver();
	public String baseURL = "https://onetrust.com/";
	
	@BeforeTest
	public void LaunchBrowser()
	{
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	@Test
	public void form() throws Exception  
	{
		driver.findElement(By.linkText("Contact")).click();
		driver.findElement(By.id("input-1")).sendKeys("FirstName");
		driver.findElement(By.id("input-2")).sendKeys("LastName");
		driver.findElement(By.id("input-3")).sendKeys("Email");
		driver.findElement(By.id("input-5")).sendKeys("OnetrustAutomation");
		driver.findElement(By.id("input-4")).sendKeys("+919876543210");
		driver.findElement(By.id("00N3600000LNxBv")).sendKeys("Testing");
		
		getscreenshot();
		
		Thread.sleep(5000);
	}
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	    
	public void getscreenshot() throws Exception 
    {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         
            FileUtils.copyFile(scrFile, new File("E:\\screenshot.png"));
            
           
    }
}
