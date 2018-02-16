import org.testng.Assert;
import org.testng.annotations.Test;
import view.CalculatorMainView;

public class CalculatorTest extends BaseTest{

    @Test
    public void threePlusSevenTest() {

        CalculatorMainView calculator = new CalculatorMainView(driver);

        calculator.getThreeButton().click();
        calculator.getPlusButton().click();
        calculator.getSevenButton().click();
        calculator.getEqualsButton().click();

        Assert.assertEquals(calculator.getResult(),"10");
    }


}