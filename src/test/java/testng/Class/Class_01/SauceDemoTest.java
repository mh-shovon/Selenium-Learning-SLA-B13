package testng.Class.Class_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemoTest {
    @Test
    public void checkTitleShouldSucceed() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.saucedemo.com/");

        String title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs", "Title matched.");
        System.out.println("The Title is: " + title);

        driver.quit();
    }

    @Test
    public void verifyLoginWithoutUsernameShouldFail() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText().trim();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required", "Error message matched");
        System.out.println("Error Message: " + errorMessage);

        driver.quit();
    }

    @Test
    public void verifyLoginWithoutPasswordShouldFail() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText().trim();
        Assert.assertEquals(errorMessage, "Epic sadface: Password is required", "Error message matched");
        System.out.println("Error Message: " + errorMessage);

        driver.quit();
    }

    @Test
    public void verifyLoginWithoutCredentialShouldFail() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText().trim();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required", "Error message matched");
        System.out.println("Error Message: " + errorMessage);

        driver.quit();
    }

    @Test
    public void validateStandardUserLoginShouldSucceed() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);

        String logoutButtonText = driver.findElement(By.id("logout_sidebar_link")).getText().trim();
        Assert.assertEquals(logoutButtonText, "Logout", "Logout text matched");
        System.out.println("Logout Button Text: " + logoutButtonText);

        driver.quit();
    }

    @Test
    public void testProblemUserLoginShouldSucceed() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);

        String logoutButtonText = driver.findElement(By.id("logout_sidebar_link")).getText().trim();
        Assert.assertEquals(logoutButtonText, "Logout", "Logout text matched");
        System.out.println("Logout Button Text: " + logoutButtonText);

        driver.quit();
    }
}
