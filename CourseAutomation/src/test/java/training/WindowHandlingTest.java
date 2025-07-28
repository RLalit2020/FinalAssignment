package training;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

//import generic.Drivers;

public class WindowHandlingTest {

	static WebDriver driver;

	@Test(groups = { "regression test" })
	public void WindowSwitchingTest() {

		// Set the Browser properties
		System.setProperty("webdriver.chrome.driver", "..\\CourseAutomation\\Drivers\\chromedriver.exe");

		// ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		// Launch the browser
		WebDriver driver = new ChromeDriver(options);

		// driver = Drivers.getbrowser();

		// maximize the application
		driver.manage().window().maximize(); // method chaining

		// Implicitly Wait statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Hit the application url
		driver.get("https://www.irctc.co.in/");

		// maximize the window
		driver.manage().window().maximize();

		// click on flights window
		driver.findElement(By.xpath("//a[contains(@aria-label,'Menu Flight')]")).click();

		// to get to know on which window I am
		String windowTitle = driver.getTitle();
		System.out.println("windowTitle = " + windowTitle);

		if (windowTitle.equalsIgnoreCase("IRCTC Next Generation eTicketing System")) {
			System.out.println("User is on Parent Window");
		}

		// since 2 windows are opened now, we need to capture the unique identifier for
		// the windows - window ID

		String currentWindow = driver.getWindowHandle(); // return the current window id. where selenium is currently
															// focusing
		System.out.println("currentWindow = " + currentWindow);

		// get all the window ids which are opened by selenium
		Set<String> set = driver.getWindowHandles();
		System.out.println(set);

		// Iterator methods to retrieve the data from set object
		Iterator<String> it = set.iterator();

		String parentWindow = it.next();
		System.out.println("parentWindow = " + parentWindow);

		// check if the next window id is available.
		boolean doWeHaveNextElement = it.hasNext();

		System.out.println("doWeHaveNextElement = " + doWeHaveNextElement); // true - if next value exists

		String FlightsWindow = it.next();

		// now switch the focus of selenium from parent window to Flights window
		driver.switchTo().window(FlightsWindow);

		String currentUrl = driver.getCurrentUrl();

		if (currentUrl.contains("air")) {
			System.out.println("User is on flights window");
			driver.close();
			// after closing the current window - selenium focus will be lost, because
			// selenium was focusing here
		}

		// Regain the focus
		driver.switchTo().window(parentWindow);

		// click on from edit box and provide details
		driver.findElement(By.xpath("//input[contains(@class,'ng-tns-c57-8 ui-inputtext ui-widget')]"))
				.sendKeys("Bangalore");

		driver.quit();

	}

	@Test(groups = { "regression test" })
	public void PopUpHandlingTest() throws Exception {
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
		// Hit the URL of the application
		driver.get("https://demoqa.com/modal-dialogs");

		WebElement smallModal = driver.findElement(By.xpath("//button[@id='showSmallModal']"));

		// Checking for the web element "Small Modal"
		if (smallModal.isDisplayed()) {
			System.out.println("User has found 'Small Modal' pop up");

			// Click the button
			smallModal.click();

			// Get text from the large modal
			WebElement modalContent = driver.findElement(By.className("modal-body"));
			String text1 = modalContent.getText();
			System.out.println("Text in 'Small Modal' popup = " + text1);

			// Close the Small modal
			WebElement closeSmallButton = driver.findElement(By.id("closeSmallModal"));
			closeSmallButton.click();

		} else {
			System.out.println("User has not found the 'Small Modal'");
		}

		WebElement largeModal = driver.findElement(By.xpath("//button[@id='showLargeModal']"));

		// Checking for the web element "Large Modal"
		if (largeModal.isDisplayed()) {
			System.out.println("User has found 'Large Modal' pop up");

			// Click the button
			largeModal.click();

			// Get text from the large modal
			WebElement largeModalContent = driver.findElement(By.className("modal-body"));
			String text2 = largeModalContent.getText();
			System.out.println("Text in 'Large Modal' popup = " + text2);

			// Close the Large modal
			WebElement closeLargeButton = driver.findElement(By.id("closeLargeModal"));
			closeLargeButton.click();

		} else {
			System.out.println("User has not found the 'Small Modal'");
		}

		driver.quit();

	}

}
