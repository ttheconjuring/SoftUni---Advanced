package JAVA_OOP.S_O_L_I_D_Exercise.solid.calculators;

import JAVA_OOP.S_O_L_I_D_Exercise.solid.products.Product;

import java.util.List;

public class CalorieCalculator implements Calculator {

    @Override
    public double sum(List<Product> products) {
        return products.stream().mapToDouble(Product::getCalories).sum();
    }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }

}
