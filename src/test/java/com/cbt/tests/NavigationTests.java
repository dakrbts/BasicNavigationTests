package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void main(String[] args) {
         chromeTestExecution();
         firefoxTestExecution();
         safariTestExecution();
    }

    /**
     * 1. Openbrowser
     * 2. Go to website https://google.com
     * 3. Save the title in a string variable
     * 4. Go to https://etsy.com
     * 5. Save the title in a string variable
     * 6. Navigate back to previous page
     * 7. Verify that title is same as in step 3
     * 8. Navigate forward to previous page
     * 9. Verify that title is same as in step 5
     */

    private static void chromeTestExecution() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        String googleTitle = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String etsyTitle = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(googleTitle, driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(etsyTitle, driver.getTitle());

        driver.close();

    }

    private static void firefoxTestExecution() {
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://google.com");
        String googleTitle = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String etsyTitle = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(googleTitle, driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(etsyTitle, driver.getTitle());

        driver.close();
    }

    private static void safariTestExecution() {
        WebDriver driver = BrowserFactory.getDriver("safari");
        driver.get("https://google.com");
        String googleTitle = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String etsyTitle = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(googleTitle, driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(etsyTitle, driver.getTitle());

        driver.close();
    }

}
