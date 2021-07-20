package salesforce.base;

import core.config.ConfigValues;
import core.config.EnvValues;
import core.selenium.CoreDriver;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import salesforce.ui.PageTransporter;
import salesforce.ui.ToastMessage;
import salesforce.ui.pages.LoginPage;

public class BaseTest {

    private CoreDriver coreDriver;
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ConfigValues configValues;
    protected EnvValues envValues;
    protected PageTransporter pageTransporter;
    protected ToastMessage toastMessage;

    @BeforeClass
    public void beforeClass() {

        envValues = new EnvValues();
        configValues = new ConfigValues();
        toastMessage = new ToastMessage();

        coreDriver = new CoreDriver();
        driver = coreDriver.getWebDriver(DriverManagerType.CHROME);

        pageTransporter = new PageTransporter(driver);
    }

    @BeforeMethod
    public void login() {
        pageTransporter.navigateToLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.loginSuccessful(envValues.getUser(), envValues.getPassword());
    }

    @AfterClass
    public void tearDown() {
        coreDriver.quitDriver();
    }
}