package com.cyient.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;
import com.cyient.page.DashboardPage;
import com.cyient.page.LoginPage;
import com.cyient.utilities.DataProviderUtils;

public class LoginTest extends WebDriverWrapper {
	

	
	@Test(dataProvider = "invalidData",dataProviderClass = DataProviderUtils.class )
    public void invalidCredentialTest(String username,String password,String languageText,String expectedValue)
    {	
	
		
		
		 LoginPage login = new LoginPage(driver);
		 login.sendUsername(username);
		 login.sendPass(password);
		 login.selectLanguageByText(languageText);
         login.clickOnLogin();
		
		/*LoginPage login = new LoginPage(driver);
		 login.sendUsername("admin");
		 login.sendPass("pass");
		 login.selectLanguageByText("English (Indian)");
        login.clickOnLogin();
		*/
         
         DashboardPage dashboard = new DashboardPage(driver);
         String actualValue1 =  login.getErrorMessage();
        Assert.assertEquals(actualValue1, expectedValue);
         
       //  Assert.assertEquals(dashboard.getDashboardTitle(),"Open EMR");
         
        /* DashboardPage dashboard = new DashboardPage(driver);
         String actualValue1 = dashboard.getDashboardTitle();
         Assert.assertEquals(actualValue1,"OpenEMR");*/
         
    }
        
         /*  Select selectlanguage= new Select(driver.findElement(By.name("languageChoice")));
            selectlanguage.selectByVisibleText("English (Indian)");
            driver.findElement(By.xpath("//button[@class='btn btn-login btn-lg']")).click();  
            
            String actualValue = driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText();
            Assert.assertEquals(actualValue, "Invalid username or password");
           
    }*/
	
	
	
	@Test(dataProvider = "validCredentialExcelData",dataProviderClass = DataProviderUtils.class )
	
	public void validCredentialTest(String username,String password,String languageText,String expectedValue)
	{
		
       
           /*Select selectlanguage= new Select(driver.findElement(By.name("languageChoice")));
           selectlanguage.selectByVisibleText("English (Indian)");
           driver.findElement(By.xpath("//button[@class='btn btn-login btn-lg']")).click();  */
           
          /* String actualTitle = driver.getTitle();
           Assert.assertEquals(actualTitle,"OpenEMR");*/
          
		
		 LoginPage login = new LoginPage(driver);
		 login.sendUsername(username);
		 login.sendPass(password);
		 login.selectLanguageByText(languageText);
         login.clickOnLogin();
        
		/*LoginPage login = new LoginPage(driver);
		 login.sendUsername("admin11");
		 login.sendPass("pass1");
		 login.selectLanguageByText("English (Indian)");
       login.clickOnLogin();*/
         
        DashboardPage dashboard = new DashboardPage(driver);
         String actualValue1 = dashboard.getDashboardTitle();
         Assert.assertEquals(actualValue1, expectedValue);		
        //Assert.assertEquals(login.getErrorMessage(), "Invalid username or password");
		
	}

	/*
@Test
public void validUrlTest() {
	
	/* System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  
	  driver.get("https://demo.openemr.io/openemr/interface/login/login.php?site=default");
	  
	  String actualDescription = driver.findElement(By.xpath("//p[contains(text(),'most')]")).getText();
	  Assert.assertEquals(actualDescription, "The most popular open-source Electronic Health Record and Medical Practice Management solution.");
	  
	 
	  String actualAckText = driver.findElement(By.partialLinkText("Acknowledgments")).getText();
	  Assert.assertEquals(actualAckText, "Acknowledgments, Licensing and Certification");
	  
	  String actualUsernamePlaceholderValue = driver.findElement(By.id("authUser")).getAttribute("placeholder");
	  Assert.assertEquals(actualUsernamePlaceholderValue , "Username");
	  
	  String actualPassPlaceholder = driver.findElement(By.id("clearPass")).getAttribute("placeholder");
	  Assert.assertEquals(actualPassPlaceholder, "Password:");
	  
}*/
}