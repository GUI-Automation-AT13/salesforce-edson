package salesforece.ui.pages;

import org.openqa.selenium.WebDriver;

/**
 * This class return a instance of HomePage.
 */
public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
}