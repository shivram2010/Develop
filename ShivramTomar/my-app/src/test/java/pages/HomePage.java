package pages;

import org.openqa.selenium.By;

import cucumber.api.java.en.When;

public class HomePage {
	
	@When("^user clicks on sign in$")
	public void navigateToRegistrationPage(){
		driver.findElement(By.xpath("//div[2]/div/div/nav/div[1]/a")).click();
	}

}
