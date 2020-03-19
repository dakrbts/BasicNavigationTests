package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerificationTests {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/", "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get(urls.get(0));
        String titleOne = driver.getTitle();
        String urlOne = driver.getCurrentUrl();
        driver.get(urls.get(1));
        String titleTwo = driver.getTitle();
        String urlTwo = driver.getCurrentUrl();
        driver.get(urls.get(2));
        String titleThree = driver.getTitle();
        String urlThree = driver.getCurrentUrl();

        if(titleOne.equals(titleTwo) && titleTwo.equals(titleThree)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("titleOne = " + titleOne);
            System.out.println("titleTwo = " + titleTwo);
            System.out.println("titleThree = " + titleThree);
        }


        String expectedStartOfURL = "http://practice.cybertekschool.com";


        if(urlOne.startsWith(expectedStartOfURL) &&
           urlTwo.startsWith(expectedStartOfURL) && urlThree.startsWith(expectedStartOfURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected start of URL = " + expectedStartOfURL);
            System.out.println("urlOne = " + urlOne);
            System.out.println("urlTwo = " + urlTwo);
            System.out.println("urlThree = " + urlThree);
        }

        driver.close();

    }


}
