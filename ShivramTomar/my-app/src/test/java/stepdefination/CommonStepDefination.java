package stepdefination;

import base.ApplicationConstants;
import base.InfrastructureOperations;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class CommonStepDefination {
	ApplicationConstants applicationConstants = ApplicationConstants.getInstance();
	InfrastructureOperations operations = new InfrastructureOperations();
	
	@Before
	public void before(Scenario scenario) throws Throwable
    {
        System.out.println("Starting Scenario  :"+scenario.toString());
        applicationConstants.setCurrentTestScenario(scenario);
        //systemConstants.setScenarioStartTime(new Date().getTime());
    }
	
	
	@Given("^application is launched on \"([^\"]*)\" browser$")
    public void launchMyApplication(String browser) throws Throwable 
    {
        System.out.println("Go Launch the application now");
        System.out.println("Browser - "+browser);
        operations.initializeBrowser(browser);
    }

}
