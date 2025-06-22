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
import pageObjects.DetailProductPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import reportConfigs.ExtentTestManager;

import java.lang.reflect.Method;

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
        loginPageObject.loginWithEmailAndPassword(GlobalConstants.ACCOUNT,GlobalConstants.PASSWORD);
        basePage.openPageUrl(driver, GlobalConstants.URL + "build-your-own-computer");

        detailProductPageObject = new DetailProductPageObject(driver);
        basePage.refeshCurrentPAge(driver);
    }

    @Test
    public void TC01_DetailProduct_MissingHDDField(Method method) {
        ExtentTestManager.startTest(method.getName(), "Missing HDD Field");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Select Processor");
        detailProductPageObject.selectProcessor();
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select RAM");
        detailProductPageObject.selectRam();
        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select OS");
        detailProductPageObject.checkToRadioOS();
        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click Add to Cart");
        detailProductPageObject.clickButtonAddToCart();
        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify notification for missing HDD is shown");
        Assert.assertEquals(detailProductPageObject.getNotification(), GlobalConstants.NOTIFICATION_MISSING_HDD);
        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Close notification");
        detailProductPageObject.clickToCloseInNotification();
    }

    @Test
    public void TC02_DetailProduct_MissingProcessorField(Method method) {
        ExtentTestManager.startTest(method.getName(), "Missing Processor Field");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Unselect Processor");
        detailProductPageObject.unselectProcessor();
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select RAM");
        detailProductPageObject.selectRam();
        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select HDD");
        detailProductPageObject.checkToRadioHDD();
        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Select OS");
        detailProductPageObject.checkToRadioOS();
        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Click Add to Cart");
        detailProductPageObject.clickButtonAddToCart();
        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify notification for missing Processor is shown");
        Assert.assertEquals(detailProductPageObject.getNotification(), GlobalConstants.NOTIFICATION_MISSING_PROCESSOR);
        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Close notification");
        detailProductPageObject.clickToCloseInNotification();
    }

    @Test
    public void TC03_DetailProduct_MissingRamField(Method method) {
        ExtentTestManager.startTest(method.getName(), "Missing RAM Field");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Select Processor");
        detailProductPageObject.selectProcessor();
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Unselect RAM");
        detailProductPageObject.unselectRam();
        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select HDD");
        detailProductPageObject.checkToRadioHDD();
        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Select OS");
        detailProductPageObject.checkToRadioOS();
        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Click Add to Cart");
        detailProductPageObject.clickButtonAddToCart();
        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify notification for missing RAM is shown");
        Assert.assertEquals(detailProductPageObject.getNotification(), GlobalConstants.NOTIFICATION_MISSING_RAM);
        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Close notification");
        detailProductPageObject.clickToCloseInNotification();
    }

    @Test
    public void TC04_DetailProduct_QuantityEqualZero(Method method) {
        ExtentTestManager.startTest(method.getName(), "Quantity Equal Zero");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Select Processor");
        detailProductPageObject.selectProcessor();
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select RAM");
        detailProductPageObject.selectRam();
        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select HDD");
        detailProductPageObject.checkToRadioHDD();
        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Select OS");
        detailProductPageObject.checkToRadioOS();
        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Enter Quantity = 0");
        detailProductPageObject.enterToQuantityTextbox("0");
        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Click Add to Cart");
        detailProductPageObject.clickButtonAddToCart();
        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Verify notification for incorrect quantity is shown");
        Assert.assertEquals(detailProductPageObject.getNotification(), GlobalConstants.NOTIFICATION_QUANTITY_INCORRECT);
        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Close notification");
        detailProductPageObject.clickToCloseInNotification();
    }

    @Test
    public void TC05_DetailProduct_QuantityNegative(Method method){

        ExtentTestManager.startTest(method.getName(), "Quantity is Negative number");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Select Processor");
        detailProductPageObject.selectProcessor();
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select RAM");
        detailProductPageObject.selectRam();
        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select HDD");
        detailProductPageObject.checkToRadioHDD();
        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Select OS");
        detailProductPageObject.checkToRadioOS();
        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Enter Quantity = -1");
        detailProductPageObject.enterToQuantityTextbox("-1");
        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Click Add to Cart");
        detailProductPageObject.clickButtonAddToCart();
        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Verify notification for incorrect quantity is shown");
        Assert.assertEquals(detailProductPageObject.getNotification(), GlobalConstants.NOTIFICATION_QUANTITY_INCORRECT);
        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Close notification");
        detailProductPageObject.clickToCloseInNotification();
    }

    @Test
    public void TC06_DetailProduct_QuantityIsText(Method method){

        ExtentTestManager.startTest(method.getName(), "Quantity is text");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Select Processor");
        detailProductPageObject.selectProcessor();
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select RAM");
        detailProductPageObject.selectRam();
        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select HDD");
        detailProductPageObject.checkToRadioHDD();
        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Select OS");
        detailProductPageObject.checkToRadioOS();
        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Enter Quantity = t");
        detailProductPageObject.enterToQuantityTextbox("t");
        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Click Add to Cart");
        detailProductPageObject.clickButtonAddToCart();

        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Verify notification for incorrect quantity is shown");
        Assert.assertEquals(detailProductPageObject.getNotification(), GlobalConstants.NOTIFICATION_QUANTITY_INCORRECT);
        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Close notification");
        detailProductPageObject.clickToCloseInNotification();
    }

    @Test
    public void TC07_DetailProduct_IsRatingDisplay(Method method){
        ExtentTestManager.startTest(method.getName(), "IsRatingDisplay");
        ExtentTestManager.getTest().log(Status.INFO, "IsRatingDisplay");
        Assert.assertTrue(detailProductPageObject.isRatingDisplay());
    }

    @Test
    public void TC08_DetailProduct_IsReviewedDisplay(Method method){
        ExtentTestManager.startTest(method.getName(), "IsReviewedDisplay");
        ExtentTestManager.getTest().log(Status.INFO, "IsReviewedDisplay");
        Assert.assertTrue(detailProductPageObject.isReviewedDisplay());
    }

    @Test
    public void TC09_DetailProduct_IsAddReviewUnDisplay(Method method){
        ExtentTestManager.startTest(method.getName(), "IsAddReviewUnDisplay");
        ExtentTestManager.getTest().log(Status.INFO, "IsAddReviewUnDisplay");
        Assert.assertTrue(detailProductPageObject.isAddReviewUnDisplay());
    }

    @Test
    public void TC10_DetailProduct_StockStatus(Method method){
        ExtentTestManager.startTest(method.getName(), "StockStatus");
        ExtentTestManager.getTest().log(Status.INFO, "StockStatus");
        Assert.assertEquals(detailProductPageObject.getStockStatus(),"Availability: " + GlobalConstants.STATUS_IN_STOCK);
    }

    @Test
    public void TC11_DetailProduct_SkuStatus(Method method){
        ExtentTestManager.startTest(method.getName(), "SkuStatus");
        ExtentTestManager.getTest().log(Status.INFO, "SkuStatus");
        Assert.assertEquals(detailProductPageObject.getSkud(),"SKU: " + GlobalConstants.STATUS_SKU);
    }

    @Test
    public void TC12_DetailProduct_DeliveryMethod(Method method){
        ExtentTestManager.startTest(method.getName(), "DeliveryMethod");
        ExtentTestManager.getTest().log(Status.INFO, "DeliveryMethod");
        Assert.assertEquals(detailProductPageObject.getDeliveryMethod(), GlobalConstants.DELIVERY_METHOD_FREE_SHIPPING);
    }

    @Test
    public void TC13_DetailProduct_ValidateTotalMoney(Method method){
        ExtentTestManager.startTest(method.getName(), "ValidateTotalMoney");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Select Processor");
        detailProductPageObject.selectProcessor();
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select RAM");
        detailProductPageObject.selectRam();
        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select HDD");
        detailProductPageObject.checkToRadioHDD();
        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Select OS");
        detailProductPageObject.checkToRadioOS();
        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Select Checkbox Software");
        detailProductPageObject.checkToCheckboxSoftware();
        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Enter Quantity = 1");
        detailProductPageObject.enterToQuantityTextbox("1");
        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Verify Total money");
        Assert.assertEquals(detailProductPageObject.getProductPrice(), "1.315 ₫");
    }

    @Test
    public void TC14_DetailProduct_AddToWishlistSuccess(Method method){
        ExtentTestManager.startTest(method.getName(), "AddToWishlistSuccess");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Select Processor");
        detailProductPageObject.selectProcessor();
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select RAM");
        detailProductPageObject.selectRam();
        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select HDD");
        detailProductPageObject.checkToRadioHDD();
        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Select OS");
        detailProductPageObject.checkToRadioOS();
        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Select Checkbox Software");
        detailProductPageObject.checkToCheckboxSoftware();
        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Enter Quantity = 1");
        detailProductPageObject.enterToQuantityTextbox("1");
        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Click to button AddToWishList");
        detailProductPageObject.clickButtonAddToWishList();
        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Verify notification for success is shown");
        Assert.assertEquals(detailProductPageObject.getNotification(), GlobalConstants.NOTIFICATION_ADD_TO_WISHLIST);
        ExtentTestManager.getTest().log(Status.INFO, "Step 09: Close notification");
        detailProductPageObject.clickToCloseInNotification();
    }

    @Test
    public void TC15_DetailProduct_AddToComparelist(Method method){
        ExtentTestManager.startTest(method.getName(), "Add To Wish list Success");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Select Processor");
        detailProductPageObject.selectProcessor();
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select RAM");
        detailProductPageObject.selectRam();
        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select HDD");
        detailProductPageObject.checkToRadioHDD();
        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Select OS");
        detailProductPageObject.checkToRadioOS();
        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Select Checkbox Software");
        detailProductPageObject.checkToCheckboxSoftware();
        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Enter Quantity = 1");
        detailProductPageObject.enterToQuantityTextbox("1");
        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Click to button AddToCompareList");
        detailProductPageObject.clickButtonAddToCompareList();
        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Verify notification for success is shown");
        Assert.assertEquals(detailProductPageObject.getNotification(), GlobalConstants.NOTIFICATION_ADD_TO_COMPARELIST);
        ExtentTestManager.getTest().log(Status.INFO, "Step 09: Close notification");
        detailProductPageObject.clickToCloseInNotification();
    }

    @Test
    public void TC16_DetailProduct_ValidateProductName(Method method){
        ExtentTestManager.startTest(method.getName(), "Validate Product Name");
        ExtentTestManager.getTest().log(Status.INFO, "Verify prodcut name is correct");
        Assert.assertEquals(detailProductPageObject.getProductName(), "Build your own computer");
    }

    @Test
    public void TC17_DetailProduct_ValidateShortDesciption(Method method){
        ExtentTestManager.startTest(method.getName(), "Validate Short Desciption");
        ExtentTestManager.getTest().log(Status.INFO, "Verify Short Desciption is correct");
        Assert.assertEquals(detailProductPageObject.getShortDescription(), "Build it");
    }

    @Test
    public void TC18_DetailProduct_ValidateFullDesciption(Method method){
        ExtentTestManager.startTest(method.getName(), "Validate Full Desciption");
        ExtentTestManager.getTest().log(Status.INFO, "Verify Full Desciption is correct");
        Assert.assertTrue(detailProductPageObject.getFullDescription().contains("Fight back against cluttered workspaces with the stylish IBM zBC12 All-in-One desktop PC"));
    }

    @Test
    public void TC19_DetailProduct_EmailAFriend(Method method){
        ExtentTestManager.startTest(method.getName(), "EmailAFriend");
        ExtentTestManager.getTest().log(Status.INFO, "Click button EmailAFriend");
        detailProductPageObject.clickButtonEmailAFriend();
        ExtentTestManager.getTest().log(Status.INFO, "Verify button is enable and click then redirect to email tab");
        Assert.assertEquals(detailProductPageObject.getTitleRedirectEmail(), "Build your own computer");
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}