package com.codepracticing.uyghurit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class fileUpload {
   private static WebDriver driver;
   private String home=System.getProperty("user.home");
   private String fileName="youtube_cover.png";
   private String path=home+"/Desktop/"+fileName;
   @BeforeMethod
    public void setUp(){
       driver=Driver.getDriver();
       driver.get("https://the-internet.herokuapp.com/upload");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }
   @Test
   public void uploadFileTest(){
      WebElement fileUpload= driver.findElement(By.id("file-upload"));
      fileUpload.sendKeys("path");

      WebElement fileSubmit= driver.findElement(By.id("file-submit"));
      fileSubmit.click();

      WebElement successMessage= driver.findElement(By.tagName("h3"));
      Assert.assertEquals(successMessage.getText(),"File Uploaded!");

      WebElement uploadedFile=driver.findElement(By.id("uploaded-files"));
      Assert.assertEquals(uploadedFile.getText(),fileName);
   }
   @Test
   public void downloadFileTest() throws InterruptedException {
      WebElement file= driver.findElement(By.partialLinkText(fileName));
      file.click();
      Thread.sleep(3000);

      String filePath=FileUtility.getMostRecentFilePath(home+"/Downloads");
      Assert.assertTrue(filePath.contains(fileName),"file found");

      boolean isDeleted=FileUtility.delete(filePath);
      Assert.assertTrue(isDeleted);
   }
   @AfterMethod
   public void tearDown(){
      Driver.closeDriver();
   }
}
