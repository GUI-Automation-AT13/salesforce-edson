package salesforce.ui.pages;

import org.openqa.selenium.WebDriver;

/**
 * This class returns an instance of HomePage.
 */
public class HomePage extends BasePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageLoaded() {

    }
}