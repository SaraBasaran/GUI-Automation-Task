package utility.UI;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    // ConfigurationReader class is created to read data from configuration.properties file.
    public static Properties properties;  // make static to call from everywhere of the project
        static {

        String path = "src/test/resources/configuration.properties";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
        //properties.getProperty("browser");
    }
}