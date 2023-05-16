package calculators;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator calc = new Calculator();
    @DataProvider(name="TestAdd")
        public Object[][] calcProvider() {
            return new Object[][] {
                    {1,2,3},
                    {2,3,5},
                    {6,7,13}
            };
    }
    @DataProvider(name="TestDiv")
    public Object[][] calcProviderDiv() {
        return new Object[][] {
                {2,5,10},
                {3,6,18},
                {2,2,4}
        };
    }
    @Test(dataProvider = "TestAdd")
    public void testCalculatorAdd(double a, double b, double sum) {
        assertThat(calc.add(a,b)).isEqualTo(sum);
    }
    @Test(dataProvider = "TestAdd")
    public void testCalculatorSubstract(double sum, double b, double a) {
        assertThat(calc.subtract(a,b)).isEqualTo(sum);
    }
    @Test(dataProvider = "TestDiv")
    public void testCalculatorMultiply(double a, double b, double sum) {
        assertThat(calc.multiply(a,b)).isEqualTo(sum);
    }
    @Test(dataProvider = "TestDiv")
    public void testCalculatorDiv(double sum, double b, double a) {
        assertThat(calc.divide(a,b)).isEqualTo(sum);
    }
    @Test
    public void testOperations(){
        Calculator operations = new Calculator();
        operations.add(4,6);
        operations.divide(10,2);
    List<String> listOfOperations = operations.printOperations();
    assertThat(listOfOperations)
            .hasSize(2)
            .contains("Added 4.0 to 6.0 got result 10.0")
            .contains("Divided 10.0 by 2.0 got result 5.0");

    }
    @Test
    public void testResetOperations(){
        Calculator operations = new Calculator();
        operations.add(4,6);
        operations.divide(10,2);
        operations.resetOperations();
        List<String> listOfOperations = operations.printOperations();
        assertThat(listOfOperations)
                .hasSize(0);


    }
}

