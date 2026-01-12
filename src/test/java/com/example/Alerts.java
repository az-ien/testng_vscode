package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Alerts {

  @Test
public void alerthandlig(){
WebDriver driver= new ChromeDriver();
driver.get("https://testautomationpractice.blogspot.com/");
driver.manage().window().maximize();
driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//appraoch 1
// Alert alert =driver.switchTo().alert();
// alert.accept();


//approach 2
// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
// Alert alert = wait.until(ExpectedConditions.alertIsPresent());
// alert.accept();

//Approach 3
JavascriptExecutor js =(JavascriptExecutor)driver;
try {
    js.executeScript("window.alert=function{}");
} catch (Exception e) {
}
  }
}
