package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.DetailProductPageUI;
import pageUIs.LoginPageUI;

public class DetailProductPageObject extends BasePage {
    private WebDriver driver;

    public DetailProductPageObject(WebDriver driver){
        this.driver = driver;
    }

    public String getProductName (){
        waitForElementVisible(driver, DetailProductPageUI.PRODUCT_NAME);
        return getElementText(driver, DetailProductPageUI.PRODUCT_NAME);
    }

    public String getTitleRedirectEmail (){
        waitForElementVisible(driver, DetailProductPageUI.EMAIL_TITLE);
        return getElementText(driver, DetailProductPageUI.EMAIL_TITLE);
    }

    public String getShortDescription (){
        waitForElementVisible(driver, DetailProductPageUI.SHORT_DESCRIPTION);
        return getElementText(driver, DetailProductPageUI.SHORT_DESCRIPTION);
    }

    public boolean isRatingDisplay(){
        waitForElementVisible(driver, DetailProductPageUI.RATING);
        return isElementDisplayed(driver, DetailProductPageUI.RATING);
    }

    public boolean isAddReviewUnDisplay(){
        waitForElementInvisible(driver, DetailProductPageUI.ADD_PRODUCT_REVIEW_lINK);
        return isElementNotVisible(driver, DetailProductPageUI.ADD_PRODUCT_REVIEW_lINK);
    }

    public boolean isReviewedDisplay(){
        waitForElementVisible(driver, DetailProductPageUI.PRODUCT_REVIEWED_lINK);
        return isElementDisplayed(driver, DetailProductPageUI.PRODUCT_REVIEWED_lINK);
    }

    public String getStockStatus (){
        waitForElementVisible(driver, DetailProductPageUI.STOCK_STATUS);
        return getElementText(driver, DetailProductPageUI.STOCK_STATUS);
    }

    public String getSkud (){
        waitForElementVisible(driver, DetailProductPageUI.SKU);
        return getElementText(driver, DetailProductPageUI.SKU);
    }

    public String getDeliveryMethod (){
        waitForElementVisible(driver, DetailProductPageUI.DELIVERY_METHOD);
        return getElementText(driver, DetailProductPageUI.DELIVERY_METHOD);
    }

    public void unselectProcessor(){
        waitForElementVisible(driver, DetailProductPageUI.PROCESSOR_DROPDOWN);
        selectItemInCustomDropdown(driver,
                DetailProductPageUI.PROCESSOR_DROPDOWN,
                DetailProductPageUI.PROCESSOR_VALUE_1,
                "Please select");
    }

    public void selectProcessor(){
        waitForElementVisible(driver, DetailProductPageUI.PROCESSOR_DROPDOWN);
        selectItemInCustomDropdown(driver,
                DetailProductPageUI.PROCESSOR_DROPDOWN,
                DetailProductPageUI.PROCESSOR_VALUE_3,
                "2.5 GHz Intel Pentium Dual-Core E2200 [+15 ₫]");
    }
    public void unselectRam(){
        waitForElementVisible(driver, DetailProductPageUI.RAM_DROPDOWN);
        selectItemInCustomDropdown(driver,
                DetailProductPageUI.RAM_DROPDOWN,
                DetailProductPageUI.RAM_VALUE_1,
                "Please select");
    }

    public void selectRam(){
        waitForElementVisible(driver, DetailProductPageUI.RAM_DROPDOWN);
        selectItemInCustomDropdown(driver,
                DetailProductPageUI.RAM_DROPDOWN,
                DetailProductPageUI.RAM_VALUE_2,
                "2 GB");
    }

    public void checkToRadioHDD(){
        waitForElementVisible(driver, DetailProductPageUI.HDD_320GB_RADIO);
        checkToCheckboxRadio(driver, DetailProductPageUI.HDD_320GB_RADIO);
    }

    public void checkToRadioOS(){
        waitForElementVisible(driver, DetailProductPageUI.OS_VISTAHOME);
        checkToCheckboxRadio(driver, DetailProductPageUI.OS_VISTAHOME);
    }

    public void checkToCheckboxSoftware(){
        waitForElementVisible(driver, DetailProductPageUI.SOFTWARE_MS);
        checkToCheckboxRadio(driver, DetailProductPageUI.SOFTWARE_MS);
    }

    public String getProductPrice (){
        waitForElementVisible(driver, DetailProductPageUI.PRODUCT_PRICE);
        return getElementText(driver, DetailProductPageUI.PRODUCT_PRICE);
    }

    public void enterToQuantityTextbox(String quantity) {
        waitForElementVisible(driver, DetailProductPageUI.INPUT_QUANTITY);
        clearInput(driver, DetailProductPageUI.INPUT_QUANTITY);
        sendkeyToElement(driver, DetailProductPageUI.INPUT_QUANTITY , quantity);
    }

    public String getNotification(){
        waitForElementVisible(driver, DetailProductPageUI.NOTIFICATION);
        return getElementText(driver, DetailProductPageUI.NOTIFICATION);
    }

    public String getFullDescription(){
        waitForElementVisible(driver, DetailProductPageUI.FULL_DESCRIPTION);
        return getElementText(driver, DetailProductPageUI.FULL_DESCRIPTION);
    }

    public void clickButtonAddToCart() {
        waitForElementVisible(driver, DetailProductPageUI.BUTTON_ADD_TO_CART);
        clickToElement(driver, DetailProductPageUI.BUTTON_ADD_TO_CART);
    }

    public void clickButtonAddToWishList() {
        waitForElementVisible(driver, DetailProductPageUI.BUTTON_ADD_TO_WISHLIST);
        clickToElement(driver, DetailProductPageUI.BUTTON_ADD_TO_WISHLIST);
    }

    public void clickButtonAddToCompareList() {
        waitForElementVisible(driver, DetailProductPageUI.BUTTON_ADD_TO_COMPARE_LIST);
        clickToElement(driver, DetailProductPageUI.BUTTON_ADD_TO_COMPARE_LIST);
    }

    public void clickButtonEmailAFriend() {
        waitForElementVisible(driver, DetailProductPageUI.BUTTON_ADD_TO_EMAIL_A_FRIEND);
        clickToElement(driver, DetailProductPageUI.BUTTON_ADD_TO_EMAIL_A_FRIEND);
    }

    public void clickToCloseInNotification() {
        waitForElementVisible(driver, DetailProductPageUI.CLOSE);
        clickToElement(driver, DetailProductPageUI.CLOSE);
    }

    public void clickToCart() {
        waitForElementVisible(driver, DetailProductPageUI.CART);
        clickToElement(driver, DetailProductPageUI.CART);
    }
}
