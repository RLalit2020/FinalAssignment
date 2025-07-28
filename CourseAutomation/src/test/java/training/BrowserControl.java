package training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserControl {

	static String exepectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

	public static void main(String[] args) throws InterruptedException {

		// Set the Browser properties
		System.setProperty("webdriver.chrome.driver", "..\\CourseAutomation\\Drivers\\chromedriver.exe");

		// launch the Browser - light browser without any plugin, history, cookies
		WebDriver driver = new ChromeDriver(); // Upcasting

		// Hit the URL of the application
		driver.get("https://www.irctc.co.in/nget/train-search");

		// maximize the application
		driver.manage().window().maximize(); //method chaining

		// naviagte to Aamzon.in
		driver.navigate().to("https://amazon.in");
		Thread.sleep(50000);//Java wait satement
		System.out.println("Navigated to the Amazon web page");

		// navigate back -
		driver.navigate().back();
		System.out.println("User is on which screen");

		String currentUrl = driver.getCurrentUrl();

		//verification
		if (currentUrl.contains("train-search")) {
			System.out.println("User navigated back to IRCTC screen == > pass");
			driver.navigate().forward();
		}

		// get the title of the current page and compare if it is Amazon
		String currentTitle = driver.getTitle();

		//verification
		if (currentTitle.equalsIgnoreCase(exepectedTitle)) {
			System.out.println("User has successfully navigated forward to Amazon ==> pass");
		}

		// refresh
		driver.navigate().refresh();
		System.out.println("The page has been refreshed");

		// delete the cookies
		driver.manage().deleteAllCookies();

		// get the html source code
		String pagesource = driver.getPageSource();
		System.out.println("The page source "+pagesource);
		
		//tear down process - close the entire browser
		driver.quit();
		
	}

}
