package salesforce.ui.pages;

import core.config.ConfigValues;
import core.selenium.WebElementAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This abstract class is the base for all web pages.
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebElementAction webElementAction;
    private ConfigValues configValues;

    /**
     * This class sets params for WebDriver.
     */
    public BasePage(final WebDriver driver) {
        configValues = new ConfigValues();
        this.driver = driver;
        wait = new WebDriverWait(driver, Long.parseLong(configValues.getExplicitWaitValue()));
        webElementAction = new WebElementAction(this.driver, wait);
        PageFactory.initElements(driver, this);
        waitForPageLoaded();
    }

    protected abstract void waitForPageLoaded();
}