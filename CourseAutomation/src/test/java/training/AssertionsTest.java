package training;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsTest {
	@Test(groups = { "smoke test" })
	public void HardAsserts() {

		String name = "Edureka"; // SCP - String Constant Pool
		String name2 = new String("Edureka is best"); // Heap Memory & in SCP

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

		driver.get("https://facebook.com");

		String currentTitle = driver.getTitle();

		Assert.assertEquals(currentTitle, "Facebook – log in or sign up");

		Assert.assertNotEquals(currentTitle, "Facebook");

		Assert.assertNotNull(currentTitle);

		// Assert.assertNull(currentTitle); //expecting null value

		System.err.println("------------------Control Flow----------------------");

		Assert.assertFalse(currentTitle.isEmpty());
		Assert.assertTrue(!(currentTitle.isEmpty()));

	}

	@Test(groups = { "regression test" })
	public void softAssert() {

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

		driver.get("https://facebook.com");

		String currentTitle = driver.getTitle();

		// Soft Assertion
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals("A", "A");

		softAssert.assertNotEquals("A", "B");

		softAssert.assertTrue(currentTitle.isEmpty(), "CurrentTitle is not Empty");

		//softAssert.assertFalse(currentTitle.isEmpty(), "Current Title is Empty");

		String str1 = "Rakesh";
		String str2 = "Edureka";

		// softAssert.assertSame(str1, str2); // content comparison in object
		softAssert.assertNotSame(str1, str2); // content comparison in object

		// mandatory step
		softAssert.assertAll();
	}
}
