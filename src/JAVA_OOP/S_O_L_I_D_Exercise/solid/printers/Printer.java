package JAVA_OOP.S_O_L_I_D_Exercise.solid.printers;

import JAVA_OOP.S_O_L_I_D_Exercise.solid.calculators.Calculator;
import JAVA_OOP.S_O_L_I_D_Exercise.solid.products.Product;

import java.util.List;

public class Printer {

    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    private final Calculator calculator;

    protected Printer(Calculator calculator) {
        this.calculator = calculator;
    }

    public void printSum(List<Product> products) {
        System.out.printf((SUM) + "%n", calculator.sum(products));
    }

    public void printAverage(List<Product> products) {
        System.out.printf((AVERAGE) + "%n", calculator.average(products));
    }

}
