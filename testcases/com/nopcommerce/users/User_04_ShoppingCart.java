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
    private String validCouponCode = "KLCCODE";
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

//        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify Image product loaded");
//        Assert.assertTrue(shoppingCartPage.isImageProductLoaded());

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify product name contains 'Build your own computer'");
        Assert.assertTrue(shoppingCartPage.getProductName().contains("Build your own computer"));

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify product attributes contain system specifications");
        Assert.assertTrue(shoppingCartPage.getProductAttributes().contains("Processor"));

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

        ExtentTestManager.getTest().log(Status.INFO, "Step 11: Verify Order Earn Reward Left Displayed");
        Assert.assertTrue(shoppingCartPage.isOrderEarnRewardLeftDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Step 12: Verify Order Shipping Left Displayed");
        Assert.assertTrue(shoppingCartPage.isOrderShippingLeftDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Step 13: Verify Order Tax Left Displayed");
        Assert.assertTrue(shoppingCartPage.isOrderTaxLeftDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Step 14: Verify Sub Total Left Displayed");
        Assert.assertTrue(shoppingCartPage.isSubTotalLeftDisplay());
    }

    @Test
    public void TC02_Update_Product_Quantity() {
        ExtentTestManager.startTest("TC02_Update_Product_Quantity", "Verify product quantity update in shopping cart");
        log.info("Get current product quantity");
        int quantityNumber = Integer.valueOf(shoppingCartPage.getQuantityNumber());

        log.info("Click quantity up button");
        shoppingCartPage.clickToQuantityUp();
        log.info("Verify quantity increased by 1");
        Assert.assertEquals(Integer.valueOf(shoppingCartPage.getQuantityNumber()), Integer.valueOf(quantityNumber + 1));

        log.info("Get updated product quantity");
        quantityNumber = Integer.valueOf(shoppingCartPage.getQuantityNumber());

        log.info("Click quantity down button");
        shoppingCartPage.clickToQuantityDown();
        log.info("Verify quantity decreased by 1");
        Assert.assertEquals(Integer.valueOf(shoppingCartPage.getQuantityNumber()), Integer.valueOf(quantityNumber - 1));
    }

    @Test
    public void TC03_Apply_Valid_Coupon_Code() {
        ExtentTestManager.startTest("TC03_Apply_Valid_Coupon_Code", "Verify applying a valid coupon code");
        log.info("Enter valid coupon code: " + validCouponCode);
        shoppingCartPage.enteringDiscountCouponCode(validCouponCode);

        log.info("Click Apply Coupon button");
        shoppingCartPage.clickButtonApplyCoupon();

        log.info("Verify success message for coupon");
        Assert.assertEquals(shoppingCartPage.getMessageCouponSuccess(), GlobalConstants.MESSAGE_APPLY_COUPON_SUCCESS);

        log.info("Verify current coupon code displayed");
        Assert.assertEquals(shoppingCartPage.getMessageCurrentCode(), GlobalConstants.MESSAGE_COUPON_ENTERED + validCouponCode);

        log.info("Remove coupon code");
        shoppingCartPage.clickButtonRemoveDiscount();
    }

    @Test
    public void TC04_Apply_Invalid_Coupon_Code() {
        ExtentTestManager.startTest("TC04_Apply_Invalid_Coupon_Code", "Verify applying an invalid coupon code");
        log.info("Enter invalid coupon code: " + invalidCouponCode);
        shoppingCartPage.enteringDiscountCouponCode(invalidCouponCode);

        log.info("Click Apply Coupon button");
        shoppingCartPage.clickButtonApplyCoupon();

        log.info("Verify error message for non-existing coupon");
        Assert.assertEquals(shoppingCartPage.getMessageCouponFailure(), GlobalConstants.MESSAGE_COUPON_NOT_EXIST);
    }

    @Test
    public void TC05_Apply_Valid_Gift_Card() {
        ExtentTestManager.startTest("TC05_Apply_Valid_Gift_Card", "Verify applying a valid gift card");
        log.info("Enter valid gift card code: " + validGiftCardCode);
        shoppingCartPage.enteringGiftCard(validGiftCardCode);

        log.info("Click Add Gift Card button");
        shoppingCartPage.clickButtonAddGiftCard();

        log.info("Verify success message for gift card");
        Assert.assertEquals(shoppingCartPage.getMessageGiftCardSuccess(), GlobalConstants.MESSAGE_APPLY_GIFTCARD_SUCCESS);

        log.info("Remove gift card");
        shoppingCartPage.clickButtonRemoveGiftCard();
    }

    @Test
    public void TC06_Apply_Invalid_Gift_Card() {
        ExtentTestManager.startTest("TC06_Apply_Invalid_Gift_Card", "Verify applying an invalid gift card");
        log.info("Enter invalid gift card code: " + invalidGiftCardCode);
        shoppingCartPage.enteringGiftCard(invalidGiftCardCode);

        log.info("Click Add Gift Card button");
        shoppingCartPage.clickButtonAddGiftCard();

        log.info("Verify error message for non-existing gift card");
        Assert.assertEquals(shoppingCartPage.getMessageGiftCardFailure(), GlobalConstants.MESSAGE_CARD_NOT_EXIST);
    }

    @Test
    public void TC07_Select_Gift_Wrapping_Options() throws InterruptedException {
        ExtentTestManager.startTest("TC07_Select_Gift_Wrapping_Options", "Verify selecting gift wrapping option");
        log.info("Select 'No' gift wrapping option");
        shoppingCartPage.selectGiftWrappingIsNo();
        Thread.sleep(2000);

        log.info("Verify selected gift wrapping option is 'No'");
        Assert.assertEquals(shoppingCartPage.getWrappingSelected(), GlobalConstants.GIFT_WRAPPING_IS_NO);
    }

    @Test
    public void TC08_Verify_Order_Totals_Calculation() {
        ExtentTestManager.startTest("TC08_Verify_Order_Totals_Calculation", "Verify order total equals price * quantity");
        log.info("Get unit price and remove currency");
        Double priceNumber = Double.valueOf(shoppingCartPage.getUnitPrice().replaceAll("\\s?₫", ""));

        log.info("Get product quantity");
        int quantityNumber = Integer.valueOf(shoppingCartPage.getQuantityNumber());

        log.info("Verify order total amount matches calculation");
        Assert.assertEquals(
                Double.valueOf(shoppingCartPage.getOrderTotalAmount().replaceAll("\\s?₫", "")),
                Double.valueOf(priceNumber * quantityNumber)
        );
    }

    @Test
    public void TC09_Edit_Product_From_Cart() throws InterruptedException {
        ExtentTestManager.startTest("TC09_Edit_Product_From_Cart", "Verify editing product quantity from cart");
        log.info("Get current quantity");
        int quantityNumber = Integer.valueOf(shoppingCartPage.getQuantityNumber());

        log.info("Click Edit button");
        shoppingCartPage.clickEditButton();

        log.info("Increase quantity by 1 in product detail page");
        detailProductPage.enterToQuantityTextbox(String.valueOf(quantityNumber + 1));

        log.info("Click Add To Cart button");
        detailProductPage.clickButtonAddToCart();

        log.info("Go to cart");
        detailProductPage.clickToCart();

        log.info("Verify quantity increased by 1");
        Assert.assertEquals(Integer.valueOf(shoppingCartPage.getQuantityNumber()), Integer.valueOf(quantityNumber + 1));
    }

    @Test
    public void TC10_Continue_Shopping_And_Estimate_Shipping() throws InterruptedException {
        ExtentTestManager.startTest("TC10_Continue_Shopping_And_Estimate_Shipping", "Verify continue shopping and estimate shipping");
        log.info("Click Continue Shopping button");
        shoppingCartPage.clickButtonContinueShopping();

        log.info("Verify redirected to electronics page");
        Assert.assertTrue(basePage.getPageUrl(driver).contains("/electronics"));

        log.info("Go back to cart");
        detailProductPage.clickToCart();

        log.info("Click Estimate Shipping button");
        shoppingCartPage.clickButtonEstimateShipping();
        Thread.sleep(2000);

        log.info("Click Apply Shipping button");
        shoppingCartPage.clickButtonApply();

        log.info("Verify Subtotal Left is displayed");
        Assert.assertTrue(shoppingCartPage.isSubTotalLeftDisplay());
    }

    @Test
    public void TC11_Terms_Of_Service_And_Checkout() throws InterruptedException {
        ExtentTestManager.startTest("TC11_Terms_Of_Service_And_Checkout", "Verify terms of service checkbox and checkout process");
        Thread.sleep(4000);

        log.info("Click Terms of Service checkbox");
        shoppingCartPage.clickCheckboxTermOfService();

        log.info("Click Checkout button");
        shoppingCartPage.clickButtonCheckout();

        log.info("Verify redirected to one page checkout");
        Assert.assertTrue(basePage.getPageUrl(driver).contains("/onepagecheckout"));

        log.info("Go back to cart");
        detailProductPage.clickToCart();
    }

    @Test
    public void TC12_Remove_Product_From_Cart() {
        ExtentTestManager.startTest("TC12_Remove_Product_From_Cart", "Verify removing product from cart");
        log.info("Click Remove Cart button");
        shoppingCartPage.clickToRemoveCart();

        log.info("Verify cart is empty");
        Assert.assertEquals(shoppingCartPage.getOrderSummary(), GlobalConstants.MESSAGE_CART_EMPTY);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}