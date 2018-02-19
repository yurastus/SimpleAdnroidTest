package view;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

@Data
public class CalculatorMainView {

    public static final String APPLICATION_PACKAGE = "com.android.calculator2";

    @FindBy(id = APPLICATION_PACKAGE + ":id/result")
    private WebElement resultField;
    @FindBy(id = APPLICATION_PACKAGE + ":id/digit_7")
    private WebElement sevenButton;
    @FindBy(id = APPLICATION_PACKAGE + ":id/digit_3")
    private WebElement threeButton;
    @FindBy(id = APPLICATION_PACKAGE + ":id/op_add")
    private WebElement plusButton;
    @FindBy(id = APPLICATION_PACKAGE + ":id/eq")
    private WebElement equalsButton;

    public CalculatorMainView(WebDriver driver){
        driver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);

        PageFactory.initElements(driver, this);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(equalsButton));
    }

    public void add(){
        plusButton.click();
    }

    public void evaluate(){
        equalsButton.click();
    }

    public String getResult(){
        return resultField.getText();
    }

}
