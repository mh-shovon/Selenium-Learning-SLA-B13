package Assignment.Assignment_03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class _01_Task_One {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");

        driver.findElement(By.xpath("//button[normalize-space()='Alert']")).click();
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Simple Alert Text: " + confirmAlert.getText());
        confirmAlert.accept();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@onclick='myMessage()']")).click();
        Thread.sleep(6000);
        Alert dismissAlert = driver.switchTo().alert();
        System.out.println("Confirm Alert Text: " + dismissAlert.getText());
        dismissAlert.dismiss();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("button[onclick='myPromp()']")).click();
        Alert promptAlert = driver.switchTo().alert();
        System.out.println("Prompt Alert Text: " + promptAlert.getText());
        promptAlert.sendKeys("Test Prompt Alert");
        promptAlert.accept();
        Thread.sleep(2000);

        driver.quit();
    }
}
