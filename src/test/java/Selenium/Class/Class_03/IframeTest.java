package Selenium.Class.Class_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class IframeTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.out.println("Before Main Page Text Print: " + driver.findElement(By.cssSelector("div[class='col-md-8 col-lg-8 col-xl-8'] p")).getText());

        driver.switchTo().frame(0);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[title='back to Selenium Tutorial']")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        System.out.println("After Main Page Text Print: " + driver.findElement(By.cssSelector("a[title='back to Selenium Tutorial']")).getText());

        driver.quit();
    }
}
