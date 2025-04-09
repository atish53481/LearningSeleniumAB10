package org.AtishAPIexample.Challenge;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.List;

public class Challenge1 {

    private static final DecimalFormat df = new DecimalFormat("0.00");


    @Test
    @Description("Calculate the Total Amount of Money Spent ")
    @Owner("Atish M")
    public void test_applitools() {


        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.applitools.com");

        driver.findElement(By.id("username")).sendKeys("Admin");
        driver.findElement(By.id("password")).sendKeys("Password@123");
        driver.findElement(By.id("log-in")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.applitools.com/app.html");

        String str1 = "//tr[";
        String str2 = "]/td[5]/span[1]";



        //"//tr[1]/td[5]/span[1]"

        int amountlength = driver.findElements(By.xpath("//td[last()]")).size();

        Double totalAmount = 0.0;
        double  additionAmount = 0.00;
        double  minusAmount = 0.00;

        for(int i = 1; i<=amountlength; i++ ) {

            String amt = driver.findElement(By.xpath(str1+i+str2)).getText();

            amt = amt.replaceAll("[A-Za-z]","").trim();



          if(amt.contains("+")){

             amt =  amt.replaceAll("[+,]","");

              additionAmount = additionAmount+Double.parseDouble(amt);


          }

            if(amt.contains("-")){

                amt =  amt.replaceAll("[-,]","");

                minusAmount = minusAmount+Double.parseDouble(amt);


            }
        }
//564  2560.22
        System.out.println(minusAmount +"minusAmount");
        System.out.println(additionAmount +"additionAmount");

        totalAmount = additionAmount-minusAmount;

        String totalAmount1 = df.format(totalAmount);

        System.out.println("Final Amount "+totalAmount1);


        driver.quit();
        }
    }


