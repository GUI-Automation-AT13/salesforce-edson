package salesforce.ui.pages.quicktext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * Page With a Quick Text.
 */
public class BodyQuickText extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'entityNameTitle')]")
    private WebElement entityNameTitle;

    @FindBy(css = ".slds-grid:nth-child(1) > .slds-col > .slds-form-element .uiOutputText")
    private WebElement textOutputQuickText;

    public BodyQuickText(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(entityNameTitle));
    }

    public String getTextName() {
        return webElementAction.getTextOutput(textOutputQuickText);
    }
}
