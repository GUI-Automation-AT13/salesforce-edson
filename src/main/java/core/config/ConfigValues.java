package core.config;

import core.utils.ReadFile;

/**
 * Read config values.
 */
public class ConfigValues {
    private ReadFile readFile;
    private String path = "config.properties";

    public ConfigValues() {
        this.readFile = new ReadFile(path);
    }

    public String getExplicitWaitValue() {
        return readFile.getValue("EXPLICIT_WAIT");
    }

    public String getLoginUrl() {
        return readFile.getValue("LOGIN_URL");
    }

    public String getBaseUrl() {
        return readFile.getValue("BASE_URL");
    }

    public String getHomeUrl() {
        return readFile.getValue("HOME");
    }

    public String getQuickTextUrl() {
        return readFile.getValue("QUICK_TEXT");
    }
}
