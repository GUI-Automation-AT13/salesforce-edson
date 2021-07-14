package base;

import core.Browsers;
import core.CoreDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import salesforece.ui.pages.LoginPage;

import static core.DataValues.GET_VALUE;

public class BaseTest {

    protected LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        WebDriver driver = CoreDriver.getWebDriver(Browsers.CHROME.value());
        driver.get(GET_VALUE.getProperty("LOGIN_URL"));
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        CoreDriver.quitDriver();
    }
}