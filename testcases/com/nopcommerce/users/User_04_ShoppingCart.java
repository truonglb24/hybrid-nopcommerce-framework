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
import pageObjects.ShoppingCartPageObject;
import pageObjects.DetailProductPageObject;

public class User_04_ShoppingCart extends BaseTest {

    WebDriver driver;
    BasePage basePage;
    LoginPageObject loginPage;
    HomePageObject homePage;
    ShoppingCartPageObject shoppingCartPage;
    DetailProductPageObject detailProductPage;

    // Test data
    private String validCouponCode = "SAVE10";
    private String invalidCouponCode = "INVALID123";
    private String validGiftCardCode = "GIFT100";
    private String invalidGiftCardCode = "INVALID456";

    // Precondition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        basePage = new BasePage();

        homePage = new HomePageObject(driver);
        loginPage = new LoginPageObject(driver);
        shoppingCartPage = new ShoppingCartPageObject(driver);
        detailProductPage = new DetailProductPageObject(driver);
        homePage.clickToLoginLink();
        loginPage.loginWithEmailAndPassword(GlobalConstants.ACCOUNT,GlobalConstants.PASSWORD);
        // Navigate to cart page
        basePage.openPageUrl(driver, GlobalConstants.URL + "cart");
        basePage.refeshCurrentPAge(driver);
    }

    @Test
    public void TC01_Verify_Shopping_Cart_Display_Elements() {

    }

    @Test
    public void TC02_Update_Product_Quantity() {

    }

    @Test
    public void TC03_Apply_Valid_Coupon_Code() {

    }

    @Test
    public void TC04_Apply_Invalid_Coupon_Code() {

    }

    @Test
    public void TC05_Apply_Valid_Gift_Card() {

    }

    @Test
    public void TC06_Apply_Invalid_Gift_Card() {

    }

    @Test
    public void TC07_Select_Gift_Wrapping_Options() {

    }

    @Test
    public void TC08_Verify_Order_Totals_Calculation() {

    }

    @Test
    public void TC09_Edit_Product_From_Cart() {

    }

    @Test
    public void TC10_Continue_Shopping_And_Estimate_Shipping() {

    }

    @Test
    public void TC11_Terms_Of_Service_And_Checkout() {

    }

    @Test
    public void TC12_Remove_Product_From_Cart() {

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}