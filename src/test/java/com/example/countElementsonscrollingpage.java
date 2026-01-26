package com.example;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class countElementsonscrollingpage {


@Test
public void  countElementsonscrollingpage() {
WebDriver driver =new ChromeDriver ();
driver.get("https://www.daraz.pk/");
driver.manage().window().maximize();

// Firstly JS scroll was not working so actions class is used to scroll down to the bottom of the page
// A list was made first and already displayed elements were added to it
// we need the button multiple times and the if condition is depenedt on the buttons visisibility. the only variation was that the button would be displayed multiple times on the same DOM(this DOM was already laoded) so the button could be used as a list 
//and the buttons first index was used to click on it (this was only used becuase the if condition was dependent on the button's visibility once)
// then a while loop was used to pick more products until the load more button is not visible anymore
// the elements after the while loop were added to the list and finally the size of the list was printed



driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
List<WebElement> productsBefore = driver.findElements(By.xpath("//a[@class='pc-custom-link jfy-item hp-mod-card-hover']")); 
System.out.println("list of products on the page: " + productsBefore.size());
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
List<WebElement> allProducts = new ArrayList<>(productsBefore);

while (true) {
List <WebElement> loadMoreButton = driver.findElements(By.xpath("//div[contains(text(), 'Load More')]"));

if (loadMoreButton.size() > 0) {

WebElement loadMoreButtons = loadMoreButton.get(0);
Actions actions = new Actions(driver);
actions.moveToElement(loadMoreButtons).click().perform();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

List<WebElement> productsAfter = driver.findElements(By.xpath("//a[@class='pc-custom-link jfy-item hp-mod-card-hover']")); 
//System.out.println("list of products on the page: " + productsAfter.size());
allProducts.addAll(productsAfter);
} 
    
else 
{
break;
}

}

System.out.println("Total combined products: " + allProducts.size());

driver.quit();
}
}
