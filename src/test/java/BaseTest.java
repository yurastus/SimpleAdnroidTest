import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utills.Driver;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new Driver().initDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}