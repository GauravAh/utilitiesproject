package AmazonTestCasePackage;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import AmazonBasePackage.BaseClass;
import PageFactory.AmazonHomePOM;
import UtilitiesPackage.RepositoryClass;

//@Listeners(UtilitiesPackage.ListenersClass.class)
public class HomePage extends BaseClass {

	@Test(priority = 1)
	public void signIn() throws Exception {
		Thread.sleep(3000);
		RepositoryClass repo = new RepositoryClass();
		getBrowser().get(repo.urlOpen());
		Thread.sleep(5000);
		System.out.println("Thread Id is.." + Thread.currentThread().getId());
		AmazonHomePOM home = new AmazonHomePOM(getBrowser());
		Actions actions = new Actions(getBrowser());
		WebElement AccountListn = home.AccountList();
		actions.moveToElement(AccountListn).build().perform();
		Thread.sleep(1000);
		WebElement SignInn = home.SignIn();
		actions.moveToElement(SignInn).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
	}
	
	@Test(priority = 2)
	public void titleSignIn() {
		String parentWindow = getBrowser().getWindowHandle();
		Set<String> allWindows = getBrowser().getWindowHandles();
		Iterator<String> itr = allWindows.iterator();
		while(itr.hasNext()) {
			String childWindow = itr.next();
			if(!parentWindow.equals(childWindow)) {
				getBrowser().switchTo().window(childWindow);
				System.out.println("Sign In page title is.." +getBrowser().getTitle());
			}
		}
	}

}
