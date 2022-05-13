package com.codepracticing.uyghurit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {
    public static void main(String[] args) {
        WebDriver driver= Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions action=new Actions(driver);
        WebElement hotSpot= driver.findElement(By.id("hot-spot"));
        action.contextClick(hotSpot).perform();

    }
}
