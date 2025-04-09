package org.AtishAPIexample.ex13_Javascript_ex;

import org.AtishAPIexample.TestCaseBoilerPlate;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class ex13_Javascript_ex extends TestCaseBoilerPlate {


    //3 April 2:08:56

    @Test
    public void test_js() {
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement div_to_scroll = driver.findElement(By.xpath("//div[@id='userName']"));


        js.executeScript("window.scrollBy(0, 500);");


        String url = js.executeScript("return document.URL;").toString();
        String title = js.executeScript("return document.title;").toString();

        System.out.println(url);
        System.out.println(title);







    }







}