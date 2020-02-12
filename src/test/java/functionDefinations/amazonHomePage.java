///////////////////////////////////////////////////////////////////////////////
// Method:			 basePageNavigation(String searchProduct)                       
// Developer:        Nilesh Patil
// Email:            Nilesh.patil@nordea.com
// Code Reviewer:    Janne and Timo
// Date:      		 2020-02-11
//
//////////////////// THIS LIBRARY IS USED TO EXECUTE TEST WITHOUT CUCUMBER FRAMEWORK ////////////////////

package functionDefinations;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.ProductPage;
import resources.base;

public class amazonHomePage extends base{

	@BeforeTest
	public void initialize() throws IOException
	{

		driver =initializeDriver();

	}

	@Test
	public void basePageNavigation(String searchProduct) throws IOException
	{

		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		//String keyword=	prop.getProperty("SearchKeyword");		
		//lp.inputProductData().sendKeys(keyword); AS THIS IS SMALL TEST,SO I HAVE USED BOTH SCENARIOS TO CALL VALUE FROM DATA PROPERTIES FILE WHICH IS STORES EXTERNALLY IN FRAMEWORK
		LandingPage lp=new LandingPage(driver);
		lp.inputProductData().sendKeys("Nixon");
		lp.clickSearchButton().click();

		ProductPage pp=new ProductPage(driver);
		pp.clickDropDownMenu().click();
		pp.selectDropDownItem().click();
		pp.clickOn2ndProduct().click();

		String actualTitle= pp.captureProductTitle().getText();
		String expectedTitle = "Nikon D3X";      
		Assert.assertEquals(actualTitle,expectedTitle,"Product title not matching"); 


	}

	@AfterTest
	public void teardown()
	{

		driver.close();
		driver.quit();
		driver=null;

	}


}
