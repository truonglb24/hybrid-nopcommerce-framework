package pageUIs;

public class HomePageUI {
    public static final String REGISTER_LINK = "//a[@class = 'ico-register']";
    public static final String MY_ACCOUNT_LINK = "//a[@class = 'ico-account']";
    public static final String LOGIN_LINK = "//a[@class = 'ico-login']";
    public static final String LOGOUT_LINK = "//a[@class = 'ico-logout']";
    public static final String ADD_TO_CART_BUTTON = "//a[text() = 'Build your own computer']/ancestor::div[@class = 'details']" +
            "//following-sibling::button[contains(@class, 'add-to-cart')]";
    public static final String COMPARE_BUTTON = "//a[text() = 'Build your own computer']/ancestor::div[@class = 'details']" +
            "//following-sibling::button[contains(@class, 'add-to-compare')]";
    public static final String WISHLIST_BUTTON = "//a[text() = 'Build your own computer']/ancestor::div[@class = 'details']" +
            "//following-sibling::button[contains(@class, 'add-to-wishlist')]";
}
