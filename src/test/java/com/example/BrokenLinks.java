package com.example;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

// link doesn't have any resource on server 
public class BrokenLinks {
 
@Test
public void BrokenLinks(){
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("http://www.deadlinkcity.com/");
List<WebElement> links =driver.findElements(By.tagName("a"));
System.out.println("total number of links:" + links.size());

int brokenlinkcount = 0;

for (WebElement linkelement: links) {
    String hrefattValue = linkelement.getAttribute("href");

    // nothing but to check if link exists or not 
    if(hrefattValue == null || hrefattValue.isEmpty()){
        System.out.println("href attribute value is null or empty. so not possible to check");
        continue; // skip the link that is not found
    }


    try{
    URL linkUrl = new URL(hrefattValue); //sending the link to the server
    HttpURLConnection conn = (HttpURLConnection) linkUrl.openConnection();  // opens connection to the server
    conn.connect();  // connect to the server and send request to the server
    if(conn.getResponseCode()>= 400){
        System.out.println(hrefattValue + " ----> broken link");
        brokenlinkcount++;

    }
    else
    {
        System.out.println(hrefattValue + " ----> Not broken link");
    }
}
catch(Exception e)
{

}

System.out.println(brokenlinkcount + " ----> No. of broken links");



}



















    }
}
