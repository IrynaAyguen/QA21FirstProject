package com.telran.qa21;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SearchProductTests {
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
        driver.findElement(By.id("search_query_top")).click();
        //driver.findElement(By.cssSelector("#search_query_top")).click();  //other variant
        // input search data
        driver.findElement(By.id("search_query_top")).sendKeys("summer dresses"+ Keys.ENTER);
        // check if the search result is correct
        String text = driver.findElement(By.className("lighter")).getText();
        Assert.assertEquals(text.toLowerCase(),"\"summer dresses\"");
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
        //driver.close();  //close tab
    }
}
