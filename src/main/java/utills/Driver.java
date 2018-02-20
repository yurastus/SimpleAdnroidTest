package utills;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import static view.CalculatorMainView.APPLICATION_PACKAGE;

public class Driver {

    public WebDriver initDriver(){

        String url = PropertyLoader.load("appium.url");
        String port = PropertyLoader.load("appium.port");

        StringBuilder accomplishedUrl = new StringBuilder()
                .append("http://")
                .append(url)
                .append(":")
                .append(port)
                .append("/wd/hub");

        try {
            return new RemoteWebDriver(new URL(accomplishedUrl.toString()), setCapabilities());

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static DesiredCapabilities setCapabilities(){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        String deviceName = PropertyLoader.load("device.name");

        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("avd",deviceName);

        capabilities.setCapability(CapabilityType.PLATFORM, PropertyLoader.load("platform"));
        capabilities.setCapability(CapabilityType.VERSION, PropertyLoader.load("version"));

        capabilities.setCapability("appPackage", APPLICATION_PACKAGE);
        capabilities.setCapability("appActivity", APPLICATION_PACKAGE + ".Calculator");

        return capabilities;
    }

}