package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePOM {

	WebDriver driver;

	public AmazonHomePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@class='nav-right']/div/a[2]")
	WebElement AccountList;

	@FindBy(xpath = "//*[@id='nav-al-container']/div/div[1]/a")
	WebElement SignIn;

	public WebElement AccountList() {
		return AccountList;
	}

	public WebElement SignIn() {
		return SignIn;
	}

}
