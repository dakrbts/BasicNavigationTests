package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTitle {
    /**
     * 1. Open go to amazon
     * 2. enter any search term
     * 3. click on search button
     * 4. verify page title contains the search term
     * 5. close browser
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        String searchInput = "blanket";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchInput);
        WebElement searchButton = driver.findElement(By.className("nav-input"));
        searchButton.click();
        Thread.sleep(2000);
        String title = driver.getTitle();
        if(title.contains(searchInput)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("title = " + title);
            System.out.println("searchInput = " + searchInput);
        }

        driver.close();

    }
}
