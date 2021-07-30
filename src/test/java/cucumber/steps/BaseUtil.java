package cucumber.steps;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import salesforce.ui.PageTransporter;
import salesforce.ui.ToastMessage;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.quicktext.BodyQuickText;

public class BaseUtil {
    public LoginPage loginPage;
    public WebDriver driver;
    public PageTransporter pageTransporter;
    public BodyQuickText bodyQuickText;
    public ToastMessage toastMessage;
    public SoftAssert softAssert;
}
