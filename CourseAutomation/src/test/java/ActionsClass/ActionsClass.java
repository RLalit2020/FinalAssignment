package ActionsClass;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClass {

	static Actions actions;
	static Alert alert;
	static WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		// Set the Browser properties
		System.setProperty("webdriver.chrome.driver", "..\\CourseAutomation\\Drivers\\chromedriver.exe");

		// ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		// Launch the browser
		driver = new ChromeDriver(options);

		// maximize the application
		driver.manage().window().maximize(); // method chaining

		// Implicitly Wait statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Test
	public void ActionsTest() {

		// Hit the application url
		driver.get("https://demoqa.com/menu");

		WebElement menu2 = driver.findElement(By.xpath("//a[text() = 'Main Item 2']"));

		// Action
		actions = new Actions(driver);

		// Hover to the middle of the WebElement to revel sub-menu
		actions.moveToElement(menu2).perform();

		// navigate to another screen
		driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

		// capture the webElement
		WebElement rightClickBtn = driver.findElement(By.xpath("//span[text() = 'right click me']"));

		actions.contextClick(rightClickBtn).perform();

		// capture the context clicked menu and click on it
		driver.findElement(By.xpath("//ul[@class= 'context-menu-list context-menu-root']//li[1]/span[text() = 'Edit']"))
				.click();

		// Accept Javascript alert
		alert = driver.switchTo().alert();
		System.out.println("Edit = " + alert.getText());
		alert.accept();

		// Double Click
		WebElement doubleBtn = driver.findElement(By.xpath("//button[text() = 'Double-Click Me To See Alert']"));

		// add composite methods like method chaining - we need to use build()
		actions.moveToElement(doubleBtn).doubleClick().build().perform();

		// Accept Javascript alert
		alert = driver.switchTo().alert();
		System.out.println("Double Click JA = " + alert.getText());
		alert.accept();

		// navigate to demoQA
		driver.navigate().to("https://demoqa.com/droppable/");

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		// Drag and Drop
		// actions.dragAndDrop(source, target).perform();

		// click and Hold + Move + Release
		actions.clickAndHold(source).moveToElement(target).release().build().perform();

	}

	@Test
	public void KeyBoardOpreationsTest() {

		// Hit the application url
		driver.get("https://facebook.com");

		WebElement editBox = driver.findElement(By.id("email"));

		// Type and press Enter
		editBox.sendKeys("Edureka" + Keys.ENTER);

		// navigate to demoqa
		driver.navigate().to("https://demoqa.com/text-box");

		WebElement name = driver.findElement(By.id("userName"));
		name.sendKeys("Rakesh Singh" + Keys.TAB + "rakesh@edureka.co" + Keys.TAB + "Bengaluru" + Keys.TAB + "Varanasi"
				+ Keys.TAB + Keys.ENTER);
	}

	@Test
	public void KeyBoardCompositeBtnTest() throws Exception {

		// navigate to demoqa
		driver.get("https://demoqa.com/text-box");

		WebElement currentAddress = driver.findElement(By.id("currentAddress"));

		currentAddress.sendKeys("Bengaluru");

		//Give the driver control to actions object
		actions = new Actions(driver);
		
		// Ctrl + A
		actions.keyDown(Keys.CONTROL).sendKeys("A").perform();

		// Ctrl + C
		actions.sendKeys("C").keyUp(Keys.CONTROL).perform();

		Thread.sleep(2000);
		
		// Press Tab
		currentAddress.sendKeys(Keys.TAB);

		// Ctrl +v
		actions.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

	}
	
	@Test
	public void KeyBoardCompositeBtnTest2() throws Exception {
		
		driver.navigate().to("https://facebook.com");

		WebElement email = driver.findElement(By.id("email"));

		WebElement password = driver.findElement(By.id("pass"));
		
		//Give the driver control to actions object
		actions = new Actions(driver);

		actions.sendKeys(email, "rakeshsinghraks@gmail.com");

		actions.moveToElement(email).click().keyDown(Keys.CONTROL).sendKeys("A", "C"); // ctrl + A = Highlights and ctrl + C

		actions.click(password).keyDown(Keys.CONTROL).sendKeys("V"); // ctrl + V = pastes

		actions.keyUp(Keys.CONTROL).build().perform();

		
	}

}
