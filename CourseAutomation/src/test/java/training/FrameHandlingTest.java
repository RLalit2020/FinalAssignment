package training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FrameHandlingTest {

	@Test
	public void framehandlingTest() {

		// Set the Browser properties
		System.setProperty("webdriver.chrome.driver", "..\\CourseAutomation\\Drivers\\chromedriver.exe");

		// ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--incognito");
		options.addArguments("start-maximized");

		// Launch the browser
		WebDriver driver = new ChromeDriver(options);

		// Implicitly Wait statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().window().maximize();

		// Hit the application url
		driver.get("https://demoqa.com/frames");

		WebElement frame1 = driver
				.findElement(By.xpath("//div[contains(@id,'frame1Wrapper')]//iframe[@src='/sample']"));

		// Shift the focus of selenium to desired Iframe
		driver.switchTo().frame(frame1);

		// Read the heading inside the frame
		String frameText = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println("Frame Heading = " + frameText);

		// How to come out of a frame once the work has been done in the given frame -
		driver.switchTo().defaultContent();

		// now read the data from default HTML document
		String currentText = driver
				.findElement(By.xpath(
						"//div[contains(text(), 'Use browser inspecter or firebug to check out the HTML source.')]"))
				.getText();

		System.out.println("currentText = " + currentText);
		

	}
}
