package Selenium.Class.Class_02.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class PracticeOnClassTwo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Current URL is: " + driver.getCurrentUrl());

        driver.findElement(By.xpath("//div[@class='login_logo']")).isDisplayed();

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).isDisplayed();
        Thread.sleep(2000);
        System.out.println("The displayed product name: " + driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).getText());
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);


        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("checkout")).isDisplayed();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("firstName")).sendKeys("Mehedi Hasan");
        Thread.sleep(2000);
        driver.findElement(By.name("lastName")).sendKeys("Shovon");
        Thread.sleep(2000);
        driver.findElement(By.id("postal-code")).sendKeys("6667");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#continue")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@id='finish']")).click();
        Thread.sleep(2000);

        System.out.println("Order Confirmation Text: " + driver.findElement(By.cssSelector(".complete-header")).getText());
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#logout_sidebar_link")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='login_logo']")).isDisplayed();

        driver.quit();
    }

}
