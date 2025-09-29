package testng.Class.Class_01;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemoMethodTest extends BaseMethodTest {
    @Test
    public void checkTitleShouldSucceed() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs", "Title matched.");
        System.out.println("The Title is: " + title);
    }

    @Test
    public void verifyLoginWithoutUsernameShouldFail() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText().trim();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required", "Error message matched");
        System.out.println("Error Message: " + errorMessage);
    }

    @Test
    public void verifyLoginWithoutPasswordShouldFail() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText().trim();
        Assert.assertEquals(errorMessage, "Epic sadface: Password is required", "Error message matched");
        System.out.println("Error Message: " + errorMessage);
    }

    @Test
    public void verifyLoginWithoutCredentialShouldFail() {
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText().trim();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required", "Error message matched");
        System.out.println("Error Message: " + errorMessage);
    }

    @Test
    public void validateStandardUserLoginShouldSucceed() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        String logoutButtonText = driver.findElement(By.id("logout_sidebar_link")).getText().trim();
        Assert.assertEquals(logoutButtonText, "Logout", "Logout text matched");
        System.out.println("Logout Button Text: " + logoutButtonText);
    }

    @Test
    public void testProblemUserLoginShouldSucceed() {
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        String logoutButtonText = driver.findElement(By.id("logout_sidebar_link")).getText().trim();
        Assert.assertEquals(logoutButtonText, "Logout", "Logout text matched");
        System.out.println("Logout Button Text: " + logoutButtonText);
    }
}
