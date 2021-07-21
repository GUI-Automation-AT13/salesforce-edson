package core.selenium.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Class for obtains a Chrome Driver.
 */
public class ChromeBrowser implements Ibrowser {
    private ChromeOptions chromeOptions;

    /**
     * Configures the browser's options.
     */
    public void configOptions() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
    }

    /**
     * Gets the browser's driver.
     *
     * @return the web driver
     */
    @Override
    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        configOptions();
        return new ChromeDriver(chromeOptions);
    }
}
