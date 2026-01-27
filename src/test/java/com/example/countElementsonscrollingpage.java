package com.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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


int previousCount=0;
int currentCount=0;

while (true) {

    // Wait to ensure page content is loaded
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    List<WebElement> productsBefore = driver.findElements(
        By.xpath("//a[@class='pc-custom-link jfy-item hp-mod-card-hover']"));

    currentCount = productsBefore.size();

    System.out.println("Current count: " + currentCount + " Previous count: " + previousCount);

    // If no more new products loaded => exit loop
    if (currentCount == previousCount) {
        System.out.println("No more products to load!");
        break;
    }

    previousCount = currentCount;

    List<WebElement> loadMoreButton = driver.findElements(
        By.xpath("//div[contains(text(), 'Load More')]"));

    if (loadMoreButton.size() > 0) {

        WebElement loadMore = loadMoreButton.get(0);

        // Wait until clickable and click
        wait.until(ExpectedConditions.elementToBeClickable(loadMore)).click();

        // Wait for more products to load (count > previous)
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
            By.xpath("//a[@class='pc-custom-link jfy-item hp-mod-card-hover']"),
            previousCount
        ));

    } else {
        System.out.println("Load More button not found!");
        break;
    }
}

System.out.println("Total combined products: " + previousCount);
driver.quit();

} 
} 
