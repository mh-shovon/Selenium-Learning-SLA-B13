package Assignment.Assignment_03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class _04_Task_Four {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window: " + parentWindow);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.tutorialspoint.com/selenium/practice/new-tab-sample.php");
        System.out.println("New Tab Title: " + driver.getTitle());
        System.out.println("New Tab URL: " + driver.getCurrentUrl());
        driver.close();

        driver.switchTo().window(parentWindow); // Switch to the main window

        driver.quit();
    }
}
