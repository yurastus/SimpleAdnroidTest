package utills;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    private static final String PROP_FILE = "/android.properties";
    private static Properties props = new Properties();

    private PropertyLoader(){}

    public static String loadProperty(String name) {

        try {
            props.load(PropertyLoader.class.getResourceAsStream(PROP_FILE));
            return props.getProperty(name);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}