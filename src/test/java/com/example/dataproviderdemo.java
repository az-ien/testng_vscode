package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataproviderdemo {


     WebDriver driver;

// execute this only once
@BeforeClass
void setup()
{
driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


}



@Test(dataProvider="dp")  // dataprovider passed to the test with the name 
void testLogin(String email, String pwd) // passing the parameters in the format for each of the data
{
    driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
    driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
    driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}





@AfterClass
void tearDown()
{
driver.quit();
}


@DataProvider(name="dp", indices={3,3})  // some name given, indices will send the 4th email and password 
Object[][] loginData()
 {
    // for excel make one loop and get data from excel data and return it to method only
// excel is easily formatted data in excel but can be from other file types as well 
// object is like json object so that there can be multiple data types returned not specified by any one datatype

    Object data[][] = {   
        {"abc@gmail.com","test123"},
        {"xyz@gmail.com","test012"},
        {"john@gmail.com","test@123"},
       {"pavano123@gmail.com","test@123"},
         {"johncanedy@gmail.com","test"},
     };
    
     return data; //return is  String[][] so method should be String[][]

 }




// String[][] loginData()
// {

//     String data[][] = {   
//         {"abc@gmail.com","test123"},
//         {"xyz@gmail.com","test012"},
//         {"john@gmail.com","test@123"},
//         {"pavano123@gmail.com","test@123"},
//         {"johncanedy@gmail.com","test"},
//     };
    
//     return data; //return is  String[][] so method should be String[][]

// }





















}
