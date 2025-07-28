package WindowHandling;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AlertTest {

	static Alert alert;
	static WebDriver driver;

	@Test(groups = { "smoke test" })
	public void AlertTests() throws Exception {
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
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");

		// capture Btn "Click for js Confirm"
		WebElement ClickForJSConfirm = driver.findElement(By.xpath("//button[text() = 'Click for JS Confirm']"));
		ClickForJSConfirm.click();

		// shift focus of selenium from HTML to javaScript Alerts
		alert = driver.switchTo().alert();

		Thread.sleep(5000);

		// Capture the message from the alert
		String currentAlertMessage = alert.getText();
		System.out.println("currentAlertMessage = " + currentAlertMessage);

		// accept the alert
		// alert.accept();
		alert.dismiss();

		WebElement result = driver.findElement(By.id("result"));

		System.out.println("result = " + result.getText());

		// capture btn "click on JS Prompt"
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

		// shift focus of selenium from HTML to javaScript Alerts
		alert = driver.switchTo().alert();

		alert.sendKeys("Hakoonamatata");
		alert.accept();
		
		String outputText = result.getText();

		System.out.println("result = " + outputText);
		
		String netEnteredValue = outputText.substring(13);
		
		System.out.println(netEnteredValue);
		
		
		driver.quit();

	}
}
