package core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class reads a properties file.
 */
public class ReadFile {
    private Properties propertiesFile = new Properties();

    /**
     * Read a file.
     *
     * @param path of the file.
     */
    public ReadFile(String path) {
        try {
            propertiesFile = read(path);
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("It was not possible to read the properties file", e);

        }
    }

    /**
     * Gets the values inside a properties file.
     *
     * @return the read properties.
     */
    private Properties read(final String path) throws IOException {
        Properties properties = new Properties();
        File file = new File(path);

        if (!file.exists()) {
            file.createNewFile();
        }
        try (InputStream reading = new FileInputStream(file)) {
            properties.load(reading);
        } catch (Exception e) {
            throw new RuntimeException("It was not possible to read the properties file", e);
        }
        return properties;
    }

    /**
     * Gets each value of the environment value from a configuration file or from the system environment variable.
     *
     * @param variables is the value to be obtained from the environment variables
     * @return the environment value
     */
    public String getValue(final String variables) {
        if (propertiesFile.getProperty(variables) != null) {
            return propertiesFile.getProperty(variables);
        }
        return System.getenv(variables);
    }
}
