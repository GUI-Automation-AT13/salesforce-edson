package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class defines set properties for WebDriver.
 */
public class CoreDriver {

    public static WebDriver driver;

    /**
     * This class return a instance of WebDriver.
     */
    public static WebDriver getWebDriver(String browser) {
        if (driver == null) {
            if (browser.equals("CHROME")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            if (browser.equals("FIREFOX")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            if (browser.equals("EDGE")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        driver.close();
        driver = null;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}