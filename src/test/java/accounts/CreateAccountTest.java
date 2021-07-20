package accounts;

import base.BaseTest;
import salesforece.ui.pages.HomePage;

import static core.DataValues.obtainEnvVariables;

public class CreateAccountTest extends BaseTest {
    HomePage homePage = loginPage.loginSuccessful(obtainEnvVariables("USER"), obtainEnvVariables("PASSWORD"));
}