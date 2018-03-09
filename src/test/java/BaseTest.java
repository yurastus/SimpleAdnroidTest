import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utills.Driver;

public class BaseTest {

    protected WebDriver driver;
    private AppiumDriverLocalService service;

    @BeforeTest
    public void setUp() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        driver = new Driver().initDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();

        service.stop();
    }

}