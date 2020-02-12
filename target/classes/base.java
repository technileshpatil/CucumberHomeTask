///////////////////////////////////////////////////////////////////////////////
// Method:			 Initialize Driver                  
// Developer:        Nilesh Patil
// Email:            Nilesh.patil@nordea.com
// Code Reviewer:    Janne and Timo
// Date:      		 2020-02-12
//
//////////////////// THIS LIBRARY CONTAIN ALL DRIVERS WITH PROPERTIES DEFINED ////////////////////


package resources;

//import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	 public WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
//Calling External data properties file to avoid hard code- I have used both solutions here to give some examples- Data sources can be Excel,XML,JSON,PLAIN TEXT or Any
 prop= new Properties();																						//Request you to change this path as a local path
FileInputStream fis=new FileInputStream("C:\\AmazonProductSearch\\src\\test\\java\\resources\\data.properties");// This path also can be parameterized in Data.proprties

prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{																											//Request you to change this path as a local path
	 System.setProperty("webdriver.chrome.driver", "C:\\AmazonProductSearch\\driverfiles\\chromedriver.exe");// This path also can be parameterized in Data.proprties
	driver= new ChromeDriver();
	//Execute in chrome driver	
	
	//Add options to Google Chrome-To run Headless. The window-size is important for responsive sites
    //Remove comment if you want to test also import
		/*ChromeOptions options = new ChromeOptions();
	    options.addArguments("headless");
	    options.addArguments("window-size=1200x600");*/
	
}
else if (browserName.equals("firefox"))
{
	 driver= new FirefoxDriver();
	 
	 //We can add Firefox Driver property here to execute in Firefox
}
else if (browserName.equals("IE"))
{
	//We can add IE Driver property here to execute in Firefox
}
else if (browserName.equals("IE"))
{
	//We can add IE Driver property here to execute in Firefox
}

// implicitlyWait wait is added to have 10 second gap to execute test suite or test case if there are 100 to 1000 TCs.- Example if there are some feature of screenshot and we bind with Reports which may take time.
//For safer side this can be added. Its not mandatory. Depend on Project framework.
//I have added this to provide some information.This Test will run without it as well
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}
}
