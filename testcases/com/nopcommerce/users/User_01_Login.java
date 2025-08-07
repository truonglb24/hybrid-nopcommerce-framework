package com.nopcommerce.users;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import reportConfigs.ExtentTestManager;

import java.lang.reflect.Method;

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
    public void TC01_Login_With_Valid_Email_And_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login with valid email and password");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Login Link");
        homePage.clickToLoginLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Entering Email and Password");
        loginPage.loginWithEmailAndPassword("78708@gmail.com", "123123");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify after login success");
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Logout");
        homePage.clickToLogoutLink();
    }

    @Test
    public void TC02_Login_With_Valid_Email_And_Wrong_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login with valid email and wrong password");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Login Link");
        homePage.clickToLoginLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Enter valid email and wrong password");
        loginPage.loginWithEmailAndPassword("78708@gmail.com", "wrongpass");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify error message");
        Assert.assertEquals(loginPage.getGeneralLoginErrorMessage(),
                GlobalConstants.MESSAGE_ERROR_GENERAL + "\n" + GlobalConstants.MESSAGE_ERROR_PASSWORD);
    }

    @Test
    public void TC03_Login_With_Nonexistent_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login with nonexistent email");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Login Link");
        homePage.clickToLoginLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Enter nonexistent email and password");
        loginPage.loginWithEmailAndPassword("abc@notexist.com", "123456");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify error message");
        Assert.assertEquals(loginPage.getGeneralLoginErrorMessage(),
                GlobalConstants.MESSAGE_ERROR_GENERAL + "\n" + GlobalConstants.MESSAGE_ERROR_EMAIL);
    }

    @Test
    public void TC04_Login_With_Invalid_Email_Format(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login with invalid email format");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Login Link");
        homePage.clickToLoginLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Enter invalid email format");
        loginPage.loginWithEmailAndPassword("abc@.com", "123456");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify email format error message");
        Assert.assertEquals(loginPage.getEmailErrorMessage(), GlobalConstants.MESSAGE_ERROR_FORMAT_EMAIL);
    }

    @Test
    public void TC05_Login_With_Empty_Email_And_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login with empty email and password");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Login Link");
        homePage.clickToLoginLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Leave email and password blank");
        loginPage.loginWithEmailAndPassword("", "");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify email blank error message");
        Assert.assertEquals(loginPage.getEmailErrorMessage(), GlobalConstants.MESSAGE_ERROR_EMAIL_BLANK);
    }

    @Test
    public void TC06_Login_Only_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login with only email");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Login Link");
        homePage.clickToLoginLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Enter only email, leave password blank");
        loginPage.loginWithEmailAndPassword("valid@example.com", "");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify error message");
        Assert.assertEquals(loginPage.getGeneralLoginErrorMessage(),
                GlobalConstants.MESSAGE_ERROR_GENERAL + "\n" + GlobalConstants.MESSAGE_ERROR_EMAIL);
    }

    @Test
    public void TC07_Login_Only_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login with only password");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Login Link");
        homePage.clickToLoginLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Leave email blank, enter password");
        loginPage.loginWithEmailAndPassword("", "123456");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify email blank error message");
        Assert.assertEquals(loginPage.getEmailErrorMessage(), GlobalConstants.MESSAGE_ERROR_EMAIL_BLANK);
    }

    @Test
    public void TC08_Login_With_Uppercase_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login with uppercase email");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Login Link");
        homePage.clickToLoginLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Enter email with uppercase letters");
        loginPage.loginWithEmailAndPassword("78708@GMAIL.com", "123123");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify login success with uppercase email");
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Logout");
        homePage.clickToLogoutLink();
    }

    @Test
    public void TC09_Login_With_Wrong_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login with wrong email format");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Login Link");
        homePage.clickToLoginLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Enter wrong email format");
        loginPage.loginWithEmailAndPassword("23123@cc", "");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify wrong email error message");
        Assert.assertEquals(loginPage.getEmailErrorMessage(), GlobalConstants.MESSAGE_ERROR_WRONG_EMAIL);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
