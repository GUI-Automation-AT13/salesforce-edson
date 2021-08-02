package salesforce.ui.pages.quicktext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * This class returns an instance of QuickText.
 */
public class QuickTextPage extends BasePage {

    @FindBy(css = ".forceActionLink > div")
    private WebElement newQuickTextBtn;

    private static final String AN_NAME_OF_CONTENT = "a[title='%s']";

    public QuickTextPage() {
        super();
    }

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newQuickTextBtn));
    }

    public NewQuickText clickNewQuickText() {
        webElementAction.clickBtn(newQuickTextBtn);
        return new NewQuickText();
    }

    /**
     * Gets a name of the content.
     *
     * @return a String with the value.
     */
    public String getAnNameOfContent(String name) {
        return webElementAction.getTextOutput(
                driver.findElement(By.cssSelector(String.format(AN_NAME_OF_CONTENT, name))));
    }
}
