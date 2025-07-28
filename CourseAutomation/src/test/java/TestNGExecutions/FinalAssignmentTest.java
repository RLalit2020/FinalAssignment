package TestNGExecutions;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import Pages.DemoQA_DoubleClickPage;
import Pages.DemoQA_FormPage;
import Pages.DemoQA_Page3;
import generic.Constants;
import generic.Drivers;
import generic.Utils;

public class FinalAssignmentTest {

	static WebDriver driver = null;

	@Test(priority = 1)
	public void TC_DEMOQA_001() throws Exception {
		String Filename="TC_DEMOQA_001";
		System.out.println("==========Executing TC_DEMOQA_001==============");
		// Calling generic reusable function to fetch the browser
		driver = Drivers.getBrowser();
		// Calling generic reusable function to open the URL
		driver.get(Constants.TC1_Url);
		System.out.println("Opening the url:- "+Constants.TC1_Url);
		// Calling generic reusable function to wait for the page to load
		generic.WebActions.waitForPageToLoad(driver);
		//Creating an object of the DemoQA_Form.class using PageFactory
		DemoQA_FormPage page = PageFactory.initElements(driver, DemoQA_FormPage.class);

		// To check whether the Page has loaded before starting to enter the details in the form
		if (driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/h1")).isDisplayed()) {
			//Calling the reusable function from DemoQA_Form (Pages)  to enter the details in the form
			page.EnterForm(driver);
			Thread.sleep(1000);// Hard wait just to be able to see the page before it is closed
			//Calling generic utility function to take screenshots
			Utils.takeScreenShot(driver, Filename);
			//deleting all cookies
			driver.manage().deleteAllCookies();
			//Closing the browser
			driver.quit();
			System.out.println("Closing the Chrome Browser");
		} else
			System.out.println("Demo QA Form not opened");
	}

	@Test(priority = 2)
	public void TC_DEMOQA_002() throws Exception {
		System.out.println("==========Executing TC_DEMOQA_002=============");
		// Calling generic reusable function to fetch the browser
		driver = Drivers.getBrowser();
		System.out.println("Opening the Chrome Browser");
		// Calling generic reusable function to open the URL
		driver.get(Constants.TC2_Url);
		System.out.println("Opening the url:- "+Constants.TC2_Url);
		// Calling generic reusable function to wait for the page to load
		generic.WebActions.waitForPageToLoad(driver);
		System.out.println("waiting For Page To Load");
		Thread.sleep(1000); //added sleep just to make sure we can see the browser visually
		//Creating an object of the DemoQA_DoubleClick.class using PageFactory
		DemoQA_DoubleClickPage ButtonsPage = PageFactory.initElements(driver, DemoQA_DoubleClickPage.class);
		// To check whether the expected Page is displayed before starting the test
		if (driver.findElement(By.xpath("//h1[text()='Buttons']")).isDisplayed()) {
			System.out.println("Buttons Page is  opened");
			// Calling reusable function from DemoQA_DoubleClick (Pages) to double click on the button
			ButtonsPage.ButtonDClick(driver); 
			//Calling generic utility function to take screenshots
			Utils.takeScreenShot(driver, "TC_DEMOQA_002");
			//deleting all cookies
			driver.manage().deleteAllCookies();
			Thread.sleep(1000);// Hard wait just to be able to see the page before it is closed
			//Closing the browser
			driver.quit();
			System.out.println("Closing the Chrome Browser");
		} else
			System.out.println("Buttons Page is   not opened");
	}
	@Test(priority = 3)
	public void TC_DEMOQA_003() throws Exception {
		System.out.println("==========Executing TC_DEMOQA_003=============");
		// Calling generic reusable function to fetch the browser
		driver = Drivers.getBrowser();
		System.out.println("Opening the Chrome Browser");
		//Creating an object of the DemoQA_Page3.class using PageFactory
		DemoQA_Page3 SelectfromMenu = PageFactory.initElements(driver, DemoQA_Page3.class);
		// Calling generic reusable function to open the URL
		driver.get(Constants.TC3_Url);
		System.out.println("Opening the url:- "+Constants.TC3_Url);
		// Calling generic reusable function to wait for the page to load
		generic.WebActions.waitForPageToLoad(driver);
		System.out.println("waiting For Page To Load");
		// To check whether the expected Page is displayed before starting the test
		if (driver.findElement(By.xpath("//*[@id=\"selectMenuContainer\"]/h1")).isDisplayed()) {
			System.out.println("Select Menu Page is opened");
			//Calling reusable SelectfromMenu function from DemoQA_Page3 : To Select the color
			SelectfromMenu.OldSelectMenu(driver, "Blue");
			Thread.sleep(1000);// Hard wait just to be able to see the page before it is closed
			//Calling generic utility function to take screenshots
			Utils.takeScreenShot(driver, "TC_DEMOQA_003");
			//deleting all cookies
			driver.manage().deleteAllCookies();
			//Closing the browser
			driver.quit();
			System.out.println("Closing the Chrome Browser");
		} else
			System.out.println("Select Menu Page is NOT opened");
	}

}
