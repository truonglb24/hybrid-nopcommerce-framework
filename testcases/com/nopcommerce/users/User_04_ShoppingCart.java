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
import pageObjects.ShoppingCartPageObject;
import pageObjects.DetailProductPageObject;
import reportConfigs.ExtentTestManager;

import java.lang.reflect.Method;

public class User_04_ShoppingCart extends BaseTest {

    WebDriver driver;
    BasePage basePage;
    LoginPageObject loginPage;
    HomePageObject homePage;
    ShoppingCartPageObject shoppingCartPage;
    DetailProductPageObject detailProductPage;

    // Test data
    private String validCouponCode = "KLC";
    private String invalidCouponCode = "INVALID123";
    private String validGiftCardCode = "KLC";
    private String invalidGiftCardCode = "INVALID456";

    // Precondition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) throws InterruptedException {
        driver = getBrowserDriver(browserName);
        basePage = new BasePage();

        homePage = new HomePageObject(driver);
        loginPage = new LoginPageObject(driver);
        shoppingCartPage = new ShoppingCartPageObject(driver);
        detailProductPage = new DetailProductPageObject(driver);
        homePage.clickToLoginLink();
        loginPage.loginWithEmailAndPassword(GlobalConstants.ACCOUNT,GlobalConstants.PASSWORD);
        // Navigate to cart page
        Thread.sleep(2000);
        basePage.openPageUrl(driver, GlobalConstants.URL + "cart");
        basePage.refeshCurrentPAge(driver);
    }

    @Test
    public void TC01_Verify_Shopping_Cart_Display_Elements(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify Shopping Cart Display Elements");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open shopping cart");
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Verify product SKU number");
        Assert.assertEquals(shoppingCartPage.getProductSkuNumber(), GlobalConstants.STATUS_SKU);

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify Image product loaded");
        Assert.assertTrue(shoppingCartPage.isImageProductLoaded());

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify product name contains 'Build your own computer'");
        Assert.assertTrue(shoppingCartPage.getProductName().contains("Build your own computer"));

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify product attributes contain system specifications");
        Assert.assertTrue(shoppingCartPage.getProductAttributes().contains("Processor RAM HDD OS Software"));

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify edit button is displayed");
        Assert.assertTrue(shoppingCartPage.isEditButtonDisplay());

        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Verify unit price contains currency symbol");
        Assert.assertTrue(shoppingCartPage.getUnitPrice().contains("₫"));

        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Verify remove cart button is displayed");
        Assert.assertTrue(shoppingCartPage.isRemoveCartDisplay());

        ExtentTestManager.getTest().log(Status.INFO, "Step 09: Verify continue shopping button is displayed");
        Assert.assertTrue(shoppingCartPage.isButtonContinueShoppingDisplay());

        ExtentTestManager.getTest().log(Status.INFO, "Step 10: Verify estimate shipping button is displayed");
        Assert.assertTrue(shoppingCartPage.isButtonEstimateShipping());
        ExtentTestManager.getTest().log(Status.INFO, "Step 11: Verify Order discount left display");
        Assert.assertTrue(shoppingCartPage.isOrderDiscountLeftDisplay());

        ExtentTestManager.getTest().log(Status.INFO, "Step 12: Verify Order Discount Total Left Displayed");
        Assert.assertTrue(shoppingCartPage.isOrderDiscountTotalLeftDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Step 13: Verify Order Earn Reward Left Displayed");
        Assert.assertTrue(shoppingCartPage.isOrderEarnRewardLeftDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Step 14: Verify Order Shipping Left Displayed");
        Assert.assertTrue(shoppingCartPage.isOrderShippingLeftDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Step 15: Verify Order GiftCard Left Displayed");
        Assert.assertTrue(shoppingCartPage.isOrderGiftCardLeftDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Step 16: Verify Order Tax Left Displayed");
        Assert.assertTrue(shoppingCartPage.isOrderTaxLeftDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Step 17: Verify Sub Total Left Displayed");
        Assert.assertTrue(shoppingCartPage.isSubTotalLeftDisplay());
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