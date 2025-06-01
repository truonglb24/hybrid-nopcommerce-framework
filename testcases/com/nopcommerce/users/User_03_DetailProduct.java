package com.nopcommerce.users;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.DetailProductPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class User_03_DetailProduct extends BaseTest {

    WebDriver driver;
    BasePage basePage;
    LoginPageObject loginPageObject;
    DetailProductPageObject detailProductPageObject;
    HomePageObject homePageObject;
    // Precondition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        basePage = new BasePage();
        homePageObject = new HomePageObject(driver);
        loginPageObject = new LoginPageObject(driver);
        homePageObject.clickToLoginLink();
        loginPageObject.loginWithEmailAndPassword("truonglb@rabiloo.com","123123");
        basePage.openPageUrl(driver, "http://localhost/build-your-own-computer");

        detailProductPageObject = new DetailProductPageObject(driver);
    }

    @Test
    public void TC01_DetailProduct(){
        detailProductPageObject.selectProcessor();
        detailProductPageObject.selectRam();
    }

    @AfterClass
    public void afterClass(){
        //driver.quit();
    }
}
