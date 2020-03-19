package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaUrl {
    /**
     * 1. Go to wikipedia.org
     * 2. enter search term selenium webdriver
     * 3. click on search button
     * 4. click on search result Selenium (software)
     * 5. verify url ends with Selenium_(software)
     */
    public static void main(String[] args){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver");
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();
        driver.findElement(By.linkText("Selenium (software)")).click();

        String expectedToEndWith = "Selenium_(software)";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.endsWith(expectedToEndWith)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedToEndWith = " + expectedToEndWith);
            System.out.println("actualUrl = " + actualUrl);
        }

        driver.close();


    }
}
