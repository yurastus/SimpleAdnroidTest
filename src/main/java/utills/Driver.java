package utills;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import static view.CalculatorMainView.APPLICATION_PACKAGE;

//should be replaces with factory and values should be read from properties
public class Driver {

    public WebDriver initDriver(){
        try {
            return new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), setCapabilities());

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static DesiredCapabilities setCapabilities(){

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(CapabilityType.VERSION, "6.0");
        capabilities.setCapability("deviceName", "TEST");
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", APPLICATION_PACKAGE);
        capabilities.setCapability("appActivity", APPLICATION_PACKAGE + ".Calculator");
        capabilities.setCapability("avd","TEST");

        return capabilities;
    }

}