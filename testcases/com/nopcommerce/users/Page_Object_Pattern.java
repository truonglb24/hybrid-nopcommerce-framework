package com.nopcommerce.users;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;

public class Page_Object_Pattern extends BaseTest {

    // Declare Variables
    private WebDriver driver;

    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;
    private CustomerInfoPageObject customerInfoPage;

    private BasePage basePage;
    private String firstName, lastName, emailAddress, companyName, password;
    // Precondition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){

        driver = getBrowserDriver(browserName);

        basePage = new BasePage();
        homePage = new HomePageObject(driver);
        firstName = "Test";
        lastName = "VN";
        emailAddress = "" + generateRandomNumber() + "@gmail.com";
        companyName = "Rabiloo";
        password = "123123";
    }

    // Testcases
    @Test
    public void TC_01_Register(){
        homePage.clickToRegisterLink();

        // HomePage move to RegisterPage
        registerPage = new RegisterPageObject(driver);
        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccesMessage(), "Your registration completed");
    }

    @Test
    public void TC_02_Logout(){
        registerPage.clickToLogoutLink();
        // Login Page move to Home Page
        homePage = new HomePageObject(driver);
        homePage.clickToLoginLink();
        // Register Page move to Login Page
        loginPage = new LoginPageObject(driver);

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        // Login Page move to Home Page
        homePage = new HomePageObject(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void TC_03_MyAccount(){
        homePage.clickToMyAccountLink();

        // Home Page move to Customer Info Page
        customerInfoPage = new CustomerInfoPageObject(driver);

        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyNameTextboxValue(), companyName);

    }

    // Post-condition
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
