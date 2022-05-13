package com.codepracticing.uyghurit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IframePractice {
    public static void main(String[] args) {
        WebDriver driver=Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        int iframeCount=driver.findElements(By.tagName("iframe")).size();
        System.out.println(iframeCount);

       // WebElement iframe= driver.findElement(By.id("mce_0_ifr"));
       // driver.switchTo().frame(iframe);
        driver.switchTo().frame(0);
        WebElement content= driver.findElement(By.xpath("//body[@id='tinymce']/p"));
        System.out.println(content.getText());

       // Driver.closeDriver();
    }

}
