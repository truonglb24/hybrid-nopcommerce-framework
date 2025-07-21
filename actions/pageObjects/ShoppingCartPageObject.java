package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.DetailProductPageUI;
import pageUIs.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage {
    private WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getOrderSummary(){
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_SUMMARY_CONTENT);
        return getElementText(driver, ShoppingCartPageUI.ORDER_SUMMARY_CONTENT);
    }

    public String getProductSkuNumber(){
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_SKU_NUMBER);
        return getElementText(driver, ShoppingCartPageUI.PRODUCT_SKU_NUMBER);
    }

    public boolean isImageProductLoaded(){
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_PICTURE);
        return isImageLoaded(driver, ShoppingCartPageUI.PRODUCT_PICTURE);
    }

    public String getProductName(){
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_NAME);
        return getElementText(driver, ShoppingCartPageUI.PRODUCT_NAME);
    }

    public String getProductAttributes(){
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_ATTRIBUTES);
        return getElementText(driver, ShoppingCartPageUI.PRODUCT_ATTRIBUTES);
    }

    public void clickEditButton(){
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_EDIT_ITEM);
        clickToElement(driver, ShoppingCartPageUI.PRODUCT_EDIT_ITEM);
    }

    public String getUnitPrice(){
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_UNIT_PRICE);
        return getElementText(driver, ShoppingCartPageUI.PRODUCT_UNIT_PRICE);
    }

    public String getQuantityNumber(){
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_QUANTITY);
        return getElementText(driver, ShoppingCartPageUI.PRODUCT_QUANTITY);
    }

    public void clickToQuantityUp(){
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_QUANTITY_UP);
        clickToElement(driver, ShoppingCartPageUI.PRODUCT_QUANTITY_UP);
    }

    public void clickToQuantityDown(){
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_QUANTITY_DOWN);
        clickToElement(driver, ShoppingCartPageUI.PRODUCT_QUANTITY_DOWN);
    }

    public String getSubTotal(){
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_SUBTOTAL);
        return getElementText(driver, ShoppingCartPageUI.PRODUCT_SUBTOTAL);
    }

    public void clickToRemoveCart(){
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_REMOVE_CART);
        clickToElement(driver, ShoppingCartPageUI.PRODUCT_REMOVE_CART);
    }

    public void clickButtonContinueShopping(){
        waitForElementVisible(driver, ShoppingCartPageUI.BUTTON_CONTINUE_SHOPPING);
        clickToElement(driver, ShoppingCartPageUI.BUTTON_CONTINUE_SHOPPING);
    }

    public void clickButtonEstimateShipping(){
        waitForElementVisible(driver, ShoppingCartPageUI.BUTTON_ESTIMATE_SHIPPING);
        clickToElement(driver, ShoppingCartPageUI.BUTTON_ESTIMATE_SHIPPING);
    }

    public void selectGiftWrappingIsNo(){
        waitForElementVisible(driver, ShoppingCartPageUI.GIFT_WRAPPING_DROPDOWN);
        selectItemInCustomDropdown(driver,
                ShoppingCartPageUI.GIFT_WRAPPING_DROPDOWN,
                ShoppingCartPageUI.GIFT_WRAPPING_NO,
                "NO");
    }

    public void selectGiftWrappingIsYes(){
        waitForElementVisible(driver, ShoppingCartPageUI.GIFT_WRAPPING_DROPDOWN);
        selectItemInCustomDropdown(driver,
                ShoppingCartPageUI.GIFT_WRAPPING_DROPDOWN,
                ShoppingCartPageUI.GIFT_WRAPPING_YES,
                "Yes [+10 ₫]");
    }
    public String getWrappingSelected(){
        waitForElementVisible(driver, ShoppingCartPageUI.GIFT_WRAPPING_SELECTED);
        return getElementText(driver, ShoppingCartPageUI.GIFT_WRAPPING_SELECTED);
    }

    public void enteringDiscountCouponCode(String couponCode){
        waitForElementVisible(driver, ShoppingCartPageUI.INPUT_DISCOUNT_COUPON_CODE);
        sendkeyToElement(driver, ShoppingCartPageUI.INPUT_DISCOUNT_COUPON_CODE, couponCode);
    }

    public void clickButtonApplyCoupon(){
        waitForElementVisible(driver, ShoppingCartPageUI.BUTTON_APPLY_COUPON_CODE);
        clickToElement(driver, ShoppingCartPageUI.BUTTON_APPLY_COUPON_CODE);
    }

    public String getMessageCurrentCode(){
        waitForElementVisible(driver, ShoppingCartPageUI.MESSAGE_CURRENT_CODE);
        return getElementText(driver, ShoppingCartPageUI.MESSAGE_CURRENT_CODE);
    }

    public void clickButtonRemoveDiscount(){
        waitForElementVisible(driver, ShoppingCartPageUI.BUTTON_REMOVE_DISCOUNT);
        clickToElement(driver, ShoppingCartPageUI.BUTTON_REMOVE_DISCOUNT);
    }

    public void enteringGiftCard(String giftCard){
        waitForElementVisible(driver, ShoppingCartPageUI.INPUT_DISCOUNT_GIFT_CARD);
        sendkeyToElement(driver, ShoppingCartPageUI.INPUT_DISCOUNT_GIFT_CARD, giftCard);
    }

    public void clickButtonApplyGiftCard(){
        waitForElementVisible(driver, ShoppingCartPageUI.BUTTON_ADD_GIFT_CARD);
        clickToElement(driver, ShoppingCartPageUI.BUTTON_ADD_GIFT_CARD);
    }

    public String getMessageSuccess(){
        waitForElementVisible(driver, ShoppingCartPageUI.MESSAGE_SUCCESS);
        return getElementText(driver, ShoppingCartPageUI.MESSAGE_SUCCESS);
    }

    public String getMessageFailure(){
        waitForElementVisible(driver, ShoppingCartPageUI.MESSAGE_FAILURE);
        return getElementText(driver, ShoppingCartPageUI.MESSAGE_FAILURE);
    }

    public boolean isSubTotalLeftDisplay(){
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_SUBTOTAL_LEFT);
        return isElementDisplayed(driver, ShoppingCartPageUI.ORDER_SUBTOTAL_LEFT);
    }

    public String getSubTotalRight(){
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_SUBTOTAL_RIGHT);
        return getElementText(driver, ShoppingCartPageUI.ORDER_SUBTOTAL_RIGHT);
    }

    public boolean isOrderDiscountLeftDisplay(){
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_DISCOUNT_LEFT);
        return isElementDisplayed(driver, ShoppingCartPageUI.ORDER_DISCOUNT_LEFT);
    }

    public String getOrderDiscount(){
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_DISCOUNT_RIGHT);
        return getElementText(driver, ShoppingCartPageUI.ORDER_DISCOUNT_RIGHT);
    }

    public boolean isOrderShippingLeftDisplayed() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_SHIPPING_LEFT);
        return isElementDisplayed(driver, ShoppingCartPageUI.ORDER_SHIPPING_LEFT);
    }

    public String getOrderShippingAmount() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_SHIPPING_RIGHT);
        return getElementText(driver, ShoppingCartPageUI.ORDER_SHIPPING_RIGHT);
    }

    public boolean isOrderTaxLeftDisplayed() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_TAX_LEFT);
        return isElementDisplayed(driver, ShoppingCartPageUI.ORDER_TAX_LEFT);
    }

    public String getOrderTaxAmount() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_TAX_RIGHT);
        return getElementText(driver, ShoppingCartPageUI.ORDER_TAX_RIGHT);
    }

    public boolean isOrderDiscountTotalLeftDisplayed() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_DISCOUNT_TOTAL_LEFT);
        return isElementDisplayed(driver, ShoppingCartPageUI.ORDER_DISCOUNT_TOTAL_LEFT);
    }

    public String getOrderDiscountTotalAmount() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_DISCOUNT_TOTAL_RIGHT);
        return getElementText(driver, ShoppingCartPageUI.ORDER_DISCOUNT_TOTAL_RIGHT);
    }

    public boolean isOrderGiftCardLeftDisplayed() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_GIFT_CARD_LEFT);
        return isElementDisplayed(driver, ShoppingCartPageUI.ORDER_GIFT_CARD_LEFT);
    }

    public String getOrderGiftCardAmount() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_GIFT_CARD_RIGHT);
        return getElementText(driver, ShoppingCartPageUI.ORDER_GIFT_CARD_RIGHT);
    }

    public void clickButtonRemoveGiftCard(){
        waitForElementVisible(driver, ShoppingCartPageUI.BUTTON_REMOVE_ORDER_GIFT_CARD_CLOSE);
        clickToElement(driver, ShoppingCartPageUI.BUTTON_REMOVE_ORDER_GIFT_CARD_CLOSE);
    }

    public String getOrderGiftCardRemaining() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_GIFT_CARD_REMAINING);
        return getElementText(driver, ShoppingCartPageUI.ORDER_GIFT_CARD_REMAINING);
    }

    public boolean isOrderTotalLeftDisplayed() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_TOTAL_LEFT);
        return isElementDisplayed(driver, ShoppingCartPageUI.ORDER_TOTAL_LEFT);
    }

    public String getOrderTotalAmount() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_TOTAL_RIGHT);
        return getElementText(driver, ShoppingCartPageUI.ORDER_TOTAL_RIGHT);
    }

    public boolean isOrderEarnRewardLeftDisplayed() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_EARN_REWARD_LEFT);
        return isElementDisplayed(driver, ShoppingCartPageUI.ORDER_EARN_REWARD_LEFT);
    }

    public String getOrderEarnRewardPoints() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_EARN_REWARD_RIGHT);
        return getElementText(driver, ShoppingCartPageUI.ORDER_EARN_REWARD_RIGHT);
    }

    public void clickCheckboxTermOfService(){
        waitForElementVisible(driver, ShoppingCartPageUI.CHECKBOX_TERM_OF_SERVICES);
        clickToElement(driver, ShoppingCartPageUI.CHECKBOX_TERM_OF_SERVICES);
    }

    public void clickToLinkReadTerm(){
        waitForElementVisible(driver, ShoppingCartPageUI.LINK_READ_TERM);
        clickToElement(driver, ShoppingCartPageUI.LINK_READ_TERM);
    }

    public void clickButtonCheckout(){
        waitForElementVisible(driver, ShoppingCartPageUI.BUTTON_CHECKOUT);
        clickToElement(driver, ShoppingCartPageUI.BUTTON_CHECKOUT);
    }
}
