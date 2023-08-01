package AmazonBasePackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	
	@Parameters("browser")
	@BeforeClass
	public void setupBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("start-maximized");
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			Logger logger = LogManager.getLogger(BaseClass.class.getName());
			logger.info("Application open in Incognito Mode and Maximized");
			threadLocalDriver.set(driver);
		} else if (browserName.equalsIgnoreCase("ie")) {
			InternetExplorerOptions options = new InternetExplorerOptions();	
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(options);
			threadLocalDriver.set(driver);
		}
	}

	public static WebDriver getBrowser() {
		return threadLocalDriver.get();
	}

}
