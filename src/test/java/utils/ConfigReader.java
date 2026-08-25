package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {

        try {

            properties = new Properties();

            InputStream input =
                    ConfigReader.class
                            .getClassLoader()
                            .getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException(
                        "config.properties file not found"
                );
            }

            properties.load(input);

            input.close();

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to load config.properties", e
            );
        }
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);
    }
}