package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://luluandgeorgia.com", "https://wayfair.com", "https://www.westelm.com", "https://walmart.com");
        WebDriver driver = BrowserFactory.getDriver("chrome");

        for(int i = 0; i < urls.size(); i++){
            driver.get(urls.get(i));
            verifyURLcontainsTitle(driver.getCurrentUrl(), driver.getTitle());
        }

        driver.close();

    }

    private static void verifyURLcontainsTitle(String url, String title) {
        title = title.toLowerCase().replace(" ", "");
        if(url.contains(title)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("url = " + url);
            System.out.println("title = " + title);
        }
    }
}
