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

public class SortByPrice {

    @Given("^user is on SummerDressesPage   $")
    public void user_is_on_summerdressespage() throws Throwable {
    	System.out.println("Control is on SummerDressesPage");
    	driver.findElement(By.xpath("//div[2]/div/div/nav/div[1]/a")).click();
    	Assert.assertTrue("Summer Dresses "+text, text.equalsIgnoreCase("Summer Dresses"));
    }

    @When("^user clicks on  Sortbydropdownoption$")
    public void user_clicks_on_sortbydropdownoption() throws Throwable {
    	System.out.println("Click on Dropdown");
    	WebElement mySelectElement = driver.findElement(By.id("selectProductSort"));
    	Select dropdown= new Select(mySelectElement);
    	dropdown.selectByVisibleText("Price: Lowest first");
    	
    }

    @Then("^user gets the OptionAddressed$")
    public void user_gets_the_optionaddressed() throws Throwable {
    	System.out.println("Select Option by Lowest first");
    	
    }

}