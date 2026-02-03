package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

// ### **TL;DR: AJAX call**

// **AJAX (Asynchronous JavaScript and XML)** is a way for a webpage to **talk to the server in the background** without reloading the page.

// * ✅ Sends/receives data asynchronously
// * ✅ Can use JSON, XML, or plain text
// * ✅ Updates part of a page dynamically

// **Think:** “Click a button → only a section updates, page doesn’t reload.”

// **Example:** Loading more tweets on Twitter as you scroll.


public class handlingAJAXCalls {

@Test
public void handlingAJAX() {

WebDriver driver =new ChromeDriver();
driver.get("https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html");
driver.manage().window().maximize();    

driver.findElement(By.id("loadContent")).click();


WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));   
WebElement LoadedElement =mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ajaxContent']/h2")));

LoadedElement.getText();
System.out.println("Loaded Text is: "+LoadedElement.getText());


driver.quit();


}
}
