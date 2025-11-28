package Selenium.Assignment.Assignment_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class _02_Task_Two {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.kalerkantho.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());

        driver.navigate().to("https://edition.cnn.com/");
        Thread.sleep(3000);
        System.out.println("\nAfter navigate to new URL------------------------>");
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());

        driver.navigate().back();
        Thread.sleep(3000);
        System.out.println("\nAfter go back------------------------>");
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());

        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println("\nAfter forward------------------------>");
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());

        driver.navigate().refresh();
        Thread.sleep(3000);
        System.out.println("\nAfter refresh the page------------------------>");
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());

        driver.quit();
    }
}
