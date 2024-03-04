package stepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPageObjects;
import utilities.BaseClass;

public class LoginPageSteps {

     WebDriver driver;
     Properties prop;
     Logger logger;
     LoginPageObjects obj;
    
    public LoginPageSteps() {
        this.driver = BaseClass.getDriver();
        this.prop = BaseClass.getProperties();
        this.logger = BaseClass.getLogger();
        this.obj = new LoginPageObjects(driver);
        
    }
    
    LoginPageObjects loginPageObjects;
    
    @Given("User is on the Login Page")
    public void user_is_on_the_login_page() {
    	loginPageObjects = new LoginPageObjects(driver);
    	loginPageObjects.navigateURL(prop.getProperty("url"));
    }

    @When("User enters the invalid {string} and {string}")
    public void user_enters_the_invalid_and(String InvalidUsername, String InvalidPassword)  {
    	loginPageObjects.InputCredentials(prop.getProperty("fakeUsername"), prop.getProperty("fakePassword"));
    	loginPageObjects.clickButton();
    	
    }

    @Then("User will get the error message error message")
    public void user_will_get_the_error_message_error_message() {
    	SoftAssert softAssert = new SoftAssert();
		String errorMessage=loginPageObjects.getErrorMessageText();
		softAssert.assertEquals("Invalid credentials", errorMessage);
    }

    @When("User enters the valid {string} and {string}")
    public void user_enters_the_valid_and(String validUsername, String validPassword) {
    	loginPageObjects.InputCredentials(prop.getProperty("username"), prop.getProperty("password"));
    	loginPageObjects.clickButton();

    }
   
    @Then("User will be redirected to the Home Page of OrangeHRM")
    public void user_will_be_redirected_to_the_home_page_of_orange_hrm() {
//    	loginPageObjects.portalLoginPage("OrangeHRM");
    }

}
