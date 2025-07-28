package training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameHandling {

	static WebDriver driver;

	@Test(groups = { "regression test" })
	public void frameHandling() {

		// Set the Browser properties
		System.setProperty("webdriver.chrome.driver", "..\\CourseAutomation\\Drivers\\chromedriver.exe");

		// ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		// Launch the browser
		WebDriver driver = new ChromeDriver(options);

		// maximize the application
		driver.manage().window().maximize(); // method chaining

		// Implicitly Wait statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Implicitly Wait statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Hit the Url of the application
		driver.get("https://demoqa.com/frames");

		// Switch to the default content
		driver.switchTo().frame("frame1");

		// capture the text from the frame
		String frameText = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();

		System.out.println("frameText = " + frameText);

		// Switch BACK to default content
		driver.switchTo().defaultContent();

		// capture the heading
		String heading = driver.findElement(By.xpath("//div[@id = 'framesWrapper']//div[1]")).getText();

		System.out.println("heading = " + heading);

		driver.quit();
	}

	@Test(groups = { "regression test" })
	public void nestedFrame() {
		// Set the Browser properties
		System.setProperty("webdriver.chrome.driver", "..\\CourseAutomation\\Drivers\\chromedriver.exe");

		// ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		// Launch the browser
		WebDriver driver = new ChromeDriver(options);

		// maximize the application
		driver.manage().window().maximize(); // method chaining

		// Implicitly Wait statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Hit the Url of the application
		driver.get("https://demoqa.com/modal-dialogs");

		// Click on Small modal prompt button
		driver.findElement(By.xpath("//button[@id = 'showSmallModal']")).click();

		WebElement resultSmall = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-sm']"));

		// Extract Heading Text
		String smallModal = resultSmall.getText();

		// Assertions
		Assert.assertTrue(smallModal.equalsIgnoreCase("Small Modal"), "Small Modal text does not match");

		// Check if the 'Small Modal' text is same as the displayed heading
		if (smallModal.equalsIgnoreCase("Small Modal")) {
			System.out.println("Entering into Small Modal popup!!!");

			// Capture Body Message of Small Modal
			WebElement bodyMsg = driver.findElement(By.xpath("//div[@class='modal-body']"));
			System.out.println("Small-modal body message: " + bodyMsg.getText());

			driver.findElement(By.xpath("//button[@class='close']")).click();
		} else {
			System.out.println("Exact Rseult and Heading both are not matching ==> Fail");
		}

		// Click on Large modal prompt button
		driver.findElement(By.xpath("//button[@id = 'showLargeModal']")).click();

		WebElement resultLarge = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']"));

		// Extract Heading Text
		String LargeModal = resultLarge.getText();

		// Check if the 'Small Modal' text is same as the displayed heading
		if (LargeModal.equalsIgnoreCase("Large Modal")) {
			System.out.println("Entering into Large Modal popup!!!");

			// Capture Body Message of Small Modal
			WebElement bodyMsg = driver.findElement(By.xpath("//div[@class='modal-body']"));
			System.out.println("Large-modal body message: " + bodyMsg.getText());

			driver.findElement(By.xpath("//button[@class='close']")).click();
		} else {
			System.out.println("Exact Rseult and Heading both are not matching ==> Fail");
		}

		driver.quit();

	}
}
