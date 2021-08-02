package salesforce.ui.pages.quicktext;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.entity.QuickText;
import salesforce.ui.pages.BasePage;

/**
 * Form for create a New Quick Text.
 */
public class NewQuickText extends BasePage {

    private static final String COMBO_BOX = "//span[text() ='%s']//..//..//a[@role='button']";
    private static final String CHANNEL_XPATH = "//select //option[contains(@value,'%s')]";
    private static final String BTN_CSS = "button[title = '%s']";

    @FindBy(css = "input[aria-required='true']")
    private WebElement nameFld;

    @FindBy(id = "quickTextMessageInputTextArea")
    private WebElement messageFld;

    @FindBy(css = "button[title = 'Save']")
    private WebElement saveBtn;

    @FindBy(css = "div[class='messageFieldContainer'] .select[aria-required='false']")
    private WebElement fieldComboBox;

    @FindBy(css = "[class='buttonCol'] [class]")
    private WebElement insertBtn;

    @FindBy(xpath = "//div[contains(@class,'forceInputPicklist')] //a[contains(text(), 'Greetings')]")
    private WebElement categoryComboBox;

    @FindBy(css = "input[checked='checked']")
    private WebElement checkBtn;

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameFld));
    }

    public NewQuickText setName(String quickText) {
        webElementAction.setInputFields(nameFld, quickText);
        return this;
    }

    /**
     * Insert two options for Message.
     *
     * @param relatedTo option for Related To Combo Box.
     * @param field     option for Field Combo Box.
     * @return this object.
     */
    public NewQuickText insertMergeField(String relatedTo, String field) {
        chooseComboBoxOption("Related To", relatedTo);
        chooseComboBoxOption("Field", field);
        clickInsertBtn();
        return this;
    }

    /**
     * Choose a option for any Combo box.
     *
     * @param comboBox string to choose a specific Combo Box.
     * @param option   Option to choose.
     * @return this object.
     */
    public NewQuickText chooseComboBoxOption(String comboBox, String option) {
        webElementAction.clickBtn(driver.findElement(By.xpath(String.format(COMBO_BOX, comboBox))));
        webElementAction.clickDropdownOption(option);
        return this;
    }

    /**
     * Clicks in Insert Button.
     *
     * @return this object.
     */
    private NewQuickText clickInsertBtn() {
        webElementAction.clickBtn(insertBtn);
        return this;
    }

    /**
     * Sets a text in the message.
     *
     * @param quickText String withe the value to be set.
     * @return this object.
     */
    public NewQuickText setMessage(String quickText) {
        webElementAction.setInputFieldsWithoutClear(messageFld, quickText);
        return this;
    }

    /**
     * Choose a specific option for Channel.
     *
     * @param channelOption option to choose.
     * @return this object.
     */
    public NewQuickText chooseChannel(String channelOption) {
        webElementAction.clickBtn(driver.findElement(By.xpath(String.format(CHANNEL_XPATH, channelOption))));
        clickBtnWithCssSelector("Add");
        return this;
    }

    /**
     * Clicks Check Button.
     *
     * @return this object.
     */
    public NewQuickText clickCheckBtn() {
        webElementAction.clickBtn(checkBtn);
        return this;
    }

    /**
     * Clicks Save Button.
     *
     * @return this object.
     */
    public BodyQuickText clickSaveBtn() {
        clickBtnWithCssSelector("Save");
        return new BodyQuickText();
    }

    /**
     * Clicks in selector option.
     *
     * @param button a String withe value to be click.
     */
    private void clickBtnWithCssSelector(String button) {
        webElementAction.clickBtn(driver.findElement(By.cssSelector(String.format(BTN_CSS, button))));
    }

    /**
     * Sets NewQuickText webElement.
     *
     * @return a BodyQuickText page.
     */
    public BodyQuickText createQuickText(Set<String> fields, QuickText quickText) {
        Map<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setName(quickText.getName()));
        strategyMap.put("Related To", () -> chooseComboBoxOption("Related To", quickText.getRelatedTo()));
        strategyMap.put("Field", () -> chooseComboBoxOption("Field", quickText.getField()).clickInsertBtn());
        strategyMap.put("Message", () -> setMessage(quickText.getMessage()));
        strategyMap.put("Category", () -> chooseComboBoxOption("Category", quickText.getCategory()));
        strategyMap.put("Channel", () -> chooseChannel(quickText.getChannel()));

        fields.forEach(field -> strategyMap.get(field).run());
        return clickSaveBtn();
    }
}
