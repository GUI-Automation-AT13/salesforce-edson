package core.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class defines set properties for WebDriver.
 */
public class CoreDriver {

    private WebDriver driver;
    private WebDriverWait wait;


    /**
     * This class return a instance of WebDriver.
     */
    public WebDriver getWebDriver(DriverManagerType driverManagerType) {
//        if (driver == null) {
        WebDriverManager.getInstance(driverManagerType).setup();
        Class<?> driverClass;
        try {
            driverClass = Class.forName(driverManagerType.browserClass());
            driver = (WebDriver) driverClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InvocationTargetException
                | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException("It was not possible to create a WebDriver Object", e);
        }
//        }
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriverWait getWebDriverWait(WebDriver driver, long seconds) {
        return wait = new WebDriverWait(driver, seconds);
    }

    public void closeDriver() {
        driver.close();
        driver = null;
    }

    public void quitDriver() {
        driver.quit();
        driver = null;
    }
}