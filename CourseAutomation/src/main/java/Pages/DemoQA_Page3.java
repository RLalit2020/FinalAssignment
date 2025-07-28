package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DemoQA_Page3 {

	// OldSelectMenu
	@FindBy(xpath = "//*[@id=\"oldSelectMenu\"]")
	private WebElement OldSelectMenu;

	@FindBy(xpath = "//*[@id=\"selectMenuContainer\"]/h1")
	private WebElement selectMenuContainer;

//reusable functions	
	public void OldSelectMenu(WebDriver driver, String Color) {
// To Check whether the OldSelectMenu.isDisplayed and Enabled
		if (OldSelectMenu.isDisplayed() && OldSelectMenu.isEnabled()) {
			// Scroll to the "Old Style Select Menu"
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", OldSelectMenu);

			// Select "color" from the dropdown
			Select dropdown = new Select(OldSelectMenu);
			dropdown.selectByVisibleText(Color);
			System.out.println("Selecting '"+Color+"' from the OldSelectMenu dropdown");
			// Optional: Verify selection
			WebElement selectedOption = dropdown.getFirstSelectedOption();
		    if (Color.equals(selectedOption.getText())) {
			    System.out.println("Verifying selection :PASS:: " + selectedOption.getText()+" from the OldSelectMenu dropdown is selected as expected");
			}else System.out.println("Verifying selection :FAIL:: '" + selectedOption.getText()+"' is displayed instead of '"+Color+"' from the OldSelectMenu dropdown");

		}
	}

}
