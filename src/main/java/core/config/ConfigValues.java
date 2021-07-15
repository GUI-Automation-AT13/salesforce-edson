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

    public String getLoginUrl() {
        return readFile.getValue("LOGIN_URL");
    }
}
