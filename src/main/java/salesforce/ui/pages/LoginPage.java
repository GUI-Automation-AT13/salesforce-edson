package salesforce.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class returns an instance of LoginPage.
 */
public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement userNameTxtBox;

    @FindBy(id = "password")
    private WebElement passwordTxtBox;

    @FindBy(id = "Login")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
    }

    private LoginPage setUserName(final String userName) {
        webElementAction.setInputFields(userNameTxtBox, userName);
        return this;
    }

    private LoginPage setPassword(final String password) {
        webElementAction.setInputFields(passwordTxtBox, password);
        return this;
    }

    private void clickLoginBtn() {
        webElementAction.clickBtn(loginBtn);
    }

    /**
     * Execute the login action.
     *
     * @param userName of the name of user
     * @param password of the password of user
     * @return an instance of HomePage
     */
    public HomePage loginSuccessful(final String userName, final String password) {
        setUserName(userName);
        setPassword(password);
        clickLoginBtn();
        return new HomePage(driver);
    }
}