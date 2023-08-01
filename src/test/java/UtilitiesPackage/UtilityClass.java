package UtilitiesPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilityClass {
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public File file;
	public FileInputStream fileInputStream;
	public XSSFCell cell;
	public XSSFRow row;
	String filePath;
	
	public UtilityClass(String filePath){
		this.filePath = filePath;
	}
	
	public int getRows(String sheetname) throws Exception {
		fileInputStream = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetname);
		int rows= sheet.getLastRowNum();
		return rows; 
	}
	
	public int getColumns(String sheetname, int rownum) throws Exception {
		
		fileInputStream = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		int cols = row.getLastCellNum();
		return cols;
	}
	
	public String getData(String sheetname, int rownum, int colnum) throws Exception {
		fileInputStream = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		String data = null;
		DataFormatter formatter = new DataFormatter();
		try {
		data = formatter.formatCellValue(cell);
		}catch (Exception e) {
			data="";
		}
		return data;
	}

}
