package com.codepracticing.uyghurit;

import org.openqa.selenium.WebDriver;

public class DriverTest {
    public static void main(String[] args) {
        WebDriver driver=Driver.getDriver();
        driver.get("https://www.linkedin.com");
       // Driver.closeDriver();
    }
}
