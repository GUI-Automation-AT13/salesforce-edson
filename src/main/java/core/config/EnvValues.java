package core.config;

import core.utils.ReadFile;

/**
 * Read environment values.
 */
public class EnvValues {
    private ReadFile readFile;
    private String path = "environmentVariables.properties";

    public EnvValues() {
        this.readFile = new ReadFile(path);
    }

    public String getUser() {
        return readFile.getValue("USER");
    }

    public String getPassword() {
        return readFile.getValue("PASSWORD");
    }
}
