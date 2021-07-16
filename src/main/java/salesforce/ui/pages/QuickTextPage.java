package salesforce.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class returns an instance of QuickText.
 */
public class QuickTextPage extends BasePage {

    @FindBy(css = ".forceActionLink > div")
    private WebElement newQuickTextBtn;

    @FindBy(css = "input[aria-required=\"true\"]")
    private WebElement quickTextNameFld;

    public QuickTextPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newQuickTextBtn));
    }

    public void clickNewQuickText() {
        webElementAction.clickBtn(newQuickTextBtn);
    }

    public void setQuickText(String quickText) {
        webElementAction.setInputFields(quickTextNameFld, quickText);
    }
}
