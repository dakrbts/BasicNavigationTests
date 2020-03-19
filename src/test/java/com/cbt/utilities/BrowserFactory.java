package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browserType){
        WebDriver driver = null;
        String property = System.getProperty("os.name");

        switch(browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                if(property.contains("Mac")) {
                    driver = new SafariDriver();
                }
                break;
            case "edge":
                if(property.contains("Windows")){
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
        }
        return driver;
    }
}
