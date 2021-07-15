package base;

import core.config.ConfigValues;
import core.config.EnvValues;
import core.selenium.CoreDriver;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import salesforece.ui.pages.LoginPage;

public class BaseTest {

    private CoreDriver coreDriver;
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected WebDriverWait wait;
    protected ConfigValues configValues;
    protected EnvValues envValues;

    @BeforeClass
    public void beforeClass() {
        long secondsExplicitWait = 30;

        envValues = new EnvValues();
        configValues = new ConfigValues();

        coreDriver = new CoreDriver();
        driver = coreDriver.getWebDriver(DriverManagerType.CHROME);
        wait = coreDriver.getWebDriverWait(driver, secondsExplicitWait);

        driver.get(configValues.getLoginUrl());
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        coreDriver.quitDriver();
    }
}