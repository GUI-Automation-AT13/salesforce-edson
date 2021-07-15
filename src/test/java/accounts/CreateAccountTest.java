package accounts;

import base.BaseTest;
import org.testng.annotations.Test;
import salesforece.ui.pages.HomePage;

public class CreateAccountTest extends BaseTest {
    @Test
    public void login() {
        HomePage homePage = loginPage.loginSuccessful(envValues.getUser(), envValues.getPassword());

    }
}