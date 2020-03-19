package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackShotcutFunctionality {
    /**
     * 1. Open browser
     * 2. Go to Vytrack login page
     * 3. Login as a sales manager
     * 4. Verify Dashboard page is open
     * 5. Click on Shortcuts icon
     * 6. Click on link See full list
     * 7. Click on link Opportunities
     * 8. Verify Open opportunities page is open
     * 9. Click on Shortcuts icon
     * 10. Click on link See full list
     * 11. Click on link Vehicle Service Logs
     * 12. Verify error message text is You do not have
     * permission to perform this action.
     * 13. Verify Shortcut Actions List page is still open
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager110");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);

        String expected = "Dashboard";
        String actual = driver.getTitle();
        StringUtility.verifyEquals(expected, actual);
        Thread.sleep(2000);
        WebElement shortcuts = driver.findElement(By.xpath("//div[@class='dropdown header-dropdown-shortcut header-utility-dropdown']"));
        shortcuts.click();
        WebElement fullList = driver.findElement(By.linkText("See full list"));
        fullList.click();

        Thread.sleep(2000);
        driver.findElement(By.linkText("Opportunities")).click();
        expected = "Opportunities";
        Thread.sleep(2000);
        actual = driver.getTitle();
        StringUtility.verifyContains(actual,expected);
        Thread.sleep(2000);
        shortcuts.click();
        fullList.click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Vehicle Services Logs")).click();
        Thread.sleep(2000);
        WebElement message = driver.findElement(By.xpath("//div[@class='message']"));
        expected = "You do not have permission to perform this action.";
        actual = message.getText();
        StringUtility.verifyEquals(actual, expected);

        expected = "Shortcut Actions List";
        actual= driver.getTitle();
        StringUtility.verifyEquals(expected,actual);

        driver.close();




    }
}
