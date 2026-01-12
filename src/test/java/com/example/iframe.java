package com.example;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class iframe {


@Test
public void iframehandling()
{
WebDriver driver= new ChromeDriver();
driver.get("https://practice-automation.com/iframes/");
driver.manage().window().maximize();

WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));


//Approach 1
// WebElement frameElemnet = driver.findElement(By.xpath("//iframe[@id='singleframe']"));
// driver.switchTo().frame(frameElemnet);
// driver.findElement(By.xpath("//input[type='text']")).sendKeys("testing");


//Approach2
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("//iframe[@id='iframe-1']"));
driver.findElement(By.xpath("//a[@class='getStarted_Sjon']")).click();

}    
}
