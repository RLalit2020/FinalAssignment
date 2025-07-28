package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import generic.MSExcelAutomation;
import generic.WebActions;

public class DemoQA_FormPage {

	@FindBy(id = "firstName")
	private WebElement firstName;

	@FindBy(id = "lastName")
	private WebElement lastName;

	@FindBy(css = "input#userEmail")
	private WebElement Email;

	@FindBy(xpath = "//*[@id=\"userNumber\"]")
	private WebElement Mobile;

	@FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")
	private WebElement Gender;

	@FindBy(css = "button#submit")
	public WebElement submitButton;
	
//	@FindBy(xpath = "//*[@id=\"example-modal-sizes-title-lg\"]")
	@FindBy(id = "example-modal-sizes-title-lg")
	private WebElement ModalPopup;
	String expectedMessage = "Thanks for submitting the form";
	
	/*
	 * // State dropdown (ID)
	 * @FindBy(id = "state") public WebElement stateDropdown;
	 * 
	 * // City dropdown (ID)
	 * @FindBy(id = "city") public WebElement cityDropdown;
	 */
	
	// page specific Reusable method
	public void EnterForm(WebDriver driver) throws Exception {

		if (submitButton.isDisplayed()) {
			System.out.println(" Opened the DemoQA website ");
			System.out.println("REading Data");
			String FName = MSExcelAutomation.readExcelData("Sheet1", 1, 6);
			String LName = MSExcelAutomation.readExcelData("Sheet1", 1, 7);
			String Temail = MSExcelAutomation.readExcelData("Sheet1", 1, 8);
			String Tmobile = MSExcelAutomation.readExcelData("Sheet1", 1, 15);
            //Enter the values of the fields in the form 
			firstName.sendKeys(FName);
			System.out.println(FName + "--Entered first Name");

			lastName.sendKeys(LName);
			System.out.println(LName + "--Entered Last Name");


			Email.sendKeys(Temail);
			System.out.println(Temail + "--Entered Email ");


			Mobile.sendKeys(Tmobile);
			System.out.println(Tmobile + "--Entered mobile no.");


			Gender.click();
			System.out.println("--Gender :Clicked Male Radiobutton");

			// click on submit button
			submitButton.submit();
			System.out.println("Clicked on Submit Button");
			// Implicitly Wait statement
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Thread.sleep(1000);//just to visually see the page 
			
			if (ModalPopup.isDisplayed()){
				System.out.println("ModalPopup is Displayed:: with Title ::"+ModalPopup.getText());
				WebActions.MessageAssertion(driver, ModalPopup, expectedMessage);
				} else  System.out.println("ModalPopup is not Displayed");
		} else
			System.out.println("DemoQA website - Not opened ");
		
	}

}
