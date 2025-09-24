package Selenium.Assignment.Assignment_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class _04_Task_Four {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement loginBtn = driver.findElement(By.cssSelector("input[value='Login']"));


        String bgColor = loginBtn.getCssValue("background-color");
        String fontSize = loginBtn.getCssValue("font-size");
        String fontFamily = loginBtn.getCssValue("font-family");

        System.out.println("CSS - Background Color: " + bgColor);
        System.out.println("CSS - Font Size: " + fontSize);
        System.out.println("CSS - Font Family: " + fontFamily);

        WebElement practiceFormTab = driver.findElement(By.cssSelector("#login-button"));
        String nameAttr = practiceFormTab.getAttribute("name");
        String typeAttr = practiceFormTab.getAttribute("type");
        String idAttr = practiceFormTab.getAttribute("id");

        System.out.println("Attribute - name: " + nameAttr);
        System.out.println("Attribute - type: " + typeAttr);
        System.out.println("Attribute - aria-label: " + idAttr);

    }
}
