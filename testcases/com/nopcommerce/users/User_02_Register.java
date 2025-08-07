package com.nopcommerce.users;

import com.aventstack.extentreports.Status;
import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import reportConfigs.ExtentTestManager;

import java.lang.reflect.Method;

public class User_02_Register extends BaseTest {

    WebDriver driver;
    BasePage basePage;
    private RegisterPageObject registerPage;
    private HomePageObject homePage;
    private String firstName, lastName, emailAddress, companyName, password;
    // Precondition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){

        driver = getBrowserDriver(browserName);

        basePage = new BasePage();
        homePage = new HomePageObject(driver);
        registerPage = new RegisterPageObject(driver);

        firstName = "Test";
        lastName = "VN";
        emailAddress = generateRandomNumber() + "@gmail.com";
        companyName = "Rabiloo";
        password = "123123";
    }

    @Test
    public void TC01_Register_With_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register with empty data");

        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Register Link");
        homePage.clickToRegisterLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to Register Button without entering any data");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify First Name error message");
        Assert.assertEquals(registerPage.getFirstNameErrorMessage(), GlobalConstants.MESSAGE_ERROR_FIRSTNAME_REQUIRED);

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify Last Name error message");
        Assert.assertEquals(registerPage.getLastNameErrorMessage(), GlobalConstants.MESSAGE_ERROR_LASTNAME_REQUIRED);

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify Email error message");
        Assert.assertEquals(registerPage.getEmailErrorMessage(), GlobalConstants.MESSAGE_ERROR_EMAIL_REQUIRED);

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify Password error message");
        Assert.assertEquals(registerPage.getPasswordErrorMessage(), GlobalConstants.MESSAGE_ERROR_PASSWORD_REQUIRED);

        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Verify Confirm Password error message");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), GlobalConstants.MESSAGE_ERROR_PASSWORD_REQUIRED);
    }

    @Test
    public void TC02_Register_With_Invalid_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register with invalid email");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Register Link");
        homePage.clickToRegisterLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Enter valid data except invalid email format");
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox("abc@.com");
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click Register Button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify email error message");
        Assert.assertEquals(registerPage.getEmailErrorMessage(), GlobalConstants.MESSAGE_ERROR_FORMAT_EMAIL);
    }

    @Test
    public void TC03_Register_With_Short_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register with short password");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Register Link");
        homePage.clickToRegisterLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Enter short password");
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123");
        registerPage.enterToConfirmPasswordTextbox("123");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click Register Button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify password format error message");
        Assert.assertEquals(registerPage.getPasswordErrorMessage(), GlobalConstants.MESSAGE_ERROR_PASSWORD_INCORRECT_FORMAT);
    }

    @Test
    public void TC04_Register_With_Password_Mismatch(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register with mismatched password");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Register Link");
        homePage.clickToRegisterLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Enter mismatched password and confirm password");
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("password");
        registerPage.enterToConfirmPasswordTextbox("123456");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click Register Button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify password mismatch error message");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), GlobalConstants.MESSAGE_ERROR_PASSWORD_NOT_MATCH);
    }

    @Test
    public void TC05_Register_With_Existing_Email_With_Whitespace_Or_Uppercase(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register with email containing space or uppercase");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Register Link");
        homePage.clickToRegisterLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Enter email with whitespace");
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox("78708  @gmail.com");
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click Register Button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify invalid email format error");
        Assert.assertEquals(registerPage.getEmailErrorMessage(), GlobalConstants.MESSAGE_ERROR_FORMAT_EMAIL);
    }

    @Test
    public void TC06_Register_With_Invalid_Email_Domain(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register with invalid email domain");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Register Link");
        homePage.clickToRegisterLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Enter invalid email domain");
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox("78708@gmail");
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click Register Button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify wrong email error message");
        Assert.assertEquals(registerPage.getEmailErrorMessage(), GlobalConstants.MESSAGE_ERROR_WRONG_EMAIL);
    }

    @Test
    public void TC07_Register_Without_Newsletter(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register without checking newsletter");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Register Link");
        homePage.clickToRegisterLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Fill in valid data and uncheck newsletter");
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.uncheckNewLetter();
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click Register Button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify register success");
        Assert.assertTrue(registerPage.isDisplayRegisterSuccesMessage());

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Logout");
        homePage.clickToLogoutLink();
    }

    @Test
    public void TC08_Register_With_Existing_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register with existing email");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Register Link");
        homePage.clickToRegisterLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Enter data with existing email");
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click Register Button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify existing email error message");
        Assert.assertEquals(registerPage.getEmailExistErrorMessage(), GlobalConstants.MESSAGE_ERROR_EMAIL_EXIST);
    }

    @Test
    public void TC09_Register_With_Company_Name(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register with company name");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Register Link");
        homePage.clickToRegisterLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Fill in all required fields and company name");
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(firstName + lastName + emailAddress);
        registerPage.enterToCompanyTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click Register Button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify register success");
        Assert.assertTrue(registerPage.isDisplayRegisterSuccesMessage());
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
