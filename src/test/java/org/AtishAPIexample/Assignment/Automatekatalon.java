package org.AtishAPIexample.Assignment;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.AtishAPIexample.ex07_WaitHelper.WaitHelpers.waitJVM;

public class Automatekatalon {


    //1. Click on the Get Automate
    //2. Open the app using username and password
    //3. from the Select box & checkbox, select the third one
    //4. Entire all the details and click on the book appointment
    //5. verify the comment
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
    }

    @Test
    @Owner("Atish M")
    @Description("Verify the full flow of book appointment till of katalon")
    public void test_Katalon() {

        String url = "https://katalon-demo-cura.herokuapp.com/";
        driver.get(url);

        WebElement makeAppointment = driver.findElement(By.id("btn-make-appointment"));
        makeAppointment.click();

        WebElement userName = driver.findElement(By.id("txt-username"));
        userName.sendKeys("John Doe");

        WebElement passWord = driver.findElement(By.id("txt-password"));
        passWord.sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();


        //drop down

        WebElement facility=driver.findElement(By.id("combo_facility"));

        Select select = new Select(facility);
        select.selectByIndex(2);
  //     select.selectByVisibleText("Option 3");
      //  select.selectByValue("3");
        //   facility.sendKeys("Seoul CURA Healthcare Center");
        // waitJVM(2000);

        WebElement chkBox=driver.findElement(By.id("chk_hospotal_readmission"));
        chkBox.click();

        WebElement radioNoneButton=driver.findElement(By.id("radio_program_none"));
        radioNoneButton.click();

        WebElement calendar =driver.findElement(By.id("txt_visit_date"));
        calendar.sendKeys("30/04/2025");


        WebElement comment =driver.findElement(By.id("txt_comment"));
        comment.sendKeys("Hello");
        String commentText = comment.getText();

        WebElement bookAppointment = driver.findElement(By.id("btn-book-appointment"));
        bookAppointment.click();



        waitJVM(2000);

        WebElement heading=driver.findElement(By.tagName("h2"));
        Assert.assertTrue(heading.isDisplayed());
        Assert.assertEquals(heading.getText(),"Appointment Confirmation");

        WebElement con_facility=driver.findElement(By.xpath("//p[@id='facility']"));
        Assert.assertTrue(con_facility.isDisplayed());

        WebElement reAdmission=driver.findElement(By.id("hospital_readmission"));
        Assert.assertEquals(reAdmission.getText(),"Yes");

        WebElement program=driver.findElement(By.id("program"));
        Assert.assertEquals(program.getText(),"None");

        WebElement visitedDate=driver.findElement(By.id("visit_date"));
        Assert.assertEquals(visitedDate.getText(),"30/04/2025");


        WebElement comm=driver.findElement(By.id("comment"));
        System.out.println(comm.getText());
        Assert.assertEquals(comm.getText(),"Hello");

        WebElement barIcon=driver.findElement(By.xpath("//i[@class='fa fa-bars']"));
        barIcon.click();

        WebElement logout=driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
        logout.click();

    }


    @AfterTest
    public void closeBrowser(){

        waitJVM(3000);
        driver.quit();

    }
}