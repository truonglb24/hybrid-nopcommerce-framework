package com.nopcommerce.users;

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
    public void TC01_Register_With_Empty_Data() {
        homePage.clickToRegisterLink();
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameErrorMessage(), GlobalConstants.MESSAGE_ERROR_FIRSTNAME_REQUIRED);
        Assert.assertEquals(registerPage.getLastNameErrorMessage(), GlobalConstants.MESSAGE_ERROR_LASTNAME_REQUIRED);
        Assert.assertEquals(registerPage.getEmailErrorMessage(), GlobalConstants.MESSAGE_ERROR_EMAIL_REQUIRED);
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), GlobalConstants.MESSAGE_ERROR_PASSWORD_REQUIRED);
    }

    @Test
    public void TC02_Register_With_Invalid_Email() {
        homePage.clickToRegisterLink();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox("abc@.com");
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getEmailErrorMessage(), GlobalConstants.MESSAGE_ERROR_FORMAT_EMAIL);
    }

    @Test
    public void TC03_Register_With_Short_Password() {
        homePage.clickToRegisterLink();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123");
        registerPage.enterToConfirmPasswordTextbox("123");
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getPasswordErrorMessage(), GlobalConstants.MESSAGE_ERROR_PASSWORD_INCORRECT_FORMAT);
    }

    @Test
    public void TC04_Register_With_Password_Mismatch() {
        homePage.clickToRegisterLink();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("password");
        registerPage.enterToConfirmPasswordTextbox("123456");
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), GlobalConstants.MESSAGE_ERROR_PASSWORD_NOT_MATCH);
    }
    @Test
    public void TC05_Register_With_Existing_Email_With_Whitespace_Or_Uppercase() {
        homePage.clickToRegisterLink();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox("78708  @gmail.com");
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getEmailErrorMessage(), GlobalConstants.MESSAGE_ERROR_FORMAT_EMAIL);
    }

    @Test
    public void TC06_Register_With_Invalid_Email_Domain() {
        homePage.clickToRegisterLink();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox("78708@gmail");
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getEmailErrorMessage(), GlobalConstants.MESSAGE_ERROR_WRONG_EMAIL);
    }

    @Test
    public void TC07_Register_Without_Newsletter() {
        homePage.clickToRegisterLink();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.uncheckNewLetter();
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertTrue(registerPage.isDisplayRegisterSuccesMessage());
        homePage.clickToLogoutLink();
    }
    @Test
    public void TC08_Register_With_Existing_Email() {
        homePage.clickToRegisterLink();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getEmailExistErrorMessage(), GlobalConstants.MESSAGE_ERROR_EMAIL_EXIST);
    }
    @Test
    public void TC09_Register_With_Company_Name() {
        homePage.clickToRegisterLink();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(firstName+lastName+emailAddress);
        registerPage.enterToCompanyTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertTrue(registerPage.isDisplayRegisterSuccesMessage());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
