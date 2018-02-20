package utills;

import java.io.IOException;
import java.util.Properties;

public class Property {

    private static final String PROP_FILE = "/android.properties";
    private static Properties props = new Properties();

    static {
        try {
            props.load(Property.class.getResourceAsStream(PROP_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Property(){}

    public static String load(String name) {
        return props.getProperty(name);
    }

}