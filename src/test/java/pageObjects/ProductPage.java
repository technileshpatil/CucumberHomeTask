///////////////////////////////////////////////////////////////////////////////
// Method:			 Product Page                    
// Developer:        Nilesh Patil
// Email:            Nilesh.patil@nordea.com
// Code Reviewer:    Janne and Timo
// Date:      		 2020-02-12
//
//////////////////// THIS LIBRARY CONTAIN ALL OBJECTS RELATED TO PRODUCT PAGE ////////////////////

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	
	public WebDriver driver;
	
	//easy to change Object here if change in future
	By sortDropDown=By.id("a-autoid-0");
	By selectionOption=By.id("s-result-sort-select_2");
	By select2ndProduct=By.xpath("//span[@class='celwidget slot=SEARCH_RESULTS template=SEARCH_RESULTS widgetId=search-results index=2']//img[@class='s-image']");
	By getProductTitle=By.xpath("//*[@id=\"productTitle\"]");
	
	
	public ProductPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement clickDropDownMenu() {
		return driver.findElement(sortDropDown);
		
	}
	
	public WebElement selectDropDownItem() {
		return driver.findElement(selectionOption);
		
	}
	
	public WebElement clickOn2ndProduct() {
		return driver.findElement(select2ndProduct);
		
	}
	
	public WebElement captureProductTitle() {
		return driver.findElement(getProductTitle);
		
		
	}
	

}
