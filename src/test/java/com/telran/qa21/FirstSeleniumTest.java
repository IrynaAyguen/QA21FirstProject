package com.telran.qa21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;
    // befor - setUp
    @BeforeMethod
    public void setUp(){
     driver= new ChromeDriver();
     //driver= new FirefoxDriver();
     driver.get("https://www.google.com/");

    }
    // test ...
    @Test
    public void openGoogleTest(){
        System.out.println("site opened!!!");
    }
    // after - tearDown
    @AfterMethod(enabled = true)
    public void tearDown(){
        //close browser
        driver.quit();
    }
}
