package Selenium.Class.Class_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTestUsingCssSelector {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());

        driver.findElement(By.cssSelector("#user-name")).sendKeys("performance_glitch_user");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#login-button")).click();
        Thread.sleep(2000);

        String productName = driver.findElement(By.cssSelector("a[id='item_4_title_link'] div[class='inventory_item_name ']")).getText();
        System.out.println("Product Name: " + productName);

        driver.quit();
    }
}
