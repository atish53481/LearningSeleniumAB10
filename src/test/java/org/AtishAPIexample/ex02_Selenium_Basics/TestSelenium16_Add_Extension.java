package org.AtishAPIexample.ex02_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class TestSelenium16_Add_Extension {

    @Description("Options Class")
    @Test
    public void test_Selenium01() throws Exception {

        //23 Mar 1:32:00
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--window-size=1920,1080");
        edgeOptions.addExtensions(new File("src/test/java/org/AtishAPIexample/ex02_Selenium_Basics/adblock1.crx"));

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.youtube.com/watch?v=BwTSxsAqlEc");

        // driver.manage().deleteAllCookies();



    }
}