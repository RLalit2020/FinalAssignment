package co.edurekatraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FrameLogic_MandatoryAssignment2 {
    public static void main(String[] args) {
        // Set path to ChromeDriver if necessary
		System.setProperty("webdriver.chrome.driver", "..\\CourseAutomation\\Drivers\\chromedriver.exe");

        // 1. Launch the URL and maximize the window
        WebDriver driver = new ChromeDriver();
        driver.get("https://docs.oracle.com/javase/8/docs/api"); // example JavaDocs URL
        System.out.println("Step 1: get to URL 'https://docs.oracle.com/javase/8/docs/api/\')");
        
        driver.manage().window().maximize();
        System.out.println("Step 1: Maximize window");
        
        // 2. Switch focus to the package frame
        driver.switchTo().frame("packageListFrame");
        System.out.println("Step 2:Switch to package List Frame");
        
        // 3. Count the total number of links under packages
        List<WebElement> packageLinks = driver.findElements(By.tagName("a"));
        System.out.println("Step 3: Total package links: " + packageLinks.size());

        // 4. Print all the link names under packages
        System.out.println("Step 4:Print all Package link names:");
        for (WebElement link : packageLinks) {
            System.out.println(link.getText());
        }

        // 5. Count the total number of frames
        System.out.println("switch back to main content");
        System.out.println("Step 5: Count the total number of frames");
        driver.switchTo().defaultContent(); // switch back to main content
        List<WebElement> allFrames = driver.findElements(By.tagName("frame"));
        System.out.println("Total number of frames: " + allFrames.size());

        // 6. Print all link names from every frame
        System.out.println("Step 6:Print All link names in every frame:");
        for (WebElement frame : allFrames) {
            driver.switchTo().frame(frame);
            List<WebElement> links = driver.findElements(By.tagName("a"));
            for (WebElement link : links) {
                System.out.println(link.getText());
            }
            driver.switchTo().defaultContent(); // switch back before going to next frame
        }
       // driver.manage().deleteAllCookies();
       // driver.quit();
    }
}