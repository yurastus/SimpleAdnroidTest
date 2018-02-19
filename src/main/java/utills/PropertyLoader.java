package utills;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    private static final String PROP_FILE = "/android.properties";
    private static Properties props = new Properties();

    static {
        try {
            props.load(PropertyLoader.class.getResourceAsStream(PROP_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PropertyLoader(){}

    public static String loadProperty(String name) {
        return props.getProperty(name);
    }

}