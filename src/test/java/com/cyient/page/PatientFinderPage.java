package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientFinderPage {
	private String finFramename="fin";
	private By addnewPatientLocator = By.id("create_patient_btn1");

private WebDriver driver;
	
	public  PatientFinderPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void switchToFinFrame()
	{
		driver.switchTo().frame(finFramename);
	}
	
	public void clickOnAddNewPatient()
	{
		driver.findElement(addnewPatientLocator).click();
	}
}
