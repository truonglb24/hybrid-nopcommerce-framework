package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.Random;

public class BaseTest {

    private WebDriver driver;
    protected final Logger log;
    public BaseTest(){
        log = LogManager.getLogger(getClass());
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }

        driver.get(GlobalConstant.URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        return driver;
    }

    protected int generateRandomNumber(){
        return new Random().nextInt(99999);
    }

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
}
