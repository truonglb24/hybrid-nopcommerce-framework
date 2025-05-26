package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageUIs.HomePageUI;

public class User_01_Login extends BaseTest {

    WebDriver driver;
    BasePage basePage;
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    // Precondition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        basePage = new BasePage();

        homePage = new HomePageObject(driver);
        loginPage = new LoginPageObject(driver);
    }
    @Test()
    public void Login_01(){
        homePage.clickToLoginLink();

        loginPage.loginWithEmailAndPassword("78708@gmail","");
        Assert.assertEquals(loginPage.getErrorMessageEmail(), "Wrong email");
    }

    @Test()
    public void Login_02(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
