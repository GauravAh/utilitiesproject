package UtilitiesPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashMapClass {

	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public File file;
	public FileInputStream fileInputStream;
	public HashMap<String, String> hmap;
	public XSSFCell cell;

	public HashMap<Integer, String> hashSignIn() {

		HashMap<Integer, String> hashSignin = new HashMap<Integer, String>();
		hashSignin.put(1, "abc@ggmail.com");
		hashSignin.put(2, "9988552233");
		hashSignin.put(3, "9988552244");
		hashSignin.put(4, "uiui@gmail.com");

		return hashSignin;
	}

	public HashMap<String, String> readData() {

		String filePath = System.getProperty("user.dir") + "\\ExcelFolder\\ExcelRead.xlsx";
		file = new File(filePath);
		if (file.exists()) {
			try {
			fileInputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(fileInputStream);
			sheet = workbook.getSheet("Sheet1");
			}catch (Exception e) {
			}
			int rows = sheet.getLastRowNum();

			hmap = new HashMap<String, String>();

			for (int i = 1; i <= rows; i++) {
				String key =  String.valueOf(sheet.getRow(i).getCell(0).getNumericCellValue());
				String value = sheet.getRow(i).getCell(1).getStringCellValue();
				hmap.put(key, value);
			}

		} else {
			System.out.println("File not Exist");

		}
		return hmap;

	}
}
