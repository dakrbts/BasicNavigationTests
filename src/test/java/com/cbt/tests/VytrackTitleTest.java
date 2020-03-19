package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackTitleTest {
    /**
     * 1. Open browser
     * 2. Go to Vytrack login page
     * 3. Login as any user
     * 4. Click on your name on top right
     * 5. Click on My Configuration
     * 6. Verify that page title starts with the same name on top
     * right
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager110");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);
        WebElement name = driver.findElement(By.xpath("//a[@href='javascript: void(0);']"));
        String userName = name.getText();
        name.click();

        driver.findElement(By.xpath("(//a[@href='/config/user/profile'])[3]")).click();
        Thread.sleep(2000);
        String title = driver.getTitle();
        if(title.startsWith(userName)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("userName = " + userName);
            System.out.println("title = " + title);
        }

        driver.close();


    }
}
