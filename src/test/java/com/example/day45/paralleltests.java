package com.example.day45;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class paralleltests {
	WebDriver driver;

	@BeforeClass
@org.testng.annotations.Parameters({"browser"})
void setup(String br)   // required parameter, complete depenedence on xml file case independent from case sensitivity
{ 
	br = br.toLowerCase();
	switch(br){
case "chrome": driver = new ChromeDriver(); break;
case "edge": driver = new EdgeDriver(); break;
default: System.out.println("Invalid Browser"); return; // return will exit from the test method and stop
}

driver.get("https://www.google.com/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Test
void testParallel()
{
	System.out.println("Test running on " + Thread.currentThread().getId());
}

@AfterClass
void tearDown()
{
driver.quit();
}

}