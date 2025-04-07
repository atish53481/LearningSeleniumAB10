package org.AtishAPIexample.ex02_Selenium_Basics;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class TestSelenium17_Assignment {

    @Owner("Atish M")
    @Test
    @Description("Verify the Katalon Url")
    public void test_curahealthcare() throws InterruptedException {
        //Step -1 : Open the URL - https://katalon-demo-cura.herokuapp.com/

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        // id="btn-make-appointment"
        // href="./profile.php#login"
        // class="btn btn-dark btn-lg">
        // Make Appointment</a>

        //Click on the Appointment
        WebElement buttonAppointment = driver.findElement(By.id("btn-make-appointment"));
        buttonAppointment.click();

        Thread.sleep(3000);

        //Step-2 : Enter the username and password


        // type="text"
        // class="form-control"
        // id="txt-username"
        // name="username" placeholder="Username"
        // value="" autocomplete="off">

        WebElement userNameInput = driver.findElement(By.id("txt-username"));
        userNameInput.sendKeys("John Doe");

        // type="password"
        // class="form-control"
        // id="txt-password"
        // name="password"
        // placeholder="Password"
        // value="" autocomplete="off">

        WebElement passwordInput = driver.findElement(By.id("txt-password"));
        passwordInput.sendKeys("ThisIsNotAPassword");

        //Click on the Login button

        // id="btn-login"
        // type="submit"
        // class="btn btn-default">Login</button>

        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();

        Thread.sleep(3000);


        //Step-3: Verify that the current URL changes to https://katalon-demo-cura.herokuapp.com/#appointment



        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");

      /*  if(driver.getPageSource().contains("Make Appointment")){
            System.out.println("Heading 'Make Appointment' is availabe.");
            Assert.assertTrue(true);
        }else {
            //Assert.assertTrue(false);
            // OR we can use throw Exception
            throw new Exception("Heading 'Make Appointment' is not available.");*/


        driver.quit();
    }





}
