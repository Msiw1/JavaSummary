package calculators;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class PremiumCalculatorTest {
    PremiumCalculator calc = new PremiumCalculator();
    @DataProvider(name="TestPow")
    public Object[][] calcProvider() {
        return new Object[][] {
                {2,2,4},
                {2,3,8},
                {3,3,27}
        };
    }
    @Test(dataProvider = "TestPow")
    public void testCalculatorAdd(double a, double b, double sum) {
        assertThat(calc.pow(a,b)).isEqualTo(sum);
    }
    @Test
    public void testOperations(){
        PremiumCalculator operations = new PremiumCalculator();
        operations.add(4,6);
        operations.pow(4,4);
        String data = "[" + String.valueOf(java.time.LocalDate.now()) + "] ";
        List<String> listOfOperations = operations.printOperations();
        assertThat(listOfOperations)
                .hasSize(2)
                .contains(data + "Added 4.0 to 6.0 got result 10.0")
                .contains(data + "4.0 to the power of 4.0 is 256.0");

    }


}
