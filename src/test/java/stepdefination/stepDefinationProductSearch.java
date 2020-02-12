
///////////////////////////////////////////////////////////////////////////////
// Class:			 stepDefinationProductSearch                  
// Developer:        Nilesh Patil
// Email:            Nilesh.patil@nordea.com
// Code Reviewer:    Janne and Timo
// Date:      		 2020-02-12
//
//////////////////// THIS LIBRARY CONTAIN ALL THE STEP DEFINATION MAPPED WITH FEATURES ////////////////////

package stepdefination;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.junit.Assert;
//import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.ProductPage;
import resources.base;

public class stepDefinationProductSearch extends base{

	public static Logger log=LogManager.getLogger(base.class.getName());



	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver =initializeDriver();
		log.info("Driver is initialized");
		driver.manage().window().maximize();
	}

	@Given("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_Site(String arg1) throws Throwable {
		//Url is taken from feature file directly and we are not hard coded here. This also can be taken from any different sources- exel,csv,xml,config.ini,config.properties anything
		driver.get(arg1);
		log.info("Open" +arg1+"Successfully");
	}

	@Then("^I should see Search box$")
	public void i_should_see_Search_box() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LandingPage lp=new LandingPage(driver);
		lp.inputProductData().isDisplayed();
		log.info("Amazon Home Page Search box is visible and enabled");
	}

	@When("^I fill in search input as Nikon and press Search button$")
	public void i_fill_in_search_input_as_Nikon_and_press_Search_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LandingPage lp=new LandingPage(driver);	
		lp.inputProductData().sendKeys("Nikon");
		log.info("Entered data'Nikon' Sucessfully");
		lp.clickSearchButton().click();
		log.info("Click search button Sucessfully");
	}

	@When("^I get List of Nikon Products$")
	public void i_get_List_of_Nikon_Products() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ProductPage pp=new ProductPage(driver);		
		pp.clickOn2ndProduct().isDisplayed();
		log.info("Data enter by user is visible on product page Sucessfully");
	}

	@When("^I Select Option 'Price: High to Low'$")
	public void i_Select_Option_Price_High_to_Low() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ProductPage pp=new ProductPage(driver);
		pp.clickDropDownMenu().click();
		pp.selectDropDownItem().click();
		log.info("Select filter by option 'High to Low' is Sucessfully");
	}

	@When("^I Select Second Product in List$")
	public void i_Select_Second_Product_in_List() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ProductPage pp=new ProductPage(driver);		
		pp.clickOn2ndProduct().click();
		log.info("Clicked on 2nd Product as given on Product page Sucessfully");
	}

	@Then("^I can see Product Title Containing 'Nikon D(\\d+)X'$")
	public void i_can_see_Product_Title_Containing_Nikon_D_X(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ProductPage pp=new ProductPage(driver);
		String actualTitle= pp.captureProductTitle().getText();
		log.info("Captured the actual product"+actualTitle);
		String expectedTitle = "Nikon D3X";   
		SoftAssert sa = new SoftAssert(); // This Soft Assert is used because not to skip next step defination.
		sa.assertEquals(actualTitle,expectedTitle,"Searched Product title not matching"); 	
		//Assert.assertEquals(actualTitle,expectedTitle,"Searched Product title not matching"); //Use this when you want to skip test once current step defination got fail	
		log.info("Data as expected is not verified as same product is not availble");   
	}

	@Then("^close browsers$")
	public void close_browsers() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.close();
		driver.quit();
		log.info("Browser Closed");
	}
}



