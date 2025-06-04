package com.nopcommerce.users;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.DetailProductPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

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
        loginPageObject.loginWithEmailAndPassword(ACCOUNT,PASSWORD);
        basePage.openPageUrl(driver, URL + "build-your-own-computer");

        detailProductPageObject = new DetailProductPageObject(driver);
    }

    @Test
    public void TC01_DetailProduct_MissingHDDField(){

        detailProductPageObject.selectProcessor();
        detailProductPageObject.selectRam();
        detailProductPageObject.checkToRadioOS();
        detailProductPageObject.clickButtonAddToCart();

        Assert.assertEquals(detailProductPageObject.getNotification(), NOTIFICATION_MISSING_HDD);
        detailProductPageObject.clickToCloseInNotification();
    }

    @Test
    public void TC02_DetailProduct_MissingProcessorField(){

        detailProductPageObject.unselectProcessor();
        detailProductPageObject.selectRam();
        detailProductPageObject.checkToRadioHDD();
        detailProductPageObject.checkToRadioOS();
        detailProductPageObject.clickButtonAddToCart();

        Assert.assertEquals(detailProductPageObject.getNotification(), NOTIFICATION_MISSING_PROCESSOR);
        detailProductPageObject.clickToCloseInNotification();
    }

    @Test
    public void TC03_DetailProduct_MissingRamField(){

        detailProductPageObject.selectProcessor();
        detailProductPageObject.unselectRam();
        detailProductPageObject.checkToRadioHDD();
        detailProductPageObject.checkToRadioOS();
        detailProductPageObject.clickButtonAddToCart();

        Assert.assertEquals(detailProductPageObject.getNotification(), NOTIFICATION_MISSING_RAM);
        detailProductPageObject.clickToCloseInNotification();
    }

    @Test
    public void TC04_DetailProduct_QuantityEqualZero(){

        detailProductPageObject.selectProcessor();
        detailProductPageObject.selectRam();
        detailProductPageObject.checkToRadioHDD();
        detailProductPageObject.checkToRadioOS();
        detailProductPageObject.enterToQuantityTextbox("0");
        detailProductPageObject.clickButtonAddToCart();

        Assert.assertEquals(detailProductPageObject.getNotification(), NOTIFICATION_QUANTITY_INCORRECT);
        detailProductPageObject.clickToCloseInNotification();
    }

    @Test
    public void TC05_DetailProduct_QuantityNegative(){

        detailProductPageObject.selectProcessor();
        detailProductPageObject.selectRam();
        detailProductPageObject.checkToRadioHDD();
        detailProductPageObject.checkToRadioOS();
        detailProductPageObject.enterToQuantityTextbox("-1");
        detailProductPageObject.clickButtonAddToCart();

        Assert.assertEquals(detailProductPageObject.getNotification(), NOTIFICATION_QUANTITY_INCORRECT);
        detailProductPageObject.clickToCloseInNotification();
    }

    @Test
    public void TC06_DetailProduct_QuantityIsText(){

        detailProductPageObject.selectProcessor();
        detailProductPageObject.selectRam();
        detailProductPageObject.checkToRadioHDD();
        detailProductPageObject.checkToRadioOS();
        detailProductPageObject.enterToQuantityTextbox("t");
        detailProductPageObject.clickButtonAddToCart();

        Assert.assertEquals(detailProductPageObject.getNotification(), NOTIFICATION_QUANTITY_INCORRECT);
        detailProductPageObject.clickToCloseInNotification();
    }

    @Test
    public void TC07_DetailProduct_isRatingDisplay(){
        Assert.assertTrue(detailProductPageObject.isRatingDisplay());
    }

    @Test
    public void TC08_DetailProduct_IsReviewedDisplay(){
        Assert.assertTrue(detailProductPageObject.isReviewedDisplay());
    }

    @Test
    public void TC09_DetailProduct_IsAddReviewUnDisplay(){
        Assert.assertTrue(detailProductPageObject.isAddReviewUnDisplay());
    }

    @Test
    public void TC10_DetailProduct_StockStatus(){
        Assert.assertEquals(detailProductPageObject.getStockStatus(),"Availability: " + STATUS_IN_STOCK);
    }

    @Test
    public void TC11_DetailProduct_SkuStatus(){
        Assert.assertEquals(detailProductPageObject.getSkud(),"SKU: " + STATUS_SKU);
    }

    @Test
    public void TC12_DetailProduct_DeliveryMethod(){
        Assert.assertEquals(detailProductPageObject.getDeliveryMethod(), DELIVERY_METHOD_FREE_SHIPPING);
    }

    @Test
    public void TC13_DetailProduct_ValidateTotalMoney(){

        detailProductPageObject.selectProcessor();
        detailProductPageObject.selectRam();
        detailProductPageObject.checkToRadioHDD();
        detailProductPageObject.checkToRadioOS();
        detailProductPageObject.checkToCheckboxSoftware();
        detailProductPageObject.enterToQuantityTextbox("1");

        Assert.assertEquals(detailProductPageObject.getProductPrice(), "1.315 ₫");
    }

    @Test
    public void TC14_DetailProduct_AddToWishlistSuccess(){
        detailProductPageObject.selectProcessor();
        detailProductPageObject.selectRam();
        detailProductPageObject.checkToRadioHDD();
        detailProductPageObject.checkToRadioOS();
        detailProductPageObject.checkToCheckboxSoftware();
        detailProductPageObject.enterToQuantityTextbox("1");
        detailProductPageObject.clickButtonAddToWishList();
        Assert.assertEquals(detailProductPageObject.getNotification(), NOTIFICATION_ADD_TO_WISHLIST);
        detailProductPageObject.clickToCloseInNotification();
    }

    @Test
    public void TC15_DetailProduct_AddToComparelist(){
        detailProductPageObject.selectProcessor();
        detailProductPageObject.selectRam();
        detailProductPageObject.checkToRadioHDD();
        detailProductPageObject.checkToRadioOS();
        detailProductPageObject.checkToCheckboxSoftware();
        detailProductPageObject.enterToQuantityTextbox("1");
        detailProductPageObject.clickButtonAddToCompareList();
        Assert.assertEquals(detailProductPageObject.getNotification(), NOTIFICATION_ADD_TO_COMPARELIST);
        detailProductPageObject.clickToCloseInNotification();
    }

    @Test
    public void TC16_DetailProduct_ValidateProductName(){
        Assert.assertEquals(detailProductPageObject.getProductName(), "Build your own computer");
    }

    @Test
    public void TC17_DetailProduct_ValidateShortDesciption(){
        Assert.assertEquals(detailProductPageObject.getShortDescription(), "Build it");
    }

    @Test
    public void TC18_DetailProduct_ValidateFullDesciption(){
        Assert.assertTrue(detailProductPageObject.getFullDescription().contains("Fight back against cluttered workspaces with the stylish IBM zBC12 All-in-One desktop PC"));
    }

    @Test
    public void TC19_DetailProduct_EmailAFriend(){
        detailProductPageObject.clickButtonEmailAFriend();
        Assert.assertEquals(detailProductPageObject.getTitleRedirectEmail(), "Build your own computer");
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
