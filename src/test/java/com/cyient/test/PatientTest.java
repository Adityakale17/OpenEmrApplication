package com.cyient.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;
import com.cyient.page.DashboardPage;
import com.cyient.page.LoginPage;

@Test
public class PatientTest extends WebDriverWrapper {

	public void addPatientTest() throws InterruptedException {
		
		
		
		 LoginPage login = new LoginPage(driver);
		 login.sendUsername("admin");
		 login.sendPass("pass");
		 //login.selectLanguageByText("English");
         login.clickOnLogin();
		
         DashboardPage dashboard = new DashboardPage(driver);
         dashboard.mousehoverOnPatient();
         dashboard.clicOnPatient();
		
		
		
		
		
		
		
		
	/*	System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.openemr.io/openemr/interface/login/login.php?site=default");*/

		/*driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");

		Select selectlanguage = new Select(driver.findElement(By.name("languageChoice")));
		selectlanguage.selectByVisibleText("English (Indian)");*/
		// driver.findElement(By.xpath("//button[@class='btn btn-login
		// btn-lg']")).click();
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
/*
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[text()='Patient/Client']"))).perform();

		driver.findElement(By.xpath("//div[@class='menuLabel'][normalize-space()='Patients']")).click();
*/	
         
		//driver.switchTo().frame("fin");
		//driver.findElement(By.xpath("//button[normalize-space()='Add New Patient']")).click();
		//driver.switchTo().defaultContent();

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pat']")));
		driver.findElement(By.id("form_fname")).sendKeys("PPPPPPP");
		driver.findElement(By.id("form_mname")).sendKeys("SSSSSS");
		driver.findElement(By.id("form_lname")).sendKeys("CCCCCC");
		driver.findElement(By.id("form_DOB")).sendKeys("1996-06-11");

		Select selectgen = new Select(driver.findElement(By.id("form_sex")));
		selectgen.selectByVisibleText("Male");
		driver.findElement(By.id("create")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='modalframe']")));
		driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
		
		String actualvalue= driver.findElement(By.xpath("//iframe[@name='pat']")).getText();
        Assert.assertEquals(actualvalue, "Medical Record Dashboard - PPPPPPP CCCCCC   ");
		
		
		
		
	}

}
