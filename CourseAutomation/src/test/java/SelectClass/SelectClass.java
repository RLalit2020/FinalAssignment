package SelectClass;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectClass {

	@Test
	public void selectClass() throws Exception {
		// Set the Browser properties
		System.setProperty("webdriver.chrome.driver", "..\\CourseAutomation\\Drivers\\chromedriver.exe");

		// ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		WebDriver driver = new ChromeDriver(options);

		// Step 3: maximize the browser
		driver.manage().window().maximize();
		System.out.println("The Window has been maximized");

		// Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Step 4: Open Facebook Url
		driver.get("https://facebook.com");

		// click on "Create New Account"
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

		WebElement signUpBtn = driver.findElement(By.name("websubmit"));

		if (signUpBtn.isDisplayed()) {
			System.out.println("SignUp Screen has been displayed");
		} else {
			System.out.println("SignUp Screen has not been displayed yet");
		}

		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));

		// Use select class to perform any action over Select HTML type dropdown
		Select s1 = new Select(day);
		s1.selectByValue("3");

		Select s2 = new Select(month);
		s2.selectByVisibleText("Jan");

		Select s3 = new Select(year);
		s3.selectByVisibleText("1991");

		// How to get all the option from the dropdown and print
		List<WebElement> list = s2.getOptions();

		for (int i = 0; i < list.size(); i++) {
			WebElement element = list.get(i);

			System.out.println("Month = " + element.getText());
		}

		// How to get all the link of the web and print it
		driver.navigate().to("https://amazon.in");

		Thread.sleep(5000);
		
		List<WebElement> links = driver.findElements(By.xpath("//a"));

		// how many links are there -
		System.out.println("Total links are = " + links.size());

		for (int i = 0; i < links.size(); i++) {
			WebElement eachLinkElement = links.get(i);
			System.out.println(eachLinkElement.getText());
		}

	}

}
