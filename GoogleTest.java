package com.codepracticing.uyghurit;

import org.openqa.selenium.WebDriver;

public class GoogleTest {
    private static WebDriver driver;
    public static void main(String[] args) {
        driver=Driver.getDriver();
        driver.get("https://www.google.com");

        Driver.closeDriver();
    }
}
