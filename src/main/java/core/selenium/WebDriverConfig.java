package core.selenium;

import static core.utils.LoadFiles.configValues;

/**
 * Class for configure the WebDriver.
 */
public final class WebDriverConfig {
    private String browser;
    private int implicitWaitTime;
    private int explicitWaitTime;

    private static WebDriverConfig webDriverConfig;

    private WebDriverConfig() {
        initialize();
    }

    /**
     * Gets web driver's configuration.
     *
     * @return an instance of the web driver's configuration
     */
    public static WebDriverConfig getWebDriverConfig() {
        if (webDriverConfig == null) {
            webDriverConfig = new WebDriverConfig();
        }
        return webDriverConfig;
    }

    private void initialize() {
        browser = configValues.getBrowser();
        implicitWaitTime = Integer.parseInt(configValues.getImplicitWaitTime());
        explicitWaitTime = Integer.parseInt(configValues.getExplicitWaitValue());
    }

    public String getBrowser() {
        return browser;
    }

    public int getImplicitWaitTime() {
        return implicitWaitTime;
    }

    public int getExplicitWaitTime() {
        return explicitWaitTime;
    }
}
