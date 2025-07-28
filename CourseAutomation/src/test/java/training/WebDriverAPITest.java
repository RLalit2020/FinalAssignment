package training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WebDriverAPITest {

	static WebDriver driver;
	static String expectedErrorMsg = "The email address you entered isn't connected to an account. Find your account and log in";

	@Test(groups = { "regression test" })
	public void BrowserControlTest() {

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
		driver.get("https://facebook.com");

		// navigate to amazon page
		driver.navigate().to("https://amazon.in");

		// navigate back to facebook
		driver.navigate().back();

		// capture the current url of the application where selenium is focusing
		String currentUrl = driver.getCurrentUrl();
		System.out.println("currentUrl = " + currentUrl);

		// Veriy if the user is on facebook page - verification step
		if (currentUrl.equalsIgnoreCase("https://www.facebook.com/")) {
			System.out.println("User is able to navigate back to facebook page -> Pass");
		} else {
			System.out.println("User is still on Amazon page -> Fail");
		}

		// navigate forward
		driver.navigate().forward();

		// Capture the title of the current page
		String currentTitle = driver.getTitle();
		System.out.println("currentTitle = " + currentTitle);

		// Verify if the user on amazon page

		if (currentTitle.contains("Amazon")) {
			System.out.println("User is validated and is on the Amazon page");
		} else {
			System.out.println("User is not on the Amazon page");
		}

		// refresh the page to get the recent values
		driver.navigate().refresh();
		System.out.println("The page has been refreshed");

		// delete all cookies
		driver.manage().deleteAllCookies();

		//// get he entire page's html source doe -
		// String pageSource = driver.getPageSource();

		// System.out.println("pageSource = " + pageSource);

		driver.quit();

	}

	@Test(groups = { "smoke test" })
	public void WebElementAPITest() {

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
		driver.get("https://facebook.com");

		// capture the email component
		WebElement email = driver.findElement(By.id("email"));

		email.click();
		email.clear();
		email.sendKeys("rakeshsinghrakm@gmail.com");

		// capture the password component
		WebElement password = driver.findElement(By.name("pass"));

		password.click();
		password.clear();
		password.sendKeys("Hakoonamatata");

		// capture the login button
		driver.findElement(By.xpath("//button[@data-testid='royal_login_button']")).click();

		// Capture the text from the error message
		WebElement error = driver.findElement(By.xpath("//div[@id = 'email_container']//div[2]"));

		String currentErrorMessage = error.getText();
		System.out.println("currentErrorMessage = " + currentErrorMessage);

		if (currentErrorMessage.equalsIgnoreCase(expectedErrorMsg)) {
			System.out.println("Expected and Current Error Messages is same ==> Pass");
		} else {
			System.out.println("Incorrect Error Message ==> Fail");
		}

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

		driver.quit();

	}
}
