package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class W3schoolsTest {
   private WebDriver driver;

    @Test(priority=0)
    public void testJbkTitle() throws InterruptedException {
        driver.get("https://www.w3schools.com/");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"W3Schools Online Web Tutorials");
        Thread.sleep(1000);
        WebElement learnHtmlBtn = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div[1]/a[1]"));
        learnHtmlBtn.click();
        Thread.sleep(1000);
    }

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver","F:\\\\chrome-driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
