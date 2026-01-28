package com.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

// the xpath here was needed to be picked for the DOM element that conatined the text of the product name so the loop condition could be based on that
// the loop would continue until the product was found
 

public class Findspecificproduct {
@Test
public void Findspecificproduct() {
WebDriver driver =new ChromeDriver ();
driver.get("https://www.libertybooks.com/online-book-bazar-up-to-60");
driver.manage().window().maximize();

Actions actions = new Actions(driver);

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



boolean found = false;
while (!found)
{
    List<WebElement> productsname = driver.findElements(By.xpath("//h2"));
   for (WebElement product : productsname) {
        String text = product.getText().trim();
        System.out.println("Checking: " + text);

        if (text.contains("The Soul Game")) {
            System.out.println("Product Found: " + text);
            found = true;
            break;
        }
    }
WebElement loadMoreButton = driver.findElement(By.xpath("//a[normalize-space()='Next']"));
actions.moveToElement(loadMoreButton).click().perform();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}




driver.quit();
}
}
