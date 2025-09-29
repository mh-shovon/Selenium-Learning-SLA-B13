package testng.Class.Class_01;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoClassTest extends BaseClassTest {
    @Test(priority = 0)
    public void checkTitleShouldSucceed() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs", "Title matched.");
        System.out.println("The Title is: " + title);
    }

    @Test(priority = 1)
    public void verifyLoginWithoutUsernameShouldFail() {
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText().trim();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required", "Error message matched");
        System.out.println("Error Message: " + errorMessage);

        driver.findElement(By.id("password")).clear();
    }

    @Test(priority = 2)
    public void verifyLoginWithoutPasswordShouldFail() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText().trim();
        Assert.assertEquals(errorMessage, "Epic sadface: Password is required", "Error message matched");

        driver.findElement(By.id("user-name")).clear();
    }

    @Test(priority = 3)
    public void verifyLoginWithoutCredentialShouldFail() {
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText().trim();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required", "Error message matched");
    }

    @Test(priority = 4)
    public void validateStandardUserLoginShouldSucceed() throws InterruptedException {
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);

        String logoutButtonText = driver.findElement(By.id("logout_sidebar_link")).getText().trim();
        Assert.assertEquals(logoutButtonText, "Logout", "Logout text matched");

        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Test(priority = 5)
    public void testProblemUserLoginShouldSucceed() {
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("problem_user");

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        String logoutButtonText = driver.findElement(By.id("logout_sidebar_link")).getText().trim();
        Assert.assertEquals(logoutButtonText, "Logout", "Logout text matched");
    }
}
