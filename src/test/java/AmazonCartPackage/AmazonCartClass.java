package AmazonCartPackage;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import AmazonBasePackage.BaseClass;
import UtilitiesPackage.HashMapClass;
import UtilitiesPackage.RepositoryClass;

public class AmazonCartClass extends BaseClass {
	
	@Test
	public void openHrm() throws Exception {
		Thread.sleep(3000);
		RepositoryClass repo = new RepositoryClass();
		getBrowser().get(repo.hrmurll());
		Thread.sleep(5000);
		System.out.println("Thread Id is.." + Thread.currentThread().getId());
		
		HashMapClass cll = new HashMapClass();
		HashMap<String, String> ki = cll.readData();
		System.out.println("Keys are.." + ki.keySet());
		for( Entry<String, String> re : ki.entrySet()) {
			getBrowser().findElement(By.name("username")).sendKeys(re.getValue());
		}
		
	}
	

}
