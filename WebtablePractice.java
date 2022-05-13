package com.codepracticing.uyghurit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebtablePractice {
    private static WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void printTable(){
        WebElement table= driver.findElement(By.id("table1"));
        System.out.println(table.getText());
    }
    @Test
    public void getHeader() {
        WebElement header = driver.findElement(By.tagName("thead"));
        System.out.println(header.getText());

        List<WebElement> header1 = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println(header1.size());

        for (int i = 0; i < header1.size(); i++) {
            System.out.println(header1.get(i).getText());
        }
    }
        @Test
        public void getTableSize() {
            List<WebElement> header1 = driver.findElements(By.xpath("//table[@id='table1']//th"));
            System.out.println("header: "+header1.size());

            List<WebElement> rowSizeWithHeader= driver.findElements(By.xpath("//table[@id='table1']//tr"));
            System.out.println("rows with header:"+ rowSizeWithHeader.size());

            List<WebElement> rowSizeWithoutHeader= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
            System.out.println("rows without header:"+ rowSizeWithoutHeader.size());
        }
        @Test
        public void getSingleRowBYIndex(){
        WebElement singleRow= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]"));
            System.out.println(singleRow.getText());

            String xpath=getTableRowXpath(2);
            System.out.println(xpath);

            WebElement secondRow= driver.findElement(By.xpath(xpath));
            System.out.println(secondRow.getText());
        }
        @Test
        public void getSingleCellByIndex(){
        WebElement singleCell= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[3]"));
            System.out.println(singleCell.getText());

            String xpath=getSingleCellByIndex(2,2);
            WebElement secondCell= driver.findElement(By.xpath(xpath));
            System.out.println(secondCell.getText());
        }
        @Test
        public void printTableUsingLoops(){
        // row size; colum size
            System.out.println("row size:"+getRowSize());
            System.out.println("colum size:"+getColSize());
            int rowCount=getRowSize();
            int colCount=getColSize();

            for (int i=1;i<=rowCount;i++){
                for (int j=1; j<=colCount;j++){
                    String xpath=getSingleCellByIndex(i,j);
                    WebElement cell=driver.findElement(By.xpath(xpath));
                    System.out.println(cell.getText());
                }
            }

        }

        public String getTableRowXpath(int index){
        String xpath="//table[@id='table1']/tbody/tr["+index+"]";
        return xpath;
        }
    public String getSingleCellByIndex(int row,int col){
        String xpath="//table[@id='table1']/tbody/tr["+row+"]/td["+col+"]";
        return xpath;
    }
    public int getRowSize(){
        List<WebElement> rowSize= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
       return rowSize.size();

    }
    public int getColSize(){
        List<WebElement> colSize= driver.findElements(By.xpath("//table[@id='table1']//th"));
        return colSize.size();

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
