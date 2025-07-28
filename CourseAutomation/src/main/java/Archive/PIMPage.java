package Archive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.WebActions;

public class PIMPage {

	
	@FindBy(xpath = "//a[contains(@href, 'pim/viewPimModule')]")
	private WebElement PIMMenuBtn;
	
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
	private WebElement AddEmpBtn;
	
	@FindBy(xpath = "//label[text() = 'Employee Name']/parent::div/following-sibling::div//input")
	private WebElement EmpNameInput;
	
	@FindBy(xpath = "//label[text() = 'Employee Id']/parent::div/following-sibling::div//input")
	private WebElement EmpId;
	
	
	@FindBy(xpath = "//label[text() = 'Employment Status']/parent::div/following-sibling::div//div[text() = '-- Select --' ]")
	private WebElement EmpStatusDropDown;
	///////////////////////////////////////////////////////////////////////////////
	
	
	@FindBy(xpath = "//h6[text() = 'Add Employee']")
	private WebElement addEmpText;
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	private WebElement EmpFirstName;
	
	@FindBy(xpath = "//input[@placeholder='Middle Name']")
	private WebElement EmpMiddleName;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	private WebElement EmplastName;
	
	@FindBy(xpath = "//label[text() = 'Employee Id']/parent::div/following-sibling::div//input")
	private WebElement EmpIdEmployeeSection;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement EmpSaveBtn;
	
	
	
	public void addEmployee(WebDriver driver) {
		

		generic.WebActions.waitForPageToLoad(driver);
		if(PIMMenuBtn.isDisplayed() && PIMMenuBtn.isEnabled()) {
			PIMMenuBtn.click();
			
			if(AddEmpBtn.isDisplayed()) {
				AddEmpBtn.click();
			}
			WebActions.waitForPageToLoad(driver);
			//Verify if Add Employee button is displayed or not
			
			EmpFirstName.sendKeys("Rakesh");
			EmpMiddleName.sendKeys("Kumar");
			EmplastName.sendKeys("Singh");
			
			EmpId.sendKeys("109");
			
			//click on save button
			EmpSaveBtn.click();
		}
	}
}
