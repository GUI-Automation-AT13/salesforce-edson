package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class reads a properties file.
 */
public class DataValues {
    public static Properties ENV_VALUE = new Properties();
    public static Properties GET_VALUE = new Properties();

    static {
        try {
            ENV_VALUE = read("environmentVariables.properties");
            GET_VALUE = read("config.properties");
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("It was not possible to read the properties file", e);
        }
    }

    /**
     * Gets the values inside a properties file.
     *
     * @return the read properties.
     */
    public static Properties read(final String path) throws IOException {
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
    public static String obtainEnvVariables(final String variables) {
        if (ENV_VALUE.getProperty(variables) != null) {
            return ENV_VALUE.getProperty(variables);
        }
        return System.getenv(variables);
    }
}
