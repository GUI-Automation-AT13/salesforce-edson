package salesforce.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import salesforce.ui.PageTransporter;
import salesforce.ui.ToastMessage;
import salesforce.ui.pages.LoginPage;

import static core.selenium.MyWebDriverManager.getWebDriverManager;
import static core.utils.LoadFiles.envValues;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected PageTransporter pageTransporter;
    protected ToastMessage toastMessage;

    @BeforeClass
    public void beforeClass() {

        toastMessage = new ToastMessage();
        driver = getWebDriverManager().getDriver();
        pageTransporter = new PageTransporter();
        login();
    }

    public void login() {
        pageTransporter.navigateToLoginPage();
        loginPage = new LoginPage();
        loginPage.loginSuccessful(envValues.getUser(), envValues.getPassword());
    }

    @AfterClass
    public void tearDown() {
        getWebDriverManager().quitDriver();
    }
}