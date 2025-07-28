package generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {

	// generate timestamp
	public static String getCurrentTimeStamp() {

		String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

		return timestamp;
	}

	// Take screenshot on failure(integrate it with the TestNG Listner)
	public static void takeScreenShot(WebDriver driver, String fileName) {

		try {
		    // Cast driver to TakesScreenshot
		    TakesScreenshot screenshot = (TakesScreenshot) driver;
		    File source = screenshot.getScreenshotAs(OutputType.FILE);

		    // Use relative path and forward slashes for cross-platform compatibility
		    String destinationPath = "src/test/resources/screenshots/" + fileName + "_" + getCurrentTimeStamp() + ".png";
		    File destination = new File(destinationPath);

		    // Create parent directories if needed
		    destination.getParentFile().mkdirs();

		    // Copy screenshot to the destination
		    FileUtils.copyFile(source, destination);

		    System.out.println("✅ Screenshot saved at: " + destination.getAbsolutePath());
		} catch (IOException e) {
		    System.err.println("❌ Error saving screenshot: " + e.getMessage());
		}


	}

}
