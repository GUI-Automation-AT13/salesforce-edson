package salesforce.ui.pages;

import static core.selenium.MyWebDriverManager.getWebDriverManager;

import core.selenium.WebElementAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This abstract class is the salesforce.base for all web pages.
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebElementAction webElementAction;

    /**
     * This class sets params for WebDriver.
     */
    public BasePage() {
        driver = getWebDriverManager().getDriver();
        wait = getWebDriverManager().getWebDriverWait();
        webElementAction = new WebElementAction(this.driver, wait);
        PageFactory.initElements(driver, this);
        waitForPageLoaded();
    }

    protected abstract void waitForPageLoaded();
}