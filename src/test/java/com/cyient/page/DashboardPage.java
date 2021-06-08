package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage {
private By patientClientLocator = By.xpath("//div[text()='Patient/Client'");
private By patientLocator = By.xpath("//div[@text()='Patients']");
private WebDriver driver;
	
	public  DashboardPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getDashboardTitle() {
		return driver.getTitle().trim();
	}
	
	public void mousehoverOnPatient()
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(patientClientLocator)).perform();
		
	}
	
	public void clicOnPatient()
	{
		driver.findElement(patientLocator ).click();
	}
}
