package JAVA_OOP.S_O_L_I_D_Exercise.solid.products.drink;

public class Coke extends BaseDrink {

    public static final double CALORIES_PER_100_GRAMS = 44;
    public static final double DENSITY = 0.6;

    public Coke(double milliliters) {
        super(CALORIES_PER_100_GRAMS, DENSITY, milliliters);
    }

}
