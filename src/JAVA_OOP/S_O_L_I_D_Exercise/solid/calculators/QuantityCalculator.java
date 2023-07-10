package JAVA_OOP.S_O_L_I_D_Exercise.solid.calculators;

import JAVA_OOP.S_O_L_I_D_Exercise.solid.products.drink.Drink;
import JAVA_OOP.S_O_L_I_D_Exercise.solid.products.food.Food;
import JAVA_OOP.S_O_L_I_D_Exercise.solid.products.Product;

import java.util.List;

public class QuantityCalculator implements Calculator {

    @Override
    public double sum(List<Product> products) {
        int sum = 0;
        for (Product product : products) {
            if (product instanceof Food) {
                sum += ((Food) product).getKilograms();
            } else {
                sum += ((Drink) product).getLiters() * ((Drink) product).getDENSITY();
            }
        }
        return sum;
    }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }

}
