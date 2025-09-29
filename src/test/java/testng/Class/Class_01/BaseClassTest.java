package testng.Class.Class_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClassTest {
    WebDriver driver;

    @BeforeClass
    public void launchBrowser(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }
}
