package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Choose / Select the which browser to invoke depending upon the value in Constants.java
public class Drivers {

	public static WebDriver driver = null;

	public static WebDriver getBrowser() {

		if (Constants.browser.equalsIgnoreCase("chrome")) {
			// Set the Browser properties
			//System.setProperty("webdriver.chrome.driver", "..\\TCS_BDD_Automation\\Drivers\\chromedriver.exe");

			// ChromeOptions
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			options.addArguments("start-maximized");
			/*options.addArguments("--incognito");*/

			// Launch the browser
			driver = new ChromeDriver(options);

			// maximize the application
			driver.manage().window().maximize(); // method chaining

			// Implicitly Wait statement
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			//hit the url also 

		} else if (Constants.browser.equalsIgnoreCase("firefox")) {

			// Set the Browser properties
			System.setProperty("webdriver.firefox.driver", "..\\TCS_BDD_Automation\\Drivers\\geckodriver.exe");

			// Launch the browser
			driver = new FirefoxDriver();

			// maximize the application
			driver.manage().window().maximize(); // method chaining

			// Implicitly Wait statement
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		} else if (Constants.browser.equalsIgnoreCase("edge")) {

			// Set the Browser properties
			System.setProperty("webdriver.edge.driver", "..\\TCS_BDD_Automation\\Drivers\\edgedriver.exe");

			// Launch the browser
			driver = new EdgeDriver();

			// maximize the application
			driver.manage().window().maximize(); // method chaining

			// Implicitly Wait statement
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		}

		return driver;
	}

}
