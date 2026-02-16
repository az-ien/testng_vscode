package com.example.Threadsafteryconcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


// Only in parallel test execution there is an execution flakyness of tests, which causes one test to run and the other to fail, 
// to avoid this we can use thread local variable, which is a variable that is local to the thread, 
// and each thread has its own copy of the variable, so that each thread can access its own copy of the variable without any interference from other threads. 
// from inside the test when the driver is created it is sent to the set method which will set the value of the variable for the current thread, 
// and the get method will return the value of the variable for the current thread.
// this will break the dependency between the tests and will allow them to run in parallel without any interference from each other,
// and this will also allow us to run the tests in parallel without any interference from each other,


public class threadsafetydrivertest {


    private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
    WebDriver driver;

    public void setDriver(WebDriver driver) {
        tdriver.set(driver);
    }

    public WebDriver getdriver() {
        driver = tdriver.get();
        return driver;
    }


// in the test methods we will create the driver and then we will set the driver for the current thread using the set method,
// as now we are using the set and get methods for the driver so we remove the driver from the test methods 
// and we will use the getdriver method to get the driver for the current thread, 
// so that each thread can access its own copy of the driver without any interference from other threads, 
// and this will allow us to run the tests in parallel without any interference from each other,



@Test
public void test1()
{
ChromeOptions options = new ChromeOptions();
options.addArguments("--headless=new");
options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");

    driver =new ChromeDriver(options);
   //--------------------------------------------------------------------
    setDriver(driver);
    getdriver().get("https://www.google.com/");
   //--------------------------------------------------------------------
    //driver.get("https://www.google.com/");
    System.out.println("Title of the page is "+driver.getTitle());
    //driver.quit();    
    getdriver().quit();

}


@Test
public void test2()
{
ChromeOptions options = new ChromeOptions();
options.addArguments("--headless=new");
options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");

    driver =new ChromeDriver(options);
    //--------------------------------------------------------------------
    setDriver(driver);
    getdriver().get("https://www.bing.com/");
   //--------------------------------------------------------------------
   //driver.get("https://www.bing.com/");
    System.out.println("Title of the page is "+driver.getTitle());
    //driver.quit();
    getdriver().quit();

}


// important to remove the driver from the thread local variable after the test is done,
//  otherwise it will cause memory leak and will cause the tests to fail,

@AfterClass
public void tearDown()
{
    tdriver.remove();
}



}   
