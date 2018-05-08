package runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
	@CucumberOptions(strict = true,
	monochrome = true,
<<<<<<< HEAD
	features = {"src/test/resources/features"},
					 	plugin = {"pretty:target/cucumber-pretty.txt",
	        					"usage:target/cucumber-usage.json", 
	        					"html:target/cucumber-pretty",
					 		    "json:target/cucumber.json"}, glue="src/test/java/stepdefination")
=======
	features = {"src/test/resources/features/IncidentStatus.feature"},
					 	plugin = {"pretty:target/cucumber-pretty.txt",
	        					"usage:target/cucumber-usage.json", 
	        					"html:target/cucumber-pretty",
					 		    "json:target/cucumber.json"})
>>>>>>> bfd4e4a691ba494be6e78603f8edda6ce2dbac9a
public class Runner {

}
