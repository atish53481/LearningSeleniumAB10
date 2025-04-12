package org.AtishAPIexample.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class April5Assignment {


    //5 April 1;17:52


    //https://app-automate.browserstack.com/dashboard/v2/getting-started


    public static void main(String[] args) {
        ChromeOptions edgeOptions = new ChromeOptions();
       // edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");
        ChromeDriver driver = new ChromeDriver(edgeOptions);

        driver.get("https://app-automate.browserstack.com/dashboard/v2/getting-started");

        //driver.findElement(By.xpath("//span[text()='Sign in']")).click();

        driver.findElement(By.id("user_email_login")).sendKeys("atish.53481@gmail.com");

        driver.findElement(By.id("user_password")).sendKeys("QAZx@2209");

        driver.findElement(By.id("user_submit")).click();





    }
}
