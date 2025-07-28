package training;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowSwitchingTest {

	@Test
	public void SwitchWindowsTest() {
		// Set the Browser properties
		System.setProperty("webdriver.chrome.driver", "..\\CourseAutomation\\Drivers\\chromedriver.exe");

		// ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("start-maximized");

		// Launch the browser
		WebDriver driver = new ChromeDriver(options);

		// maximize the application
		driver.manage().window().maximize(); // method chaining

		// Implicitly Wait statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Hit the application url
		driver.get("https://www.irctc.co.in/nget/train-search");

		// Check if the Pop-up has been displayed
		WebElement alertBox = driver.findElement(By.xpath("//span[text() = 'Alert']"));

		//Assertion
		Assert.assertTrue(alertBox.isDisplayed(), "Javascript Alert has not been displayed");
		
		if (alertBox.isDisplayed()) {
			// Click on the ON button to remove alert box
			driver.findElement(By.xpath("//button[@type='submit' and text() = 'OK']")).click();
			// remove the cookies
			driver.manage().deleteAllCookies();
		}

		// Currently Selenium is focusing on parent window
		String parentWindowId = driver.getWindowHandle(); 

		System.out.println("Parent Window Id = " + parentWindowId);

		// click on Flights Menu
		driver.findElement(By.xpath("//a[contains(text(), 'FLIGHTS')]")).click();

		// check if the user is on parent window still -
		String currentUrl = driver.getCurrentUrl(); 
		System.out.println(currentUrl); // still on parent window

		// get Window ids of all the windows

		Set<String> setObject = driver.getWindowHandles();
		System.out.println(setObject);

		// Iterator methods to retrieve the data form set object
		Iterator<String> it = setObject.iterator();

		String parentId = it.next();
		String flightsId = it.next();
		// check if another window id is visible
		boolean doWeHaveAnotherValue = it.hasNext();
		String newWindow;
		if (doWeHaveAnotherValue) {
			newWindow = it.next();
		} else {
			System.out.println("There is not other window Id in set object");
		}

		// shift your focus to the Child window (Flights Window)
		driver.switchTo().window(flightsId);

		// Check if the selenium focus has been transfered to Flights window
		String currentUrlAfterSwitch = driver.getCurrentUrl();

		// verification step
		if (currentUrlAfterSwitch.contains("air")) {
			System.out.println("User is now on child window(Flights)");
			driver.close();
		}
		// selenium focus has been lost, regain it to parent window id
		driver.switchTo().window(parentId);

		// handle synchronization
		boolean status = driver.findElement(By.xpath("//label[contains(text(), 'BOOK TICKET')]")).isDisplayed();

		if (status) {
			// code to fill the form
		}
	}
}
