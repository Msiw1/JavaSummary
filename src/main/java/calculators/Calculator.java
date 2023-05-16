package calculators;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    protected List<String> operations;

    public Calculator() {
        this.operations = new ArrayList<>();
    }

    public List<String> printOperations() {
       return operations;
    }

    public void addOperation(String operation) {
        operations.add(operation);
    }

    public void resetOperations() {
        this.operations = new ArrayList<>();
    }

    public double add(double x, double y) {
        double result = x+y;
        addOperation("Added " + x + " to " + y + " got result " + result);
        return result;
    }

    public double subtract(double x, double y) {
        double result = x-y;
        addOperation("Subtracted " + y + " from " + x + " got result " + result);
        return result;
    }

    public double multiply(double x, double y) {
        double result = x*y;
        addOperation("Multiplied " + x + " by " + y + " got result " + result);
        return result;
    }

    public double divide(double x, double y) {
        double result = x/y;
        addOperation("Divided " + x + " by " + y + " got result " + result);
        return result;
    }
}
