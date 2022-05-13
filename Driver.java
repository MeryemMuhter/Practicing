package com.codepracticing.uyghurit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {
    private Driver(){System.out.println();};// singeltom pattern
    private static final String browserName="chrome";
    static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                  //  System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.chromedriver().setup();
                   // System.setProperty("webdriver.gecko.driver", "/Applications/geckodriver");
                    driver = new FirefoxDriver();
                    break;
                case "opera":
                    WebDriverManager.chromedriver().setup();
                   // System.setProperty("webdriver.opera.driver", "/Applications/operadriver");
                    driver=new OperaDriver();
                    break;
            }
        }
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }

}
