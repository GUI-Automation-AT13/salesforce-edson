package core.selenium.browsers;

import org.openqa.selenium.WebDriver;

/**
 * Class for obtains specific browser.
 */
public class BrowserFactory {

    /**
     * Gets the proper web driver.
     *
     * @param webDriver a String with the web driver's name
     * @return the web driver
     */
    public WebDriver getWebDriver(final String webDriver) {
        if (webDriver == null) {
            return null;
        }
        switch (webDriver) {
            case "CHROME":
                return new ChromeBrowser().getDriver();
            case "EDGE":
                return new EdgeBrowser().getDriver();
            case "FIREFOX":
                return new FirefoxBrowser().getDriver();
            default:
                break;
        }
        return null;
    }
}
