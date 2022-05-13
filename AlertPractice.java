package com.codepracticing.uyghurit;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractice {
    private static WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=Driver.getDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test(priority = 0)
    public void alert() throws InterruptedException {
        WebElement btnAlert= driver.findElement(By.id("alertButton"));
        btnAlert.click();
        String alertText=driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,"You clicked a button");
            Thread.sleep(3000);

        driver.switchTo().alert().accept();
    }
    @Test
    public void timerAlert() {
        WebElement btnTimer= driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        btnTimer.click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();
    }
    @Test(priority = 2)
    public void confirmAlert() throws InterruptedException {
        WebElement btnConfirm= driver.findElement(By.id("confirmButton"));
        btnConfirm.click();
        Thread.sleep(5000);
        Alert alert=driver.switchTo().alert();
        String confirmText=alert.getText();
        Assert.assertEquals(confirmText,"Do you confirm action?");
        alert.accept();

        String resultText=driver.findElement(By.id("confirmResult")).getText();
        Assert.assertTrue(resultText.contains("Ok"));
    }
    @Test(priority = 3)
    public void promptAlert() throws InterruptedException {
        WebElement btnPrompt= driver.findElement(By.id("promptButton"));
        btnPrompt.click();
        driver.switchTo().alert().sendKeys("Meryem");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        String promptResultText=driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(promptResultText.contains("Meryem"));

    }

}
