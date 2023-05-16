package calculators;
import org.assertj.core.data.Offset;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class EnterpriseCalculatorTest {
    EnterpriseCalculator calc = new EnterpriseCalculator();

    @DataProvider(name="TestDollar")
    public Object[][] calcProvider() {
        return new Object[][] {
                {415,100},
                {1000,240.96},
                {333,80.24}
        };
    }
    @DataProvider(name="TestEuro")
    public Object[][] calcProviderDiv() {
        return new Object[][] {
                {466,100},
                {1000,214.59},
                {57.7,12.38}
        };
    }
    @Test(priority = 2, dataProvider = "TestDollar")
    public void testCalculatorDollar(double pln, double sum) {
        assertThat(calc.convertToUsd(pln)).isCloseTo(sum, Offset.offset(0.01));
    }
    @Test(priority = 2, dataProvider = "TestEuro")
    public void testCalculatorEuro(double pln, double sum) {
        assertThat(calc.convertToEuro(pln)).isCloseTo(sum, Offset.offset(0.01));
    }
    @Test(priority = 1)
    public void testOperations(){

        EnterpriseCalculator operations = new EnterpriseCalculator();
        operations.convertToEuro(1250);
        operations.convertToUsd(333);
        int counter = EnterpriseCalculator.getOperationsCounter();
        assertThat(counter)
                .isEqualTo(2);

    }
}
