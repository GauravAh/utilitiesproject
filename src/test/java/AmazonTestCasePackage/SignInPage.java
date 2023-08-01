package AmazonTestCasePackage;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AmazonBasePackage.BaseClass;
import UtilitiesPackage.HashMapClass;
import UtilitiesPackage.RepositoryClass;

//@Listeners(UtilitiesPackage.ListenersClass.class)
public class SignInPage extends BaseClass {
	
	@Test(dataProvider = "nDPLogin", dataProviderClass = RepositoryClass.class,priority = 1)
	public void loginSignin(String nameField) throws Exception {
		Thread.sleep(3000);
		RepositoryClass repo = new RepositoryClass();
		getBrowser().get(repo.signInUrl());
		Thread.sleep(3000);
		System.out.println("Thread Id is.." + Thread.currentThread().getId());
		JavascriptExecutor jsExecutor = (JavascriptExecutor)getBrowser();
		jsExecutor.executeScript("document.getElementById('ap_email').value='"+nameField+"';");
	}
	
	@Test(priority = 2)
	public void hashSign() {
		getBrowser().findElement(By.xpath("//*[@class='a-section']/div/div/div/input[@id='ap_email']")).clear();
		HashMapClass hm = new HashMapClass();
		HashMap<Integer, String> hu = hm.hashSignIn();
		for(Entry<Integer, String> ff : hu.entrySet()) {
			getBrowser().findElement(By.xpath("//*[@class='a-section']/div/div/div/input[@id='ap_email']")).sendKeys(ff.getValue());
		}
	}
	
	@DataProvider(name = "dppLogin")
	public String[] dpLogin() {
		
		String[] data = new String[4];
		data[0]= "abc@gmail.com";
		data[1]= "abccccc@gmail.com";
		data[2]= "abceeeee@gmail.com";
		data[3]= "abcgggggg@gmail.com";
		
		return data;
	};
	
}
