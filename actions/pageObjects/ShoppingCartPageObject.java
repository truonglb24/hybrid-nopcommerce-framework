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
}
