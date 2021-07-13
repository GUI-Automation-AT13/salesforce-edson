package salesforece.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This abstract class is the base for all web pages.
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * This class sets params for WebDriver.
     */
    public BasePage(final WebDriver driver) {
        final int waitSeconds = 30;
        this.driver = driver;
        wait = new WebDriverWait(driver, waitSeconds);
        PageFactory.initElements(driver, this);
        waitForPageLoaded();
    }

    protected abstract void waitForPageLoaded();
}