package Archive;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.MSExcelAutomation;

public class OrangeHrmLoginPage {

	@FindBy(name = "username")
	private WebElement usernameEdit;

	@FindBy(css = "input[type = 'password']")
	private WebElement passwordEdit;

	@FindBy(tagName = "button")
	private WebElement submitBtn;

	// page specific Reusable method
	public void login() throws Exception {

		if (submitBtn.isDisplayed()) {
			String username = MSExcelAutomation.readExcelData("Sheet1", 1, 3);
			String password = MSExcelAutomation.readExcelData("Sheet1", 1, 4);
	        System.out.println(username+": UserName and Password is "+password);
	        System.out.println("Inside LOgin ");
			usernameEdit.sendKeys(username);

			passwordEdit.sendKeys(password);

			// click on submit button
			submitBtn.click();
		}
	}

	public void forgottenPassword() {

	}

	public void uniqueResitration() {

	}
	
	

}
