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


public class MegaMenuStepDefination {

	ApplicationConstants applicationConstants = ApplicationConstants.getInstance();
	InfrastructureOperations operations = new InfrastructureOperations();
	
	@Before
	public void before(Scenario scenario) throws Throwable
    {
        System.out.println("Starting Scenario  :"+scenario.toString());
        applicationConstants.setCurrentTestScenario(scenario);
        //systemConstants.setScenarioStartTime(new Date().getTime());
    }
	
	@Given("^application is launched on \"([^\"]*)\" browser   $")
    public void launchMyApplication(String browser) throws Throwable 
    {
        System.out.println("Go Launch the application now");
        System.out.println("Browser - "+browser);
        operations.initializeBrowser(browser);
    }

    
    @When("^user clicks on MegaMenu $")
    public void user_clicks_on_megamenu() throws Throwable {
    	
    	System.out.println("Mouseover MegaMenu");
    	
    }

    @Then("^user is on the SummerDressesPage$")
    public void user_is_on_the_summerdressespage() throws Throwable {
    	System.out.println("Clicked on Summer Dresses");
    	driver.findElement(By.xpath("//div[2]/div/div/nav/div[1]/a")).click();
    	Assert.assertTrue("Summer Dresses "+text, text.equalsIgnoreCase("Summer Dresses"));
    }

}