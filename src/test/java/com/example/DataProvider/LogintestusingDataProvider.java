package com.example.DataProvider;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogintestusingDataProvider {

    @Test(dataProvider = "LoginData")
    public void loginwithdataprovider(String email, String password) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/login");

        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        try {
            boolean loginStatus = driver.findElement(By.linkText("Log out")).isDisplayed();
            System.out.println("Login status: " + loginStatus);
        } catch (Exception e) {
            System.out.println("Login failed.");
        }

        driver.quit();
    }


//parallel will run tests simultaneously so we need to run in sets of 2-5 otherwise system might hang due to memory allocation
//so thread count will be managed in the .xml and manange the threads accordingly 
//if only the 1st two inputs are need to be run then add a parameter  next to parallel that is indices ={0,1}, this will run only the first two sets of data and rest will be ignored

    @DataProvider(parallel = true)
    public Object[][] LoginData() {
        return new Object[][] {
            {"john.doe111@example.com", "test123"},
            {"john.doe223@example.com", "test123"},
            {"laura.smith445@example.com","test123"},
            {"john.doe111@example.com", "test123"},
            {"john.doe223@example.com", "test123"},
            {"laura.smith445@example.com","test123"}
        };
    }
}

