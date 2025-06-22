package com.nopcommerce.users;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

public class User_04_ShoppingCart extends BaseTest {

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

    @Test
    public void TC01() {

    }

    @Test
    public void TC02() {

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
