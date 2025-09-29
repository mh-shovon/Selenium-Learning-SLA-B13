package testng.Class.Class_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTest {
    @Test
    public void checkTest() {
        System.out.println("This is my first TestNG test case");
    }

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
}
