package org.AtishAPIexample.ex14_JS_ShadowDOM;

import org.AtishAPIexample.TestCaseBoilerPlate;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.AtishAPIexample.ex07_WaitHelper.WaitHelpers.waitJVM;

public class Lab41_JS_Code_ShadowDOM extends TestCaseBoilerPlate {

    @Test
    public void test_js() {
        //3 April 2:20:00
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement div_to_scroll = driver.findElement(By.xpath("//div[@id='userName']"));

        // Shadow DOM -> js.executeCode

        waitJVM(3000);

        WebElement inputboxPizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"#pizza\");");
        inputboxPizza.sendKeys("farmhouse");
    }


}