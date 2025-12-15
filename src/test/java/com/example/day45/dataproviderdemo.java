package com.example.day45;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class dataproviderdemo {


     WebDriver driver;

// execute this only once
@BeforeClass
void setup()
{
driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


}



@Test
void testLogin()
{
    driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
    driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("email");
    driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("pwd");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}





@AfterClass
void tearDown()
{
driver.quit();
}


}
