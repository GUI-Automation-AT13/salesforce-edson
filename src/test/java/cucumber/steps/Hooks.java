package cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.asserts.SoftAssert;
import salesforce.ui.PageTransporter;
import salesforce.ui.ToastMessage;

import static core.selenium.MyWebDriverManager.getWebDriverManager;

public class Hooks {

    private BaseUtil base;

    public Hooks(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void init() {
        base.pageTransporter = new PageTransporter();
        base.loginPage = base.pageTransporter.navigateToLoginPage();
        base.toastMessage = new ToastMessage();
        base.softAssert = new SoftAssert();
    }

    @After
    public void AssertAll() {
        base.softAssert.assertAll();
    }

    @After
    public void tearDown() {
        getWebDriverManager().quitDriver();
    }
}
