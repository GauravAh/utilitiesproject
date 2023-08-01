package AmazonCartPackage;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AmazonBasePackage.BaseClass;
import UtilitiesPackage.RepositoryClass;
import UtilitiesPackage.UtilityClass;

public class HrmLogin extends BaseClass {
	
	String filePath =System.getProperty("user.dir") + "\\ExcelFolder\\ExcelRead.xlsx";
	
	@Test(dataProvider = "lData")
	public void hrmLoginDetail(String uname, String pass) throws Exception {
		Thread.sleep(3000);
		RepositoryClass repo = new RepositoryClass();
		getBrowser().get(repo.hrmloginurll());
		Thread.sleep(10000);
		System.out.println("Thread Id is.." + Thread.currentThread().getId());
		getBrowser().findElement(By.name("username")).sendKeys(uname);
		getBrowser().findElement(By.name("password")).sendKeys(pass);
	}
	
	@DataProvider(name = "lData")
	public String[][] dpData() throws Exception {
		UtilityClass classd = new UtilityClass(filePath);
		int rrows = classd.getRows("Sheet1");
		int ccols = classd.getColumns("Sheet1", 1);
		
		String[][] loData = new String[rrows][ccols];
		
		for(int i=1;i<=rrows;i++) {
			for(int j=0;j<ccols;j++) {
				loData[i-1][j] = classd.getData("Sheet1", i, j);
			}
		}
		
		return loData;
	}
	

}
