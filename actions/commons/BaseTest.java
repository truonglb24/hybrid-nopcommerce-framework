package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Locale;
import java.util.Random;

public class BaseTest {

    private WebDriver driver;

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

        driver.get("http://localhost/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        return driver;
    }

    protected int generateRandomNumber(){
        return new Random().nextInt(99999);
    }

    public static final String MESSAGE_ERROR_FORMAT_EMAIL = "Please enter a valid email address.";
    public static final String MESSAGE_ERROR_GENERAL = "Login was unsuccessful. Please correct the errors and try again.";
    public static final String MESSAGE_ERROR_EMAIL = "No customer account found";
    public static final String MESSAGE_ERROR_EMAIL_BLANK = "Please enter your email";
    public static final String MESSAGE_ERROR_PASSWORD = "The credentials provided are incorrect";
}
