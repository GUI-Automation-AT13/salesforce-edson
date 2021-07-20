package core.selenium;

import core.selenium.browsers.BrowserFactory;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class for instance WebDriverManager.
 */
public final class MyWebDriverManager {
    private static MyWebDriverManager myWebDriverManager;
    private WebDriver driver;
    private WebDriverWait wait;
    private WebDriverConfig webDriverConfig = WebDriverConfig.getWebDriverConfig();

    private MyWebDriverManager() {
        initialize();
    }

    /**
     * Gets the web driver manager or creates one when needed.
     *
     * @return an instance of myWebDriverManager
     */
    public static MyWebDriverManager getWebDriverManager() {
        if (myWebDriverManager == null) {
            myWebDriverManager = new MyWebDriverManager();
        }
        return myWebDriverManager;
    }

    private void initialize() {
        driver = new BrowserFactory().getWebDriver(webDriverConfig.getBrowser());
        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, webDriverConfig.getExplicitWaitTime());

    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWebDriverWait() {
        return wait;
    }

    public void quitDriver() {
        driver.quit();
        myWebDriverManager = null;
    }
}
