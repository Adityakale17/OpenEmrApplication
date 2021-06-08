package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginPage {
	private By usrenameLocator = By.id("authUser");
	private By  passwordLocator=By.id("clearPass");
	private By lanaguageLocator = By.name("languageChoice");
	private By clickOnLoginLocator = By.xpath("//button[@class='btn btn-login btn-lg']");
	private By MessageLocator = By.xpath("//div[contains(text(),'Invalid')]");
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
  public void sendUsername(String username)
  {
	  driver.findElement(usrenameLocator).sendKeys(username);
  }
  
  public void sendPass(String password)
  {
	  driver.findElement(passwordLocator).sendKeys(password);
  }
  
  public void selectLanguageByText(String languageText){

      Select selectlanguage= new Select(driver.findElement(lanaguageLocator));
      selectlanguage.selectByVisibleText(languageText);
  }
      public void clickOnLogin () {
    	  driver.findElement(clickOnLoginLocator).click(); 
      }

          
		public String getErrorMessage() {
			String statement = driver.findElement(MessageLocator).getText();
	          return statement;
		
		}

		
 
}
