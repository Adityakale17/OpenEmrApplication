package com.cyient.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoTest {
	
	@DataProvider
	public Object[][] validData(){ 
	Object[][] main = new Object[3][2];
	
	main[0][0]="aditya";
	main[0][1]="aditya123";
	
	main[1][0]="ppppp";
	main[1][1]="pppp11";
	
	main[2][0]="peter";
	main[2][1]="peter123";
			
   return main;
	
	}
	@Test(dataProvider = "validData")
	public void validTest(String username,String password)
	{
		System.out.println("Test Run" + username + password);
	}
}