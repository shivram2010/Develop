package stepdefination;


<<<<<<< HEAD
import org.junit.Assert;
import org.openqa.selenium.By;

=======
>>>>>>> bfd4e4a691ba494be6e78603f8edda6ce2dbac9a
import base.ApplicationConstants;
import base.InfrastructureOperations;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class ModifyItemStepDefination {
<<<<<<< HEAD
	ApplicationConstants applicationConstants = ApplicationConstants.getInstance();
	InfrastructureOperations operations = new InfrastructureOperations();
    @Given("^user is on SummerDressesPage   $")
    public void user_is_on_summerdressespage() throws Throwable {
    	 System.out.println("Starting Scenario  :"+scenario.toString());
         applicationConstants.setCurrentTestScenario(scenario);
=======

    @Given("^user is on SummerDressesPage   $")
    public void user_is_on_summerdressespage() throws Throwable {
        
>>>>>>> bfd4e4a691ba494be6e78603f8edda6ce2dbac9a
    }

    @Given("^user has selected a dress$")
    public void user_has_selected_a_dress() throws Throwable {
<<<<<<< HEAD
    	System.out.println("Select a dress");
=======
        throw new PendingException();
>>>>>>> bfd4e4a691ba494be6e78603f8edda6ce2dbac9a
    }

    @When("^user changes the colour of dress to Blue$")
    public void user_changes_the_colour_of_dress_to_blue() throws Throwable {
<<<<<<< HEAD
    	driver.findElement(By.xpath("//*[@id=\"color_20\"]")).click(); 
=======
        throw new PendingException();
>>>>>>> bfd4e4a691ba494be6e78603f8edda6ce2dbac9a
    }

    @Then("^add the item to the cart$")
    public void add_the_item_to_the_cart() throws Throwable {
<<<<<<< HEAD
    	driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[2]/div[2]/a[1]/span")).click();
    	Assert.assertTrue("Product successfully added to your shopping cart "+text, text.equalsIgnoreCase("Product successfully added to your shopping cart"));
    	
    }

}
=======
        throw new PendingException();
    }

}
public class ModifyItemStepDefination {
	//*[@id="color_20"]
}
>>>>>>> bfd4e4a691ba494be6e78603f8edda6ce2dbac9a
