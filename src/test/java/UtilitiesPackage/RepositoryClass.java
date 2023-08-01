package UtilitiesPackage;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.DataProvider;

public class RepositoryClass {

	String filePath = System.getProperty("user.dir") + "/Object.properties";
	Properties properties;

	public RepositoryClass() {
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (Exception e) {
		}
	}

	public String urlOpen() {
		return properties.getProperty("url");
	}

	public String signInUrl() {
		return properties.getProperty("signIn");
	}
	
	public String hrmurll() {
		return properties.getProperty("hrmurl");
	}
	
	public String hrmloginurll() {
		return properties.getProperty("lloginurl");
	}
	
	

	@DataProvider(name = "nDPLogin")
	public Object[] amazonSignnIn() {

		Object[] ob = new Object[4];
		ob[0] = "9911225";
		ob[1] = "yyyyyyyyy@gmail.com";
		ob[2] = "oooooooo@gmail.com";
		ob[3] = "9911225";

		return ob;

	}

}
