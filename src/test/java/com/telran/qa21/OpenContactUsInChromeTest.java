package com.telran.qa21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class OpenContactUsInChromeTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= new ChromeDriver();
        driver.navigate().to("http://automationpractice.com");
        // maximize browser to window width
        driver.manage().window().maximize();
        // wait far the site load before starting the test
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void searchProductTest(){
        // find element of search field
        // click in the search field
        driver.findElement(By.id("contact-link")).click();
        // check if the search result is correct
        String text1 = driver.findElement(By.className("page-heading")).getText();
        System.out.println(text1);  // -----for check of text1-----

        Assert.assertEquals(text1.toLowerCase(),"customer service - contact us");
        //Assert.assertEquals(text1,"CUSTOMER SERVICE - CONTACT US");  //-----other variant----
    }

    @AfterMethod(enabled = true)
    public void tearDown(){
        driver.close();  //----close tab---
        driver.quit();   //----close browser
    }
}
