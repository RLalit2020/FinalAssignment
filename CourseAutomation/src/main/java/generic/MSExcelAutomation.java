package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MSExcelAutomation {

	/**
	 * <p>This method is used to read the data from an Excel sheet
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @throws Exception
	 * @author RakeshSingh
	 * 
	 */
	
	public static String readExcelData(String sheetName, int rowNum, int cellNum) throws Exception {

		//Java API
		FileInputStream fis = new FileInputStream(Constants.filepath);

		// Get the control of the workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Get the control of the Sheet
		XSSFSheet sheet = workbook.getSheet(sheetName);

		// Get the control of the row
		XSSFRow row = sheet.getRow(rowNum);

		// get the data from the desired cell of the row
		String data = row.getCell(cellNum).getStringCellValue();
		//	String value = row.getCell(cellNum).getStringCellValue();	
		System.out.println("Data From Excel: " + data);
		workbook.close();
		return data; 
	}

	/**
	 * This method is utilized to get the desired data form the user and add it to
	 * the specified location in Excel
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Exception
	 */
	public static void setExcelData(String sheetName, int rowNum, int cellNum, String data) throws Exception {

		FileInputStream fis = new FileInputStream(Constants.filepath);

		// Get the control of the workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Get the control of the Sheet
		XSSFSheet sheet = workbook.getSheet(sheetName);

		// Get the control of the row
		XSSFRow row = sheet.getRow(rowNum);

		// create the cell
		XSSFCell cell = row.createCell(cellNum);

		cell.setCellValue(data);

		FileOutputStream fos = new FileOutputStream(Constants.filepath);

		workbook.write(fos);

		workbook.close(); // mandatory step
	}
}
