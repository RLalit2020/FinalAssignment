package training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//Document to refer - https://makeseleniumeasy.com/2017/04/02/hierarchy-of-selenium-classes-and-interfaces/

public class WebElementAPI {

	static WebDriver driver;
	static String expectedErrorMsg = "The email address you entered isn't connected to an account. Find your account and log in.";

	@Test
	public static void WebElementAPIs() throws Exception {

		// Launch the browser
		driver = new ChromeDriver();

		// maximize the application
		driver.manage().window().maximize(); // method chaining

		// Implicitly wait statement - waits for entire web-page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Hit the Url of the application
		driver.get("https://facebook.com"); // inbuilt implicit wait mechanism in get() to wait for the page to load.

		// capture the email component
		WebElement email = driver.findElement(By.id("email"));

		email.click();
		email.clear();
		email.sendKeys("rakeshsinghrakm@gmail.com");

		// what if the page buffers and takes more time to load.
		// java wait statement -
		// Thread.sleep(5000); // Hard Coded wait statements

		// capture the password component
		WebElement password = driver.findElement(By.name("pass"));

		password.click();
		password.clear();
		password.sendKeys("Hakoonamatata");

		// capture the login button
		WebElement loginBtn = driver.findElement(By.xpath("//button[@data-testid='royal-login-button']"));

		if (loginBtn.isDisplayed() && loginBtn.isEnabled()) {
			// click on login button if it is displayed
			loginBtn.click();
			// Implicitly wait statement
		}

		// page is loading

		// Capture the text from the error message
		WebElement error = driver.findElement(By.xpath("//div[@id = 'email_container']//div[2]"));

		String currentErrorMessage = error.getText();
		System.out.println("currentErrorMessage = " + currentErrorMessage);

		// Verification
//		if (currentErrorMessage.equalsIgnoreCase(expectedErrorMsg)) {
//			System.out.println("Expected and Current Error Messages is same ==> Pass");
//		} else {
//			System.out.println("Incorrect Error Message ==> Fail");
//		} 
		
		//Assertion
		Assert.assertEquals(currentErrorMessage, expectedErrorMsg, "Error Message does not match");

		// navigate back
		driver.navigate().back();

		// Java Wait statement
		// Thread.sleep(3000);

		// Explicitly wait statement
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-testid='open-registration-form-button']")));
	

		// capture "Create New Account" button
		WebElement createNewAccountBtn = driver
				.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));

		// What is the HTML tag name utilized to create this button
		String tagName = createNewAccountBtn.getTagName();
		System.out.println("tagName for createNewAccountBtn = " + tagName);

		String attribute = createNewAccountBtn.getAttribute("role");
		System.out.println("attribute value for 'role' is " + attribute);

		String fontFamily = createNewAccountBtn.getCssValue("font-family");
		System.out.println("fontFamily = " + fontFamily);

		// tear down process or close the entire browser
		driver.quit();

	}

	public void fluentWait(int maxtime, int pollingTime) {
		// Declare and Initialize a fluent wait
		FluentWait wait = new FluentWait(driver);

		// maximum timeout to wait for
		wait.withTimeout(Duration.ofSeconds(maxtime));

		// give your own polling time to check multiple times
		wait.pollingEvery(Duration.ofMillis(pollingTime));

		// specify what exception we need to ignore
		wait.ignoring(NoSuchElementException.class);

	}

}
