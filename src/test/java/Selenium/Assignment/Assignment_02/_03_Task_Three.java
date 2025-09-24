package Selenium.Assignment.Assignment_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class _03_Task_Three {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        driver.findElement(By.name("name")).sendKeys("Mehedi Hasan Shovon");
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("shovon@example.com");
        Thread.sleep(2000);
        driver.findElement(By.id("gender")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("mobile")).sendKeys("0123456789");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("1990-01-01");
        Thread.sleep(2000);
        driver.findElement(By.id("subjects")).sendKeys("Maths, Physics");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='hobbies']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body[1]/main[1]/div[1]/div[1]/div[2]/form[1]/div[7]/div[1]/div[1]/div[2]/input[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body[1]/main[1]/div[1]/div[1]/div[2]/form[1]/div[7]/div[1]/div[1]/div[3]/input[1]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='picture']")).sendKeys("C:\\Users\\shovo\\Desktop\\Restricted Area\\Own Files\\Automation Work\\Java\\Selenium-Learning-SLA-B13\\my img.jpg");

        driver.findElement(By.xpath("//textarea[@id='picture']")).sendKeys("Dhaka, Bangladesh");
        Thread.sleep(2000);

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Uttar Pradesh");
        Thread.sleep(2000);

        Select citySelect = new Select(driver.findElement(By.id("city")));
        citySelect.selectByVisibleText("Agra");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input[value='Login']")).click();
        Thread.sleep(2000);

        driver.quit();
    }
}
