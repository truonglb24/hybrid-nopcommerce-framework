package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
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

    public boolean isEditButtonDisplay(){
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_EDIT_ITEM);
        return isElementDisplayed(driver, ShoppingCartPageUI.PRODUCT_EDIT_ITEM);
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
        return getElementAttribute(driver, ShoppingCartPageUI.PRODUCT_QUANTITY, "value");
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
    public boolean isRemoveCartDisplay(){
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_REMOVE_CART);
        return isElementDisplayed(driver, ShoppingCartPageUI.PRODUCT_REMOVE_CART);
    }
    public void clickToRemoveCart(){
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_REMOVE_CART);
        clickToElement(driver, ShoppingCartPageUI.PRODUCT_REMOVE_CART);
    }
    public boolean isButtonContinueShoppingDisplay(){
        waitForElementVisible(driver, ShoppingCartPageUI.BUTTON_CONTINUE_SHOPPING);
        return isElementDisplayed(driver, ShoppingCartPageUI.BUTTON_CONTINUE_SHOPPING);
    }
    public void clickButtonContinueShopping(){
        waitForElementVisible(driver, ShoppingCartPageUI.BUTTON_CONTINUE_SHOPPING);
        clickToElement(driver, ShoppingCartPageUI.BUTTON_CONTINUE_SHOPPING);
    }
    public boolean isButtonEstimateShipping(){
        waitForElementVisible(driver, ShoppingCartPageUI.BUTTON_ESTIMATE_SHIPPING);
        return isElementDisplayed(driver, ShoppingCartPageUI.BUTTON_ESTIMATE_SHIPPING);
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

    public void clickButtonAddGiftCard(){
        waitForElementVisible(driver, ShoppingCartPageUI.BUTTON_ADD_GIFT_CARD);
        clickToElement(driver, ShoppingCartPageUI.BUTTON_ADD_GIFT_CARD);
    }

    public String getMessageCouponSuccess(){
        waitForElementVisible(driver, ShoppingCartPageUI.MESSAGE_COUPON_SUCCESS);
        return getElementText(driver, ShoppingCartPageUI.MESSAGE_COUPON_SUCCESS);
    }

    public String getMessageCouponFailure(){
        waitForElementVisible(driver, ShoppingCartPageUI.MESSAGE_COUPON_FAILURE);
        return getElementText(driver, ShoppingCartPageUI.MESSAGE_COUPON_FAILURE);
    }

    public String getMessageGiftCardSuccess(){
        waitForElementVisible(driver, ShoppingCartPageUI.MESSAGE_GIFTCARD_SUCCESS);
        return getElementText(driver, ShoppingCartPageUI.MESSAGE_GIFTCARD_SUCCESS);
    }

    public String getMessageGiftCardFailure(){
        waitForElementVisible(driver, ShoppingCartPageUI.MESSAGE_GIFTCARD_FAILURE);
        return getElementText(driver, ShoppingCartPageUI.MESSAGE_GIFTCARD_FAILURE);
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
        checkToCheckboxRadio(driver, ShoppingCartPageUI.CHECKBOX_TERM_OF_SERVICES);
    }

    public void clickToLinkReadTerm(){
        waitForElementVisible(driver, ShoppingCartPageUI.LINK_READ_TERM);
        clickToElement(driver, ShoppingCartPageUI.LINK_READ_TERM);
    }

    public void clickButtonCheckout(){
        waitForElementVisible(driver, ShoppingCartPageUI.BUTTON_CHECKOUT);
        clickToElement(driver, ShoppingCartPageUI.BUTTON_CHECKOUT);
    }

    public void clickButtonApply(){
        waitForElementVisible(driver, ShoppingCartPageUI.BUTTON_APPLY);
        clickToElement(driver, ShoppingCartPageUI.BUTTON_APPLY);
    }
}
