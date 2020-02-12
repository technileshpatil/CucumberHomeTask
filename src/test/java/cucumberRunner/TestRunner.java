
///////////////////////////////////////////////////////////////////////////////
// Method:			 Test Runner                       
// Developer:        Nilesh Patil
// Email:            Nilesh.patil@nordea.com
// Code Reviewer:    Janne and Timo
// Date:      		 2020-02-11
//
//////////////////// TEST RUNNER FILE TO EXECUTE TESTS- USING JUNIT or TESTNG ////////////////////

package cucumberRunner;

import java.io.File;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
//import org.testng.*;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



//import cucumber.api.testng.AbstractTestNGCucumberTests;
// Run with Junit
@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/java/features"
        ,glue= "stepdefination",
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
        monochrome = true
                )

public class TestRunner  {
//public class TestRunner extends AbstractTestNGCucumberTests{
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("config/report.xml"));
        
    
    }
    
    public static void sendReportEmail() {
    	//Configure email from here or If you are using Jenkins then configure email hook after post execution
    	//Runtime.getRuntime().exec(System.getProperty(user.home\\Sendemail.vbs));
    	
    }
    
    
}