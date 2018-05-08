package util;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

/**
 * This class is used to throw customized exceptions when ever there would be any application/system generated issues.
 * Purpose of this class is to record the list of issues - expected value and actual value and/also test related information.
 * This will keep track of issues and will log those in the logger. But as far as cucumber report is concerned, in the afterScenario() 
 * method of BackgroundFeature file will take care of that - taking screenshot in case of failure and pushing these issues maintained
 * in the report.
 * 
 * @author RAJNEESHYADAV
 *
 */
 @SuppressWarnings("serial")
public class WebApplicationException extends RuntimeException 
 {
	 Logger logger = LogManager.getLogger(WebApplicationException.class);
	 //private DriverManager driverManager = DriverManager.getInstance();
	 //private SystemConstants systemConstants = SystemConstants.getInstance();
	 public static List<String> issuesList = new ArrayList<String>();
	 String exceptionStr = "Expected :  %s   ====   Actual : %s";
	 String testExceptionStr = "Test : %s   ====   Expected :  %s   ====   Actual : %s";
     
	 public WebApplicationException(Exception exception) 
	 {
		 super(exception);
		 if(exception instanceof NoSuchElementException )
		 {
			 NoSuchElementException e = (NoSuchElementException)exception;
			 String errorMsg = e.getAdditionalInformation() + " == "+ e.getSystemInformation();
			 logger.error(errorMsg, e);
		 }
		 else if(exception instanceof StaleElementReferenceException )
		 {
			 StaleElementReferenceException e = (StaleElementReferenceException)exception;
			 String errorMsg = e.getAdditionalInformation() + " == "+ e.getSystemInformation();
			 logger.error(errorMsg, e);
		 }
		 else if(exception instanceof TimeoutException )
		 {
			 TimeoutException e = (TimeoutException)exception;
			 String errorMsg = e.getAdditionalInformation() + " == "+ e.getSystemInformation();
			 logger.error(errorMsg, e);
		 }
		 else if(exception instanceof ElementNotVisibleException )
		 {
			 ElementNotVisibleException e = (ElementNotVisibleException)exception;
			 String errorMsg = e.getAdditionalInformation() + " == "+ e.getSystemInformation();
			 logger.error(errorMsg, e);
		 }
		 else if(exception instanceof InvalidSelectorException )
		 {
			 InvalidSelectorException e = (InvalidSelectorException)exception;
			 String errorMsg = e.getAdditionalInformation() + " == "+ e.getSystemInformation();
			 logger.error(errorMsg, e);
		 }
		 else if(exception instanceof InvalidElementStateException )
		 {
			 InvalidElementStateException e = (InvalidElementStateException)exception;
			 String errorMsg = e.getAdditionalInformation() + " == "+ e.getSystemInformation();
			 logger.error(errorMsg, e);
		 }
		 else
		 {
			 String errorMsg = exception.getMessage();
			 if(!issuesList.isEmpty())
			 {
				 //If issue list is not empty that means problems have already been logged to logger individually and no need to log again
				 System.out.println(errorMsg);
			 }
			 logger.error("Exception - "+errorMsg, exception);
		 }
	 }
	 
	 public WebApplicationException(String exceptionMsg) 
	 {
		 super(exceptionMsg);
	     issuesList.add(exceptionMsg);
	     logger.error(exceptionMsg);
	 }
	 
	 public WebApplicationException(String exceptionMsg, boolean isExcptionThrown) 
	 {
		 if(isExcptionThrown)
		 {
			 throw new WebApplicationException(exceptionMsg);
		 }
		 else
		 {
			 //There may be some scenarios where you don't want to stop the execution by throwing exception, but just
			 //want to record the exception condition and continue with the execution
			 issuesList.add(exceptionMsg);
		     logger.error(exceptionMsg);
		 }
	 }
	 
	 public WebApplicationException(String exceptionMsg, boolean isExcptionThrown, boolean takeScreenshot)
	 {
		 if(isExcptionThrown)
		 {
			 throw new WebApplicationException(exceptionMsg);
		 }
		 else
		 {
			 //There may be some scenarios where you don't want to stop the execution by throwing exception, but just
			 //want to record the exception condition and continue with the execution
			 issuesList.add(exceptionMsg);
		     logger.error(exceptionMsg);
		     if(takeScreenshot)
		     {
		    	// systemConstants.getCurrentTestScenario().embed(driverManager.getScreenshotBytes(), "image/png");
		     }
		 }
	 }
	 
	 public WebApplicationException(String expected, String actual)
	 {
		 exceptionStr = String.format(exceptionStr, expected, actual);
		 new WebApplicationException(exceptionStr);
	 }
	 
	 public WebApplicationException(String expected, String actual, boolean isExcptionThrown)
	 {
		 exceptionStr = String.format(exceptionStr, expected, actual);
		 if(isExcptionThrown)
		 {
			 throw new WebApplicationException(exceptionStr);
		 }
		 else
		 {
			 //There may be some scenarios where you don't want to stop the execution by throwing exception, but just
			 //want to record the exception condition and continue with the execution
			 issuesList.add(exceptionStr);
		     logger.error(exceptionStr);
		 }
	 }
	 
	 public WebApplicationException(String testInfo, String expected, String actual, boolean isExcptionThrown)
	 {
		 testExceptionStr = String.format(testExceptionStr, testInfo, expected, actual);
		 if(isExcptionThrown)
		 {
			 throw new WebApplicationException(testExceptionStr);
		 }
		 else
		 {
			 //There may be some scenarios where you don't want to stop the execution by throwing exception, but just
			 //want to record the exception condition and continue with the execution
			 issuesList.add(testExceptionStr);
		     logger.error(testExceptionStr);
		 }
		 //Stopping the screenshot here because that is being captured now in the afterScenario method of the BackgroundFeature file
//		 driverManager.takeScreenshot("output\\Problems\\"+testInfo+".jpg");
	 }
	 
	 public WebApplicationException(String testInfo, String expected, String actual, boolean isExcptionThrown, Object webElementToHighlight)
	 {
		 new WebApplicationException(testInfo, expected, actual, isExcptionThrown);
		 //Highlight the concerned webelement on the screen
		 //PageObjectManager pageObjectMgr = new PageObjectManager();
		 //pageObjectMgr.highlightElement(webElementToHighlight);
	 }
	 
	 public static List<String> getErrorList()
	 {
		 return issuesList;
	 }
	 
	 public static void resetErrorList()
	 {
		 issuesList = new ArrayList<String>();
	 }
	 
	 public static String getErrorListStr()
	 {
		 String issueListStr = "";
		 if(issuesList.size() > 0)
		 {
			 for(String str : issuesList)
			 {
				 issueListStr += str + "\n";
			 }
			 issueListStr = issueListStr.trim();
		 }
		 return issueListStr;
	 }
	 
	 public WebApplicationException() 
	 {
		super("Application has issues - "+getErrorListStr());
		StackTraceElement steArr[] = new StackTraceElement[]{new StackTraceElement(this.getClass().getName(), "afterScenario", this.getClass().getName(), 1)};
        this.setStackTrace(steArr);
	 }
}
