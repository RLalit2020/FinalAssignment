package generic;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebActions {

	WebDriver driver = null;
	Actions actions = null;
	WebDriverWait wait = null;

	// Constructor to initialize
	public WebActions(WebDriver driver) {
		
		this.driver = driver;
		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.globalWait));
	}
	
		public static void MessageAssertion(WebDriver driver, WebElement messageElement, String expectedMessage) {
			// Assertion
			System.out.println("Inside MessageAssertion function: To verify whether the expected message is displayed");
//			WebElement ele = driver.findElement(messageElement);
			String actualMessage = messageElement.getText();
			Assert.assertEquals(actualMessage, expectedMessage, "//FAIL:: Expectedmsg: "+expectedMessage+" is NOT displayed//"
					+ " instead, - "+actualMessage+ " is displayed");
			System.out.println("PASS::Actual Message: '"+actualMessage+"' is equal to Expected Message: '"+actualMessage+"'");
		}

	
	

	// Click on certain webElement
	public void clickOnWebElement(By locator) {

		if (locator != null && driver != null) {
			WebElement element = driver.findElement(locator);

			actions.scrollToElement(element);

			if (element.isDisplayed() && element.isEnabled()) {
				try {
					// WebElement API method
					element.click(); // risky code
				} catch (NoSuchElementException e) {
					System.out.println("Element not visible");
				} catch (ElementNotInteractableException e) {
					actions.moveToElement(element).click().build().perform();
				}
			}
		}
	}

	// This method will write
	public void enterText(By locator, String text) {

		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.clear();
			element.click();
			element.sendKeys(text);

		} catch (Exception e) {
			System.out.println("Click Failed: " + locator + " - " + e.getMessage());
		}
	}

	public void selectByVisisbleText(By locator, String visibleText) {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			if (element.getTagName().equalsIgnoreCase("select")) {
				Select select = new Select(element);
				select.selectByVisibleText(visibleText);
			}

		} catch (NoSuchElementException e) {

			System.out.println("SelectByVisibleText failed: " + locator + " - " + e.getMessage());
		}
	}

//wait utility

	// implicitly wait statement
	public static void waitForPageToLoad(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForVisibility(By locator) {

		try {
			if (locator != null)
				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("visibilityOfElementLocated failed: " + locator + " - " + e.getMessage());
		}
	}

	public void waitForClickAbility(By locator) {

		try {
			if (locator != null)
				wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			System.out.println("elementToBeClickable failed: " + locator + " - " + e.getMessage());
		}
	}

	// JavaScipt Utility to scroll to the WebElement
	public void scrollToElement(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {

			System.out.println("Scroll to the WebElement failed: " + locator + " - " + e.getMessage());
		}

	}

	// JavaScript Function
	public void jsClick(By locator) {
		try {
			if (locator != null) {

				WebElement ele = driver.findElement(locator);
				wait.until(ExpectedConditions.elementToBeClickable(ele));

				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("arguments[0].click();", ele);
			}
		} catch (Exception e) {

		}

	}
	public void DoubleclickButton(By locator) {
		try {
			if (locator != null) {

				WebElement ele = driver.findElement(locator);
				wait.until(ExpectedConditions.elementToBeClickable(ele));

				// Double click
				Actions actions = new Actions(driver);
				WebElement doubleClickBtn = driver.findElement(locator);
				actions.doubleClick(doubleClickBtn).perform();
			}
		} catch (Exception e) {

		}

	}
	

	
	

}
