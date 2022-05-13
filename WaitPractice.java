package com.codepracticing.uyghurit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class WaitPractice {
    private static WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=Driver.getDriver();
        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void dynamicLoad(){
        WebElement btnLoad=driver.findElement(By.id("visibleAfter"));
        Assert.assertTrue(btnLoad.isDisplayed());
        Assert.assertEquals(btnLoad.getText(),"Visible After 5 Seconds");
        
    }
    @Test
    public void dynamicExpilictlyWait(){
        WebDriverWait wait=new WebDriverWait(driver,15);
      //  WebElement btnLoad=wait.until(ExpectedConditions.elementToBeClickable(By.id("visibleAfter")));
     //   Assert.assertEquals(btnLoad.getText(),"Visible After 5 Seconds");

        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter")));
        assertEquals(element.getText(),"Visible After 5 Seconds");

        WebElement element1= driver.findElement(By.id("visibleAfter"));
        wait.until(ExpectedConditions.visibilityOf(element1));







    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }



}
