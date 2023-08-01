package UtilitiesPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenUtility {
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFCell cell;
	public XSSFRow row;
	FileInputStream fileInputStream;
	String filePath;
	
	public void putData() throws Exception {
		String filePath =System.getProperty("user.dir") + "\\ExcelFolder\\ExcelRead.xlsx";
		fileInputStream = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet("Sheet3");
		
		String[] data = {"Name","MobileNo","Email","Password"};
		
		Row headerRow = sheet.createRow(0);
		for(int i=0;i<data.length;i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(data[i]);
		}
		
		String[][] sampleData = {
				{"GauravA","98855","amm@gmail.com","12345"},
				{"GauravB","9885566","amm1@gmail.com","123456"},
				{"GauravC","988556677","amm2@gmail.com","1234567"}
		};
		
		for(int i=0;i<sampleData.length;i++) {
			XSSFRow datarRow = sheet.createRow(i+1);
			for(int k=0;k<sampleData[0].length;k++) {
				XSSFCell dataCell = datarRow.createCell(k);
				dataCell.setCellValue(sampleData[i][k]);
			}
		}
		
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			workbook.write(fos);
			System.out.println("Data Written to Excel");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
