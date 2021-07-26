package salesforce.ui.pages.quicktext;

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
}
