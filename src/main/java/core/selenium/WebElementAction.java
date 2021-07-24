package core.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Helps with filling the web elements.
 */
public class WebElementAction {
    private WebDriver driver;
    private WebDriverWait wait;

    public WebElementAction(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    /**
     * Sets a WebElement with a value.
     *
     * @param webElement type WebElement object.
     * @param text value to be set.
     */
    public void setInputFields(WebElement webElement, String text) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * Sets a WebElement with a value without clear this field.
     *
     * @param webElement type WebElement object.
     * @param text value to be set.
     */
    public void setInputFieldsWithoutClear(WebElement webElement, String text) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);
    }

    /**
     * Clicks a WebElement.
     *
     * @param webElement type WebElement object.
     */
    public void clickBtn(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }

    /**
     * Clicks in a option in a Dropdown.
     *
     * @param option value to be set.
     */
    public void clickDropdownOption(String option) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(option)));
        driver.findElement(By.linkText(option)).click();
    }

    /**
     * Gets a text value of the WebElement.
     *
     * @param webElement type WebElement object.
     * @return a String with the value.
     */
    public String getTextOutput(WebElement webElement) {
        return webElement.getText();
    }
}
