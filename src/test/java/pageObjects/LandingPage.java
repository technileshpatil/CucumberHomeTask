///////////////////////////////////////////////////////////////////////////////
// Method:			 Landing Page                     
// Developer:        Nilesh Patil
// Email:            Nilesh.patil@nordea.com
// Code Reviewer:    Janne and Timo
// Date:      		 2020-02-12
//
//////////////////// THIS LIBRARY CONTAIN ALL OBJECT THE RELATED TO LANDING PAGE ////////////////////




package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	//easy to change Object here if change in future
	By searchItem=By.id("twotabsearchtextbox");
	By searchButton=By.className("nav-input");
	
	public LandingPage(WebDriver driver) {
				
		this.driver=driver;
		
	}
	
	
	
	public WebElement inputProductData() {
		
		return driver.findElement(searchItem);
		
	}
	
	public WebElement clickSearchButton() {
		
		return driver.findElement(searchButton);
		
	}
	
	
	

}
