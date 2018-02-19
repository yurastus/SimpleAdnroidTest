import org.testng.Assert;
import org.testng.annotations.Test;
import view.CalculatorMainView;

public class CalculatorTest extends BaseTest{

    @Test
    public void shouldAddTwoDigitsTest() {

        CalculatorMainView calculator = new CalculatorMainView(driver);

        calculator.getThreeButton().click();
        calculator.add();
        calculator.getSevenButton().click();
        calculator.evaluate();

        Assert.assertEquals(calculator.getResult(),"10");
    }


}