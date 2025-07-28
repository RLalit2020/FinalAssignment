package MSExcelAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class MSExcelAutomationTest {

	@Test
	public void readExcelData() throws Exception {

		File filepath = new File("..\\CourseAutomation\\src\\test\\resources\\TestDataSheet\\TestData.xlsx");

		FileInputStream fis = new FileInputStream(filepath);

		// Get the control of the workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Get the control of the Sheet
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		// Get the control of the row
		XSSFRow row = sheet.getRow(1);

		// get the data from the desired cell of the row
		String url = row.getCell(2).getStringCellValue();
		String username = row.getCell(3).getStringCellValue();
		String password = row.getCell(4).getStringCellValue();

		System.out.println("url: " + url);
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		
		workbook.close();
	}
	
	@Test
	public void setExcelData() throws Exception {

		File filepath = new File("..\\CourseAutomation\\src\\test\\resources\\TestDataSheet\\TestData.xlsx");

		FileInputStream fis = new FileInputStream(filepath);

		// Get the control of the workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Get the control of the Sheet
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		// Get the control of the row
		XSSFRow row = sheet.getRow(1);
		
		//create the cell
		XSSFCell cell = row.createCell(5);
		
		cell.setCellValue("Contract123");
		
		FileOutputStream fos = new FileOutputStream(filepath);
		
		workbook.write(fos);
		
		workbook.close(); // mandatory step

	}
}
