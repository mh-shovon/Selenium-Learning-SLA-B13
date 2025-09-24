package Selenium.Assignment.Assignment_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class _01_Task_One {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.id("gender")).click();
        Thread.sleep(2000);

        Select selectState = new Select(driver.findElement(By.id("state")));
        selectState.selectByIndex(4);
        Thread.sleep(2000);

        selectState.selectByValue("NCR");
        Thread.sleep(2000);

        selectState.selectByVisibleText("Uttar Pradesh");
        Thread.sleep(2000);

        List<WebElement> elements = selectState.getOptions();
        for(WebElement element : elements){
            System.out.println("Elements are: " + element.getText());
        }

        Select selectCity = new Select(driver.findElement(By.id("city")));
        selectCity.selectByValue("Lucknow");

        driver.quit();
    }
}
