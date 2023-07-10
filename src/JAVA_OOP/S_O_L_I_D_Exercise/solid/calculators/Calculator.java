package JAVA_OOP.S_O_L_I_D_Exercise.solid.calculators;

import JAVA_OOP.S_O_L_I_D_Exercise.solid.products.Product;

import java.util.List;

public interface Calculator {

    double sum(List<Product> products);
    double average(List<Product> products);

}
