package com.example;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SampleTest {




@Test
     public void Launchgoogle () {
        // Set ChromeDriver path (download from https://chromedriver.chromium.org/downloads), need to place a webdriver here
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://www.google.com");

        // Print page title
        Assert.assertEquals(driver.getTitle(), 5, "Sum should be google chrome");
        System.out.println("Page title is: " + driver.getTitle());

        // Close browser
        driver.quit();
    }
}

    

