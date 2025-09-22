package Selenium.Class.Class_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class LintTestKalerKontho {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.kalerkantho.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        for (WebElement element : elements) {
            System.out.println(element.getText() + "   URL:   " + element.getAttribute("href"));
        }

        driver.quit();
    }
}
