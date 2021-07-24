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

    @FindBy(xpath = "//span[contains(@class,'toastMessage')]")
    private WebElement toastMessage;

    private static final String FORM_CONTENT = "//span[contains(text(),'%s')] /../..//span[@class='uiOutputText']";

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(entityNameTitle));
    }

    /**
     * Gets a title of the page.
     *
     * @return a String with the value.
     */
    public String getTitle() {
        return webElementAction.getTextOutput(nameTitle);
    }

    /**
     * Gets the param name of the form.
     *
     * @return a String with the value.
     */
    public String getFormName() {
        return webElementAction.getTextOutput(
                driver.findElement(By.xpath(String.format(FORM_CONTENT, "Quick Text Name"))));
    }

    /**
     * Gets the message of the popup.
     *
     * @return a String with the value.
     */
    public String getToastMessage() {
        return webElementAction.getTextOutput(toastMessage);
    }
}
