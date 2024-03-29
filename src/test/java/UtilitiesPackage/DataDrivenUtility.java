package UtilitiesPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import freemarker.core.ReturnInstruction.Return;

public class DataDrivenUtility {

	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFCell cell;
	public XSSFRow row;
	FileInputStream fileInputStream;
	String filePath;

	public void putData() throws Exception {
		String filePath = System.getProperty("user.dir") + "\\ExcelFolder\\ExcelRead.xlsx";
		fileInputStream = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet("Sheet3");

		String[] data = { "Name", "MobileNo", "Email", "Password" };

		Row headerRow = sheet.createRow(0);
		for (int i = 0; i < data.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(data[i]);
		}

		String[][] sampleData = { { "GauravA", "98855", "amm@gmail.com", "12345" },
				{ "GauravB", "9885566", "amm1@gmail.com", "123456" },
				{ "GauravC", "988556677", "amm2@gmail.com", "1234567" } };

		for (int i = 0; i < sampleData.length; i++) {
			XSSFRow datarRow = sheet.createRow(i + 1);
			for (int k = 0; k < sampleData[0].length; k++) {
				XSSFCell dataCell = datarRow.createCell(k);
				dataCell.setCellValue(sampleData[i][k]);
			}
		}

		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			workbook.write(fos);
			System.out.println("Data Written to Excel");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String[][] readData(String filePath) {

		File file = new File(filePath);
		try {
			fileInputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(fileInputStream);
			sheet = workbook.getSheet("Sheet3");
			int numRows = sheet.getLastRowNum();
			int numCols = sheet.getRow(1).getLastCellNum();

			String[][] data = new String[numRows][numCols];

			for (int i =1; i <=numRows; i++) {
				row = sheet.getRow(i);
				for (int j = 0; j < numCols; j++) {
					cell = row.getCell(j);
					String cellValue = "";
					if (cell != null) {
						cellValue = getStringCellValuess(cell);
					}
					data[i-1][j] = cellValue;
				}

			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String getStringCellValuess(Cell cell) {

		switch (cell.getCellType()) {

		case STRING:
			return cell.getStringCellValue();

		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());

		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());

		default:
			return "";
		}

	}

}
