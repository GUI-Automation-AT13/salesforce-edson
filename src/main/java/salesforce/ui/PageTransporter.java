package salesforce.ui;

import static core.utils.LoadFiles.configValues;

import core.selenium.MyWebDriverManager;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.quicktext.QuickTextPage;

/**
 * Controls navigation of pages.
 */
public class PageTransporter {

    private void goToUrl(final String url) {
        MyWebDriverManager.getWebDriverManager().getDriver().navigate().to(url);
    }

    public LoginPage navigateToLoginPage() {
        goToUrl(configValues.getLoginUrl());
        return new LoginPage();
    }

    public QuickTextPage navigateToQuickTextPage() {
        goToUrl(configValues.getBaseUrl().concat(configValues.getQuickTextUrl()));
        return new QuickTextPage();
    }

    public void navigateToAnyPage(final String endpoint) {
        goToUrl(configValues.getBaseUrl().concat(String.format(configValues.getQuickTextUrl(), endpoint)));
    }
}