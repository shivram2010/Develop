package base;
import java.util.Hashtable;
import cucumber.api.Scenario;
import util.PropertiesUtil;
import util.WebApplicationException;

public class ApplicationConstants {
	private static ApplicationConstants applicationConstants = null;
	public static Hashtable<String, String> envProperties = PropertiesUtil.getPropertyFileMap();
	private Scenario currentScenario = null;
	private long scenarioStartTime = 0;
	

	public static  ApplicationConstants getInstance()
	{
		if(applicationConstants == null)
		{
			applicationConstants = new ApplicationConstants();
			//Set the logger configuration here
			//System.setProperty("log4j.configurationFile", "log4j2.xml");
		}
		return applicationConstants;
	}
	public static String getProperty(String key){
		String value;
		try {
			value = envProperties.get(key);
		} catch (Throwable t) {
			 throw new WebApplicationException(key+" not found in "+PropertiesUtil.currentEnvironment+".properties file");
		}
		return value;
	}
	
	public void setCurrentTestScenario(Scenario scenario) {
		this.currentScenario = scenario;
	}
	public Scenario getCurrentTestScenario() {
		return currentScenario;
	}
	public void setScenarioStartTime(long scenarioStartTime) {
		this.scenarioStartTime = scenarioStartTime;
	}
}
