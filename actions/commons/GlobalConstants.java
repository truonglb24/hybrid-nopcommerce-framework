package commons;

public class GlobalConstants {

    // System info
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String SEPARATOR = System.getProperty("file.separator");


    public static final String URL = "http://160.25.81.125/";
    public static final String ACCOUNT = "truonglb@rabiloo.com";
    public static final String PASSWORD = "123123";

    // HTML Report Folder
    public static final String EXTENT_PATH = PROJECT_PATH + SEPARATOR + "htmlExtent" + SEPARATOR;

    public static final String MESSAGE_ERROR_GENERAL = "Login was unsuccessful. Please correct the errors and try again.";
    public static final String MESSAGE_ERROR_FORMAT_EMAIL = "Please enter a valid email address.";
    public static final String MESSAGE_ERROR_WRONG_EMAIL = "Wrong email";
    public static final String MESSAGE_ERROR_EMAIL = "No customer account found";
    public static final String MESSAGE_ERROR_EMAIL_BLANK = "Please enter your email";
    public static final String MESSAGE_ERROR_PASSWORD = "The credentials provided are incorrect";

    public static final String MESSAGE_ERROR_FIRSTNAME_REQUIRED = "First name is required.";
    public static final String MESSAGE_ERROR_LASTNAME_REQUIRED = "Last name is required.";
    public static final String MESSAGE_ERROR_EMAIL_REQUIRED = "Email is required.";
    public static final String MESSAGE_ERROR_EMAIL_EXIST = "The specified email already exists";
    public static final String MESSAGE_ERROR_PASSWORD_REQUIRED = "Password is required.";
    public static final String MESSAGE_ERROR_PASSWORD_NOT_MATCH = "The password and confirmation password do not match.";
    public static final String MESSAGE_ERROR_PASSWORD_INCORRECT_FORMAT = "Password must meet the following rules: must have at least 6 characters and not greater than 64 characters";

    public static final String STATUS_IN_STOCK = "In stock";
    public static final String STATUS_OUT_STOCK = "Out stock";
    public static final String STATUS_SKU = "COMP_CUST";
    public static final String DELIVERY_METHOD_FREE_SHIPPING = "Free shipping";
    public static final String NOTIFICATION_MISSING_PROCESSOR = "Please select Processor";
    public static final String NOTIFICATION_MISSING_RAM = "Please select RAM";
    public static final String NOTIFICATION_MISSING_HDD = "Please select HDD";
    public static final String NOTIFICATION_QUANTITY_INCORRECT = "Quantity should be positive";
    public static final String NOTIFICATION_ADD_TO_WISHLIST = "The product has been added to your wishlist";
    public static final String NOTIFICATION_ADD_TO_COMPARELIST = "The product has been added to your product comparison";

    public static final String MESSAGE_CART_EMPTY = "Your Shopping Cart is empty!";
}
