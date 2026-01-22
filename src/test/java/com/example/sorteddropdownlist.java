package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class sorteddropdownlist {

@Test
public void sorteddropdownlist() {
    WebDriver driver =new ChromeDriver();
    driver.get("https://testautomationpractice.blogspot.com/");
    driver.manage().window().maximize();
    //select is used because it was in the DOM of the web elemnet
    Select dropDown = new Select(driver.findElement(By.id("colors")));
    
    //finding duplicate elements in dropdown list
    List<WebElement>duplicateoptions = dropDown.getOptions();
    // for(int i=0; i<duplicateoptions.size(); i++) {
    //     for(int j=i+1; j<duplicateoptions.size(); j++) {
    //         if(duplicateoptions.get(i).getText().equals(duplicateoptions.get(j).getText())) {
    //             System.out.println("Duplicate: "+ duplicateoptions.get(i).getText());
    //         }
    //     }
    // }

    //--------------------------------if loops are not used-----------------------------
    //set only stores unique values as Hash set does not allow duplicate values
    Set<String> seen = new HashSet<>(); 
for (WebElement option : duplicateoptions) {
    String text = option.getText();
     // if ! is removed then it adds in the list  and returns true.
      // if ! is added then it does not add in the list  and returns true.
    if (!seen.add(text)) { 
        System.out.println("Duplicate: " + text);
    }
    else {
        System.out.println("Unique: " + text);
    }
}



    //Storing dropdown values in arraylist and comparing both lists for sorting 
    ArrayList originallList = new ArrayList<>();
    ArrayList templList = new ArrayList<>();

    List<WebElement>options = dropDown.getOptions();
    for(WebElement option: options) {
        originallList.add(option.getText());
        templList.add(option.getText());

        }

        System.out.println("Before sorting....");
        System.out.println("original List...."+ originallList);
        System.out.println("temporary List...."+ templList);

        java.util.Collections.sort(templList);
        System.out.println("After sorting....");
        System.out.println("original List...."+ originallList);
        System.out.println("temporary List...."+ templList);
        
        if(originallList.equals(templList)) {
            System.out.println("Dropdown list is sorted");
        }
        else {
            System.out.println("Dropdown list is NOT sorted");
        }   
driver.quit();      

}
} 

