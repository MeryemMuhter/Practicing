package com.codepracticing.uyghurit;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Locale;


public class CreateNewFacebookAccount {
    public static void main(String[] args) {


        WebDriver driver = Driver.getDriver();
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();

        WebElement createAccount = driver.findElement(By.xpath("//a[text()='Create New Account']"));
        createAccount.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        Faker faker = new Faker();
        String generatefirstName = faker.name().firstName();
        firstName.sendKeys(generatefirstName);

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        Faker faker1 = new Faker();
        String generateLastName = faker1.name().lastName();
        lastName.sendKeys(generateLastName);

        WebElement email=driver.findElement(By.name("reg_email__"));
        String randomEmail=RandomStringUtils.randomAlphabetic(5,9).toLowerCase()+"@gmail.com";
        email.sendKeys(randomEmail);

        WebElement reemail=driver.findElement(By.name("reg_email_confirmation__"));
        reemail.sendKeys(randomEmail);

        WebElement password=driver.findElement(By.name("reg_passwd__"));
        String randomPassword=RandomStringUtils.randomAlphanumeric(8,12);
        password.sendKeys(randomPassword);

        Select day=new Select(driver.findElement(By.id("day")));
        Select month=new Select(driver.findElement(By.id("month")));
        Select year=new Select(driver.findElement(By.id("year")));

        day.selectByValue("3");
        month.selectByValue("11");
        year.selectByVisibleText("1987");

        WebElement gender= driver.findElement(By.xpath("//*[text()='Female']//following-sibling::input"));
        gender.click();

        WebElement signUp= driver.findElement(By.name("websubmit"));
        signUp.click();

        Driver.closeDriver();
    }
}
