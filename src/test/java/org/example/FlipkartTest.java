package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlipkartTest {
    private WebDriver driver;

    @Test(priority = 0)
    public void testCheckTitleAndCloseLogIn() {
        driver.get("https://www.flipkart.com/");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
        WebElement closeLogin = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
        closeLogin.click();
    }

    @Test(priority = 1)
    public void testMaximizeWindow() {
        driver.manage().window().maximize();
    }
    @Test(priority = 2)
    public void testSearchBox()  {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Samsung Phones");
        WebElement searchBtn = driver.findElement(By.className("L0Z3Pu"));
        searchBtn.click();
    }

    @Test(priority = 3)
    public void testClickOnItem() throws InterruptedException {
        Thread.sleep(5000);
        WebElement phone = driver.findElement(By.className("_2kHMtA"));
        phone.click();
    }

    @Test(priority = 4)
    public void testScroll() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,6000)");
        Thread.sleep(3000);
    }

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
