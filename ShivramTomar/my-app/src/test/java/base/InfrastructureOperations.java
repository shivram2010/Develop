package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InfrastructureOperations {

	WebDriver driver = null;
	public void initializeBrowser(String browser){
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/lib/chromedriver_win.exe");
			driver = new ChromeDriver();
			driver.get(ApplicationConstants.getProperty("ApplicationUrl"));
		}
	}
}
