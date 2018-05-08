package com.automationPractice.app;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefination {
	
	WebDriver driver = null;
	
	@Given("^site (.*?)$")
	public void openBrowser(String url){
		System.setProperty("webdriver.chrome.driver", "C:/my-app/lib/chromedriver_win.exe");
		driver = new ChromeDriver();
		driver.get(url);
		Assert.assertTrue("Expected title My Store and actual title: "+driver.getTitle(), driver.getTitle().equals("My Store"));
	} 
	
	@When("^user clicks on sign in$")
	public void navigateToRegistrationPage(){
		driver.findElement(By.xpath("//div[2]/div/div/nav/div[1]/a")).click();
	}
	
	@Then("^user enters (.*?) id$")
	public void enterEmailId(String emailId){
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(emailId);
	}
	
	@And("^create account$")
	public void createAccount(){
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
	}
	
	@Then("^user should get user exception$")
	public void validateRegistration() throws InterruptedException{
		Thread.sleep(3000);
		String exception = driver.findElement(By.xpath("//div[@id='create_account_error']/ol/li")).getText();
		System.out.println(exception);
		Assert.assertTrue("Expected exception Invalid email address and actual title: "+exception, exception.equals("Invalid email address."));
		driver.quit();
	}
	
	@Then("^user should redirect to registration page$")
	public void redirectToRegistrationPage() throws InterruptedException{
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//*[@id='account-creation_form']/div[1]/h3")).getText();
		System.out.println(text);
		Assert.assertTrue("Expected text Your personal information and actual title: "+text, text.equalsIgnoreCase("Your personal information"));
		driver.quit();
	}
	////div[2]/div/div/nav/div[1]/a -- Sign In
	//email address - //input[@id='email_create']
	//create an account - //button[@id='SubmitCreate']
	// Exception //div[@id='create_account_error']/ol/li
	//Add your Info //*[@id='account-creation_form']/div[1]/h3

}
