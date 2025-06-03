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
    public void TC15_DetailProduct_VerifyDefaultStateOfProduct(){

        detailProductPageObject.selectProcessor();
        detailProductPageObject.selectRam();
    }
    @AfterClass
    public void afterClass(){
        //driver.quit();
    }
}
