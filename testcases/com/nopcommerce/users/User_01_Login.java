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

    @Test
    public void TC01_Login_With_Valid_Email_And_Password() {
        homePage.clickToLoginLink();
        loginPage.loginWithEmailAndPassword("78708@gmail.com", "123123");
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
        homePage.clickToLogoutLink();
    }

    @Test
    public void TC02_Login_With_Valid_Email_And_Wrong_Password() {
        homePage.clickToLoginLink();
        loginPage.loginWithEmailAndPassword("78708@gmail.com", "wrongpass");
        Assert.assertEquals(loginPage.getGeneralLoginErrorMessage(),
                MESSAGE_ERROR_GENERAL +"\n"+MESSAGE_ERROR_PASSWORD);
    }

    @Test
    public void TC03_Login_With_Nonexistent_Email() {
        homePage.clickToLoginLink();
        loginPage.loginWithEmailAndPassword("abc@notexist.com", "123456");
        Assert.assertEquals(loginPage.getGeneralLoginErrorMessage(),
                MESSAGE_ERROR_GENERAL +"\n"+MESSAGE_ERROR_EMAIL);
    }

    @Test
    public void TC04_Login_With_Invalid_Email_Format() {
        homePage.clickToLoginLink();
        loginPage.loginWithEmailAndPassword("abc@.com", "123456");
        Assert.assertEquals(loginPage.getEmailErrorMessage(), MESSAGE_ERROR_FORMAT_EMAIL);
    }

    @Test
    public void TC05_Login_With_Empty_Email_And_Password() {
        homePage.clickToLoginLink();
        loginPage.loginWithEmailAndPassword("", "");
        Assert.assertEquals(loginPage.getEmailErrorMessage(), MESSAGE_ERROR_EMAIL_BLANK);
    }

    @Test
    public void TC06_Login_Only_Email() {
        homePage.clickToLoginLink();
        loginPage.loginWithEmailAndPassword("valid@example.com", "");
        Assert.assertEquals(loginPage.getGeneralLoginErrorMessage(),
                MESSAGE_ERROR_GENERAL +"\n"+ MESSAGE_ERROR_EMAIL);
    }

    @Test
    public void TC07_Login_Only_Password() {
        homePage.clickToLoginLink();
        loginPage.loginWithEmailAndPassword("", "123456");
        Assert.assertEquals(loginPage.getEmailErrorMessage(), MESSAGE_ERROR_EMAIL_BLANK);
    }

    @Test
    public void TC08_Login_With_Uppercase_Email() {
        homePage.clickToLoginLink();
        loginPage.loginWithEmailAndPassword("78708@GMAIL.com", "123123");
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
        homePage.clickToLogoutLink();
    }

    @Test
    public void TC09_Login_With_Wrong_Email() {
        homePage.clickToLoginLink();
        loginPage.loginWithEmailAndPassword("23123@cc", "");
        Assert.assertEquals(loginPage.getEmailErrorMessage(), MESSAGE_ERROR_WRONG_EMAIL);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
