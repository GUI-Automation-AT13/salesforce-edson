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

    @FindBy(xpath = "//span[contains(text(),'Include in selected channels')]/../..//img")
    private WebElement includeChannelCheckBox;

    private static final String
            FORM_CONTENT = "//span[contains(text(),'%s')] /../../span[contains(@class,'slds-form-element')]/span";

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
     * Gets the param message of the form.
     *
     * @return a String with the value.
     */
    public String getFormMessage() {
        return webElementAction.getTextOutput(
                driver.findElement(By.xpath(String.format(FORM_CONTENT, "Message"))));
    }

    /**
     * Gets the param category of the form.
     *
     * @return a String with the value.
     */
    public String getFormCategory() {
        return webElementAction.getTextOutput(
                driver.findElement(By.xpath(String.format(FORM_CONTENT, "Category"))));
    }

    /**
     * Gets the param channel of the form.
     *
     * @return a String with the value.
     */
    public String getFormChannel() {
        return webElementAction.getTextOutput(
                driver.findElement(By.xpath(String.format(FORM_CONTENT, "Channel"))));
    }

    /**
     * Gets the value of Include Channel of the form.
     *
     * @return a String with the value.
     */
    public String getFormIncludeChannel() {
        return webElementAction.getAttribute(includeChannelCheckBox, "alt");
    }

    /**
     * Gets the message of the popup.
     *
     * @return a String with the value.
     */
    public String getToastMessage() {
        return webElementAction.getTextOutput(toastMessage);
    }

    /**
     * Builds the final message with all the parameters.
     *
     * @param relatedToOption a String of the related options.
     * @param fieldOption     a String of the fields options.
     * @param message         a String with the message initial.
     * @return the final message String.
     */
    public String finalMessage(String relatedToOption, String fieldOption, String message) {
        return "{!" + relatedToOption + "." + fieldOption.replaceAll(" ", "") + "} " + message;
    }

    /**
     * Builds the final channel with the channels adds.
     *
     * @param channel a String of the channel.
     * @return the final channel String
     */
    public String finalChannel(String channel) {
        return "Email;" + channel;
    }
}
