package org.AtishAPIexample.Challenge;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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


/*
@Test
public void launchSite(){
    driver.get("https://demo.applitools.com/app.html");
    List<WebElement> listAmounts= driver.findElements(By.xpath("//table[@class='table table-padded']/tbody//tr/td[5]"));
    double positiveSum = 0, negativeSum = 0;

    for(WebElement element : listAmounts){
        String text = element.getText();
        System.out.println(text);
        String[] arr = text.split(" ");
        if(arr[0].equalsIgnoreCase("+")){
            String a  =arr[1].replaceAll("[,]","");
            positiveSum += Double.parseDouble(a);

        }else {
            String a  =arr[1].replaceAll("[,]","");
            negativeSum += Double.parseDouble(a);

        }
    }
    System.out.println("Sum of two number :"+positiveSum +" = "+negativeSum);
    double sum = positiveSum-negativeSum;
    System.out.println(sum);

}
@AfterTest
public void postCondition() throws InterruptedException {
    Thread.sleep(3000);
    driver.quit();


*/
