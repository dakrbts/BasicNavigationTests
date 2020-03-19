package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EtsySearchTest {
    /**
     * 1. Open browser
     * 2. Go to https://ebay.com
     * 3. Search for wooden spoon
     * 4. Save the total number of results
     * 5. Click on link All under the categories on the left menu
     * 6. Verify that number of results is bigger than the number in step 4
     * 7. Navigate back to previous research results page
     * 8. Verify that wooden spoon is still displayed in the search box
     * 9. Navigate back to home page
     * 10. Verify that search box is blank
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://ebay.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);
        Thread.sleep(2000);
        String searchResult = driver.findElement(By.cssSelector("h1>span")).getText();
        int searchResultNum = Integer.parseInt(searchResult.replace(",",""));
        driver.findElement(By.linkText("All")).click();
        Thread.sleep(2000);
        String allResult = driver.findElement(By.cssSelector("h1>span")).getText();
        int allResultNum = Integer.parseInt(allResult.replace(",",""));
        if(allResultNum > searchResultNum){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("allResultNum = " + allResultNum);
            System.out.println("searchResultNum = " + searchResultNum);
        }

        driver.navigate().back();
        searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        String expectedValue = "wooden spoon";
        String actualValue = searchBox.getAttribute("value");

        StringUtility.verifyEquals(expectedValue,actualValue);
        driver.navigate().back();
        Thread.sleep(2000);
        searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        StringUtility.verifyEquals(searchBox.getAttribute("value"), "");
        driver.close();
    }
}
