package Assignment.Assignment_03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class _02_Task_Two {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");

        System.out.println("Before Main Page Text Print: " + driver.findElement(By.cssSelector("div[class='col-md-8 col-lg-8 col-xl-8'] p")).getText());

        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("a[title='back to Selenium Tutorial']")).click();
        driver.navigate().back();
        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);

        driver.switchTo().parentFrame();

        driver.switchTo().defaultContent();
        System.out.println("Back to Main Page");

        driver.quit();
    }
}
