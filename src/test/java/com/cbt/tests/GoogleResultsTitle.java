package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class GoogleResultsTitle {
    /**
     * 1. Open browser
     * 2. Go to https://google.com
     * 3. Search for one of the strings the list searchStrs given below
     * 4. In the results pages, capture the url right above the first result
     * 5. Click on the first result
     * 6. Verify that url is equal to the value from step 4
     * 7. Navigate back
     * 8. Repeat the same steps for all search items in the list
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation");


        for(int i = 0; i < searchStrs.size(); i++){
            WebElement searchInput = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
          searchInput.clear();
          searchInput.sendKeys(searchStrs.get(i) + Keys.ENTER);
          String url1 = driver.findElement(By.xpath("//cite[@class='iUh30 tjvcx']")).getText();
          driver.findElement(By.xpath("//h3[@class='LC20lb DKV0Md']")).click();
          Thread.sleep(2000);
          StringUtility.verifyContains(driver.getCurrentUrl(), url1);
          driver.navigate().back();
        }

        driver.close();

    }
}
