package com.codepracticing.uyghurit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {
    public static void main(String[] args) {
        WebDriver driver= Driver.getDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions action=new Actions(driver);

        WebElement source= driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droptarget"));
        System.out.println(target.getText());
        action.dragAndDrop(source,target).perform();
        WebElement afterDroped= driver.findElement(By.id("droptarget"));
        System.out.println(afterDroped.getText());

    }
}
