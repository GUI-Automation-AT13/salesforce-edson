package salesforce.ui.pages.quicktext;

import org.openqa.selenium.By;
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

    @FindBy(css = "[class='slds-media__body'] span[class='uiOutputText']")
    private WebElement nameTitle;

    @FindBy(css = ".slds-grid:nth-child(1) > .slds-col > .slds-form-element .uiOutputText")
    private WebElement formName;

    @FindBy(xpath = "//span[contains(@class,'toastMessage')]")
    private WebElement toastMessage;

    private static final String FORM_CONTENT = "//span[contains(text(),'%s')] /../..//span[@class='uiOutputText']";

    public BodyQuickText() {
        super();
    }

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(entityNameTitle));
    }

    public String getTitle() {
        return webElementAction.getTextOutput(nameTitle);
    }

    public String getFormName() {
        return webElementAction.getTextOutput(
                driver.findElement(By.xpath(String.format(FORM_CONTENT, "Quick Text Name"))));
    }

    public String getToastMessage() {
        return webElementAction.getTextOutput(toastMessage);
    }
}
