package salesforce.ui;

import core.config.ConfigValues;
import org.openqa.selenium.WebDriver;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.quicktext.QuickTextPage;

/**
 * Controls navigation of pages.
 */
public class PageTransporter {
    private WebDriver driver;
    private ConfigValues configValues;

    public PageTransporter(WebDriver driver) {
        this.driver = driver;
        configValues = new ConfigValues();
    }

    private void goToUrl(final String url) {
        driver.navigate().to(url);
    }

    public LoginPage navigateToLoginPage() {
        goToUrl(configValues.getLoginUrl());
        return new LoginPage(driver);
    }

    public QuickTextPage navigateToQuickTextPage() {
        goToUrl(configValues.getBaseUrl().concat(configValues.getQuickTextUrl()));
        return new QuickTextPage(driver);
    }

}