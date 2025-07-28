package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import generic.Utils;
import generic.WebActions;

public class DemoQA_DoubleClickPage {

	// double click button
	@FindBy(id = "doubleClickBtn")
	private WebElement doubleClickBtn;

	@FindBy(id = "doubleClickMessage")
	private WebElement messageElement;
	String expectedMessage = "You have done a double click";
	String Filename = "DemoQA_DoubleClickPage";

//reusable functions	
	public void ButtonDClick(WebDriver driver) {

		WebActions.waitForPageToLoad(driver);
		if (doubleClickBtn.isDisplayed() && doubleClickBtn.isEnabled()) {
			// Double click on the 'Double Click Me' Button
			Actions actions = new Actions(driver);
			actions.doubleClick(doubleClickBtn).perform();
			System.out.println("Double clicked on the 'Double Click Me' Button");
			//MessageAssertion function: To verify whether the expected message is displayed
			WebActions.MessageAssertion(driver, messageElement, expectedMessage);
		}
	}

}
