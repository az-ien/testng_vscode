package com.example;

// import java.awt.Robot;
// import java.awt.Toolkit;
// import java.awt.datatransfer.StringSelection;
// import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class uploadfile {

@Test
public void uploadFileTest() {

// Initialize WebDriver
WebDriver driver = new ChromeDriver();
// Navigate to the file upload page
driver.get("https://testautomationpractice.blogspot.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



//Apporach 1: using send keys, Locate the file input element and upload a file
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
WebElement uploadElement = driver.findElement(By.id("singleFileInput"));
uploadElement.sendKeys("D://cpuz_readme.txt");

// Submit the form
WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
submitButton.click();

// Verify the upload was successful
WebElement successMessage = driver.findElement(By.id("singleFileStatus"));
assert successMessage.isDisplayed();



// //Apporach 2: using robot class to handle file upload dialog
// //This works only when a real OS file chooser opens and you have a desktop environment. If you were running in headless mode or a remote environment without a display, this approach won’t work — in those cases, using sendKeys()
// WebElement element = driver.findElement(By.id("singleFileInput"));
// JavascriptExecutor js = (JavascriptExecutor) driver;
// js.executeScript("arguments[0].scrollIntoView(true);", element);
// js.executeScript("arguments[0].click();", element);


// // Use Robot class to handle the OS file dialog
// // Copy file path to clipboard
// String filePath = "D:\\cpuz_readme.txt";
// StringSelection selection = new StringSelection(filePath);
// Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);


// Robot robot = new Robot();
// // Give dialog time to open
// robot.delay(1500);

// // Paste file path (CTRL + V)
// robot.keyPress(KeyEvent.VK_CONTROL);
// robot.keyPress(KeyEvent.VK_V);
// robot.keyRelease(KeyEvent.VK_V);
// robot.keyRelease(KeyEvent.VK_CONTROL);

// robot.delay(500);

// // Press Enter
// robot.keyPress(KeyEvent.VK_ENTER);
// robot.keyRelease(KeyEvent.VK_ENTER);

// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


// // Submit the form
// WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
// submitButton.click();

// // Verify upload
// WebElement successMessage = driver.findElement(By.id("singleFileStatus"));
// assert successMessage.isDisplayed();


// Close the browser
driver.quit();


}


}
