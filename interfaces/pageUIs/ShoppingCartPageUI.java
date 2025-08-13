package pageUIs;

public class ShoppingCartPageUI {
    public static final String ORDER_SUMMARY_CONTENT = "//div[@class = 'page-body']/div[@class = 'order-summary-content']";

    public static final String PRODUCT_SKU_NUMBER = "//td/span[@class = 'sku-number']";
    public static final String PRODUCT_PICTURE = "//td[@class = 'product-picture']/a";
    public static final String PRODUCT_NAME = "//td[@class = 'product']/a[@class = 'product-name']";
    public static final String PRODUCT_ATTRIBUTES = "//td[@class = 'product']/div[@class = 'attributes']";
    public static final String PRODUCT_EDIT_ITEM = "//td[@class = 'product']/div[@class = 'edit-item']/a";

    public static final String PRODUCT_UNIT_PRICE = "//td[@class = 'unit-price']/span";
    public static final String PRODUCT_QUANTITY = "//input[@class = 'qty-input']";
    public static final String PRODUCT_QUANTITY_UP = "//td[@class = 'quantity']//div[@class= 'quantity up']";
    public static final String PRODUCT_QUANTITY_DOWN = "//td[@class = 'quantity']//div[@class= 'quantity down']";

    public static final String PRODUCT_SUBTOTAL = "//td[@class = 'subtotal']";
    public static final String PRODUCT_REMOVE_CART = "//td[@class = 'remove-from-cart']";

    public static final String BUTTON_CONTINUE_SHOPPING = "//button[contains(@class, 'continue-shopping-button')]";
    public static final String BUTTON_ESTIMATE_SHIPPING = "//a[@id = 'open-estimate-shipping-popup']";

    public static final String GIFT_WRAPPING_DROPDOWN = "//div[@class = 'checkout-attributes']//select";
    public static final String GIFT_WRAPPING_NO = "//div[@class = 'checkout-attributes']//select/option[1]";
    public static final String GIFT_WRAPPING_YES = "//div[@class = 'checkout-attributes']//select/option[2]";

    public static final String GIFT_WRAPPING_SELECTED = "//div[@class = 'selected-checkout-attributes']";

    public static final String INPUT_DISCOUNT_COUPON_CODE = "//input[@id = 'discountcouponcode']";
    public static final String BUTTON_APPLY_COUPON_CODE = "//button[@id = 'applydiscountcouponcode']";
    public static final String MESSAGE_CURRENT_CODE = "//div[@class = 'current-code']/span";
    public static final String BUTTON_REMOVE_DISCOUNT = "//div[@class = 'current-code']/button";

    public static final String MESSAGE_COUPON_SUCCESS = "//div[@class = 'coupon-code']/following-sibling::div[@class = 'message-success']";
    public static final String MESSAGE_COUPON_FAILURE = "//div[@class = 'coupon-code']/following-sibling::div[@class = 'message-failure']";

    public static final String MESSAGE_GIFTCARD_SUCCESS = "//div[@class = 'giftcard-box']//following-sibling::div[@class = 'message-success']";
    public static final String MESSAGE_GIFTCARD_FAILURE = "//div[@class = 'giftcard-box']//following-sibling::div[@class = 'message-failure']";

    public static final String INPUT_DISCOUNT_GIFT_CARD = "//input[@id = 'giftcardcouponcode']";
    public static final String BUTTON_ADD_GIFT_CARD = "//button[@id = 'applygiftcardcouponcode']";

    public static final String ORDER_SUBTOTAL_LEFT = "//div[@class = 'totals']//tr[@class = 'order-subtotal']/td[@class = 'cart-total-left']";
    public static final String ORDER_SUBTOTAL_RIGHT = "//div[@class = 'totals']//tr[@class = 'order-subtotal']/td[@class = 'cart-total-right']";

    public static final String ORDER_DISCOUNT_LEFT = "//div[@class = 'totals']//tr[@class = 'order-subtotal-discount']/td[@class = 'cart-total-left']";
    public static final String ORDER_DISCOUNT_RIGHT = "//div[@class = 'totals']//tr[@class = 'order-subtotal-discount']/td[@class = 'cart-total-right']";

    public static final String ORDER_SHIPPING_LEFT = "//div[@class = 'totals']//tr[@class = 'shipping-cost']/td[@class = 'cart-total-left']";
    public static final String ORDER_SHIPPING_RIGHT = "//div[@class = 'totals']//tr[@class = 'shipping-cost']/td[@class = 'cart-total-right']";

    public static final String ORDER_TAX_LEFT = "//div[@class = 'totals']//tr[@class = 'tax-value']/td[@class = 'cart-total-left']";
    public static final String ORDER_TAX_RIGHT = "//div[@class = 'totals']//tr[@class = 'tax-value']/td[@class = 'cart-total-right']";

    public static final String ORDER_DISCOUNT_TOTAL_LEFT = "//div[@class = 'totals']//tr[@class = 'discount-total']/td[@class = 'cart-total-left']";
    public static final String ORDER_DISCOUNT_TOTAL_RIGHT = "//div[@class = 'totals']//tr[@class = 'discount-total']/td[@class = 'cart-total-right']";

    public static final String ORDER_GIFT_CARD_LEFT = "//div[@class = 'totals']//tr[@class = 'giftcard-summary']/td[@class = 'cart-total-left']";
    public static final String ORDER_GIFT_CARD_RIGHT = "//div[@class = 'totals']//tr[@class = 'giftcard-summary']/td[@class = 'cart-total-right']";
    public static final String BUTTON_REMOVE_ORDER_GIFT_CARD_CLOSE = "//div[@class = 'totals']//tr[@class = 'giftcard-summary']/td/button";
    public static final String ORDER_GIFT_CARD_REMAINING = "//div[@class = 'totals']//tr[@class = 'giftcard-summary']/td/span";

    public static final String ORDER_TOTAL_LEFT = "//div[@class = 'totals']//tr[@class = 'order-total']/td[@class = 'cart-total-left']";
    public static final String ORDER_TOTAL_RIGHT = "//div[@class = 'totals']//tr[@class = 'order-total']/td[@class = 'cart-total-right']";

    public static final String ORDER_EARN_REWARD_LEFT = "//div[@class = 'totals']//tr[@class = 'earn-reward-points']/td[@class = 'cart-total-left']";
    public static final String ORDER_EARN_REWARD_RIGHT = "//div[@class = 'totals']//tr[@class = 'earn-reward-points']/td[@class = 'cart-total-right']";

    public static final String CHECKBOX_TERM_OF_SERVICES = "//div/input[@id = 'termsofservice']";
    public static final String LINK_READ_TERM = "//a[@id = 'read-terms']";

    public static final String BUTTON_CHECKOUT = "//button[@id = 'checkout']";
    public static final String BUTTON_APPLY = "//div/button[contains(@class, 'apply-shipping-button')]";
}
