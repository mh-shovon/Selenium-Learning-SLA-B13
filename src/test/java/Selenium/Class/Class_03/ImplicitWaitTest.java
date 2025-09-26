package Selenium.Class.Class_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class ImplicitWaitTest {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Implicit Wait - Wait for every web element and max wait time is 30 here

        driver.findElement(By.id("gender")).click();

        Select selectState = new Select(driver.findElement(By.id("state")));
        selectState.selectByIndex(4);

        selectState.selectByValue("NCR");

        selectState.selectByVisibleText("Uttar Pradesh");

        List<WebElement> elements = selectState.getOptions();
        for(WebElement element : elements){
            System.out.println("Elements are: " + element.getText());
        }

        Select selectCity = new Select(driver.findElement(By.id("city")));
        selectCity.selectByValue("Lucknow");

        driver.quit();
    }
}
