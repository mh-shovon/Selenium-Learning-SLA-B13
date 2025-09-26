package Selenium.Class.Class_03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WindowTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Main Window Title: " + driver.getTitle());
        System.out.println("Main Window URL: " + driver.getCurrentUrl());

        Thread.sleep(2000);
        String originalWindow = driver.getWindowHandle(); // Store the main window ID
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.tutorialspoint.com/selenium/practice/new-tab-sample.php");
        Thread.sleep(2000);
        System.out.println("New Window Title: " + driver.getTitle());
        System.out.println("New Window URL: " + driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(originalWindow); // Switch to the main window

        driver.quit();
    }
}
