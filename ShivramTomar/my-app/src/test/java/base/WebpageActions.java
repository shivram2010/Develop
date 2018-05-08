package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.WebApplicationException;


public class WebpageActions {
	ApplicationConstants applicationConstants = ApplicationConstants.getInstance();
	
	public void waitForSomeTime(int timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            throw new WebApplicationException(e);
        } catch (Exception e) {
            throw new WebApplicationException(e);
        }
    }
	
	 protected WebDriver getDriver() {
	        return applicationConstants.getDriver();
	    }
	protected void click(Object webElementLocator) {
        WebElement webElement = null;
        try {
            if (webElementLocator instanceof By) {
                webElement = waitForElementClickability((By) webElementLocator);
            } else if (webElementLocator instanceof WebElement) {
                webElement = (WebElement) webElementLocator;
            }

            if (getDriver() instanceof PhantomJSDriver)
                webElement.click();// Commented by Rahul
            else
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", webElement); // Added by Rahul

        }
//		catch(StaleElementReferenceException | WebDriverException sere)
        catch (WebDriverException sere) {
            
             * This following loop is to try to make sure that element gets displayed in at least 5 attempts of StateElementException or WebDriverException
             
            for (int i = 1; i <= 5; i++) {
                try {
                    System.out.println("WE JUST GOT STALE ELEMENT REFERENCE Or WEBDRIVEREXCEPTION - Trying to handle that now in performClick() method...");
                    int tempTimeWait = 10;
                    waitForSomeTime(tempTimeWait);  //Giving static wait here as following method alone is not helpful.
                    WebDriverWait wait = new WebDriverWait(getDriver(), tempTimeWait);
                    if (webElementLocator instanceof By) {
                        webElement = wait.until(
                                ExpectedConditions.refreshed(
                                        ExpectedConditions.elementToBeClickable((By) webElementLocator)
                                )
                        );
                    } else if (webElementLocator instanceof WebElement) {
                        webElement = (WebElement) webElementLocator;
                        webElement = wait.until(
                                ExpectedConditions.refreshed(
                                        ExpectedConditions.elementToBeClickable(webElement)
                                )
                        );
                    }
                    webElement.click();
                } catch (WebDriverException e) {
                    if (i == 5) {
                        webElement.click();  //To make sure that exception gets thrown
                    } else
                        continue;
                }
                break;
            }
        }
    }

	
	protected WebElement waitForElementClickability(By locator, int timeInSeconds) {
        WebElement webElement = null;
        try {
            webElement = (new WebDriverWait(getDriver(), timeInSeconds))
                    .until(ExpectedConditions.elementToBeClickable(locator));

        } catch (StaleElementReferenceException sere) {
            System.out.println("WE JUST GOT STALE ELEMENT REFERENCE - Trying to handle that now...");
            WebDriverWait wait = new WebDriverWait(getDriver(), timeInSeconds);
            webElement = wait.until(
                    ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(locator)
                    )
            );
        }

        if (webElement == null) {
            System.err.println("Failed to find the element identified by - " + locator.toString());
            throw new WebApplicationException("Element is not clickable - " + locator);
        }
        return webElement;
    }
}
