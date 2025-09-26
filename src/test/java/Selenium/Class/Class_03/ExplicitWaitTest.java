package Selenium.Class.Class_03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitTest {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit Wait declare

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[onclick='showAlert()']")))).click(); // Explicit Wait occurred here only
        wait.until(ExpectedConditions.alertIsPresent()); // Explicit Wait occurred here only
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//button[@onclick='myDesk()']")).click();
        wait.until(ExpectedConditions.alertIsPresent()); // Explicit Wait occurred here only
        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("//button[@onclick='myPromp()']")).click();
        wait.until(ExpectedConditions.alertIsPresent()); // Explicit Wait occurred here only
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Test Prompt Alert");
        System.out.println("Test Prompt Alert is: " + promptAlert.getText());
        promptAlert.accept();

        driver.quit();
    }
}
