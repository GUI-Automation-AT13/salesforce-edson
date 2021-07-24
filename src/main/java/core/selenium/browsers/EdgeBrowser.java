package core.selenium.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Class for obtains a Firefox Driver.
 */
public class EdgeBrowser implements Ibrowser {

    /**
     * Gets the browser's driver.
     *
     * @return the web driver
     */
    @Override
    public WebDriver getDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
