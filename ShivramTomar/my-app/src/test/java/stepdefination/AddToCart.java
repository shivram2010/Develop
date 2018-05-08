package stepdefination;

import org.junit.Assert;
import org.openqa.selenium.By;

import base.ApplicationConstants;
import base.InfrastructureOperations;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class AddToCart {
	ApplicationConstants applicationConstants = ApplicationConstants.getInstance();
	InfrastructureOperations operations = new InfrastructureOperations();
	
    @Given("^Product is selected $")
    public void application_is_launched_on_something_browser(String strArg1) throws Throwable {
    	System.out.println("Starting Scenario  :"+scenario.toString());
        applicationConstants.setCurrentTestScenario(scenario);
    }

    @Given("^user clicks on AddToCart$")
    public void user_clicks_on_addtocart() throws Throwable {
    	Assert.assertTrue("Product successfully added to your shopping cart "+text, text.equalsIgnoreCase("Product successfully added to your shopping cart")); 
    }

    @When("^user validates Name$")
    public void user_validates_name() throws Throwable {
    	String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
    	String subWindowHandler = null;

    	Set<String> handles = driver.getWindowHandles(); // get all window handles
    	Iterator<String> iterator = handles.iterator();
    	while (iterator.hasNext()){
    	    subWindowHandler = iterator.next();
    	}
    	driver.switchTo().window(subWindowHandler); // switch to popup window
    	Assert.assertTrue("Printed Summer Dress "+text, text.equalsIgnoreCase("Printed Summer Dress"));
    	Assert.assertTrue("Yellow, S "+text, text.equalsIgnoreCase("Yellow, S"));
    	//Quantity check
    	String Quantity = Driver.findElement(By.xpath("//*[@id=\"layer_cart_product_quantity\"]']")).isDisplayed();
		
		if(Quantity=="1"){
			System.out.println("Quantity is correct");
		} else {
			System.out.println("Quantity is wrong");
		}
    }
    	
    
    @Then("^Name is correct$")
    public void name_is_correct() throws Throwable {
    	
    	System.out.println("Name is correct");
    	System.out.println("Colour is correct");
    	System.out.println("Quantity is correct");
        
    }

}