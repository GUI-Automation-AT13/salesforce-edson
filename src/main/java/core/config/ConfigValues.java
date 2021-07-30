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

    /**
     * Gets value of Explicit wait.
     *
     * @return a String with the value.
     */
    public String getExplicitWaitValue() {
        return readFile.getValue("EXPLICIT_WAIT");
    }

    /**
     * Gets value of Implicit wait.
     *
     * @return a String with the value.
     */
    public String getImplicitWaitTime() {
        return readFile.getValue("EXPLICIT_WAIT");
    }

    /**
     * Gets value of Login URL.
     *
     * @return a String with the value.
     */
    public String getLoginUrl() {
        return readFile.getValue("LOGIN_URL");
    }

    /**
     * Gets value of Base URL.
     *
     * @return a String with the value.
     */
    public String getBaseUrl() {
        return readFile.getValue("BASE_URL");
    }

    /**
     * Gets value of Home URL.
     *
     * @return a String with the value.
     */
    public String getHomeUrl() {
        return readFile.getValue("HOME");
    }

    /**
     * Gets value of Quick Text feature URL.
     *
     * @return a String with the value.
     */
    public String getQuickTextUrl() {
        return readFile.getValue("QUICK_TEXT");
    }

    /**
     * Gets value of Quick Text feature URL.
     *
     * @return a String with the value.
     */
    public String getGenericEndPointUrl() {
        return readFile.getValue("GENERIC_END_POINT_URL");
    }

    /**
     * Gets value of Browser selected.
     *
     * @return a String with the value.
     */
    public String getBrowser() {
        return readFile.getValue("BROWSER");
    }
}
