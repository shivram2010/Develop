package util;

import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

@SuppressWarnings("serial")
public class PropertiesUtil extends Properties {

	public static String currentEnvironment = null;
	private static  String getCurrentEnvironmentName() {
		//Below command to execute from command line parameter -Denv=ENV_NAME
		currentEnvironment =  System.getProperty("env");

		if (currentEnvironment==null || currentEnvironment=="")
		{
			Properties propMainEnvFile = new Properties();
			InputStream inputStreamMain = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/env.properties");
			try {
				propMainEnvFile.load(inputStreamMain);
				currentEnvironment = propMainEnvFile.getProperty("env");
			} 
			catch(Throwable t) {
				t.printStackTrace();
			}
		}

		return currentEnvironment;
	}

	/*public static String getProprty(String key) {
		String config = "configurations/"+getCurrentEnvironmentName()+".properties";
		Properties properties = new Properties();
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(config);
		try {
			properties.load(inputStream);
			inputStream.close();
		} 
		catch (Throwable t) {
			t.printStackTrace();
		}
		String value = properties.getProperty(key);
		return value;
	}*/

	public static Hashtable<String, String> getPropertyFileMap(){
		Hashtable<String, String>  propertyTable = new Hashtable<>();
		String config = "configurations/"+getCurrentEnvironmentName()+".properties";
		Properties properties = new Properties();
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(config);
		try {
			properties.load(inputStream);
			inputStream.close();
		} 
		catch (Throwable t) {
			t.printStackTrace();
		}
		for (String key : properties.stringPropertyNames()) {
			String value = properties.getProperty(key);
			propertyTable.put(key, value);
		}
		return propertyTable;
	}
}


