package com.codepracticing.uyghurit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JobSearch {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Applications/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com");

        WebElement signInButton=driver.findElement(By.linkText("Sign in"));
        signInButton.click();

        WebElement emailBox= driver.findElement(By.id("username"));
        emailBox.sendKeys("bumaryam2016@gmail.com");

        WebElement passwordBox= driver.findElement(By.id("password"));
        passwordBox.sendKeys("maryam1987");

        WebElement signInButton1=driver.findElement(By.xpath("//button[@type='submit']"));
        signInButton1.click();
        WebElement searchJobBox= driver.findElement(By.xpath("//input[@role='combobox']"));
        searchJobBox.sendKeys("Software Developer in Test");

        WebElement searchButton=driver.findElement(By.xpath("//*[@id=\"global-nav-typeahead\"]/div[2]"));
        searchButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
        driver.quit();

    }
}
