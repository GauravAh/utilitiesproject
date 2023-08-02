package AmazonCartPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.devtools.v85.domsnapshot.model.RareIntegerData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AmazonBasePackage.BaseClass;
import UtilitiesPackage.DataDrivenUtility;

public class AmazonCreateAcc {

	public static void main(String[] args) {
		String filePath =System.getProperty("user.dir") + "\\ExcelFolder\\ExcelRead.xlsx";
		DataDrivenUtility ut = new DataDrivenUtility();
		String[][] rData = ut.readData(filePath);
		for (String[] data : rData) {
			System.out.println(data[0]); 
			System.out.println(data[1]); 
			System.out.println(data[2]); 
			System.out.println(data[3]); 
        }
		
		
		
	}

}
