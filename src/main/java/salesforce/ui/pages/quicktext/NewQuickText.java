package salesforce.ui.pages.quicktext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * Form for create a New Quick Text.
 */
public class NewQuickText extends BasePage {

    @FindBy(css = "input[aria-required=\"true\"]")
    private WebElement quickTextNameFld;

    @FindBy(id = "quickTextMessageInputTextArea")
    private WebElement quickTextMessageFld;

    @FindBy(css = ".slds-button:nth-child(4) > .label")
    private WebElement quickTextSaveBtn;

    public NewQuickText(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(quickTextNameFld));
    }

    public void setName(String quickText) {
        webElementAction.setInputFields(quickTextNameFld, quickText);
    }

    public void setMessage(String quickText) {
        webElementAction.setInputFields(quickTextMessageFld, quickText);
    }

    public BodyQuickText clickSaveBtn() {
        webElementAction.clickBtn(quickTextSaveBtn);
        return new BodyQuickText(driver);
    }
}
