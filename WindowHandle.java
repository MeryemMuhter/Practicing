package com.codepracticing.uyghurit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        String firstWindow = driver.getWindowHandle();
        System.out.println(firstWindow);

        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHere.click();

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals("New Window")) {
                System.out.println(driver.getWindowHandle());
                System.out.println(driver.getTitle());
                break;
            }
            }

            String message = driver.findElement(By.tagName("h3")).getText();
            if (message.equalsIgnoreCase("New window")) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
            driver.switchTo().window(firstWindow);
            String firstWindowText = driver.findElement(By.tagName("h3")).getText();
            if (firstWindowText.equalsIgnoreCase("Opening a new window")) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }



    }
}
