package com.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class dynamictables {


@Test
public void dynamictables()
{
WebDriver driver= new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://practice.expandtesting.com/dynamic-table");
driver.manage().window().maximize();
//get the complete table as a list of elements this will resolve all element getting issues
List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
System.out.println("Number of rows:" + rows.size());


////table[@class='table table-striped']/tbody/tr[" + r + "]/td[1]
// for(int r=0; r<rows.size();r++) {
//      WebElement browsercolumn = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+ r +"]/td[1]"));
WebElement browsercolumn = driver.findElement(By.xpath("//td[text()='Chrome']"));
    System.out.println(browsercolumn.getText());
    if(browsercolumn.getText().contains("Chrome"))
    {

       WebElement cpuload = driver.findElement(By.xpath("//td[text()='Chrome']/following-sibling::*[contains(text(), '%')]"));
        String cpu=cpuload.getText();
       System.out.println(cpu);
        String value = driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();
        System.out.println(value);

        if(value.contains(cpu))
        {
            System.out.println("Cpu load of chrome process is equal");
        }
        else
        {
            System.out.println("Cpu load of chrome process is NOT equal");
        }

    }
//  break;

//  }

}
}
