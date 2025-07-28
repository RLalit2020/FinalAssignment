package training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseMovementTest {

	static WebDriver driver;

	@Test(groups = { "regression test", "smoke test" })
	public void ActionsTest() {

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

		// Hit the application url
		driver.get("https://www.amazon.in/");

		// maximize the screen
		driver.manage().window().maximize(); // method chaining

		// Click on Electronics using Actions class

		WebElement electronics_Menu = driver.findElement(By.xpath("//a[normalize-space()='Electronics']"));

		// Create an object of Actions class
		Actions act = new Actions(driver);

		act.moveToElement(electronics_Menu).click().perform();

		driver.quit();

	}

	@Test(groups = { "regression test", "smoke test" })
	public void DragAndDropTest() throws Exception {

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

		// Hit the application url
		driver.get("https://demo.guru99.com/test/drag_drop.html");

		// maximize the screen
		driver.manage().window().maximize(); // method chaining

		// Capture the element from source location to drag
		WebElement source1 = driver.findElement(By.xpath("//a[normalize-space()='SALES']"));

		WebElement target1 = driver.findElement(By.id("loan"));

		// Drag And Drop
		Actions act = new Actions(driver);

		act.dragAndDrop(source1, target1).build().perform();

		Thread.sleep(5000);

		driver.quit();

	}

	@Test(groups = { "regression test" })
	public void KeysClassTest() {

		// Set the browser properties
		System.setProperty("webdriver.chrome.driver", "..\\VitAutomation\\Drivers\\chromedriver.exe");

		// ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		// Launch the browser
		WebDriver driver = new ChromeDriver(options);

		// maximize the application
		driver.manage().window().maximize(); // method chaining

		// Implicitly Wait statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Hit the application url
		driver.get("https://www.facebook.com/");

		// maximize the screen
		driver.manage().window().maximize(); // method chaining

		// capture the email WebElement
		WebElement email = driver.findElement(By.id("email"));

		// capture the password WebElement
		WebElement password = driver.findElement(By.name("pass"));

		// enter email id in the email box
		email.sendKeys("rakeshsinghraks@gmail.com");

		// Create an object of Actions class
		Actions act = new Actions(driver);

		// Move to the email WebElement, click, press CONTROL button and send press
		// CONTROL A
		act.moveToElement(email).click().keyDown(Keys.CONTROL).sendKeys("A", "C"); // select & Copy

		act.click(password).keyDown(Keys.CONTROL).sendKeys("V"); // paste

		act.keyUp(Keys.CONTROL).build().perform();

		driver.quit();

	}
}
