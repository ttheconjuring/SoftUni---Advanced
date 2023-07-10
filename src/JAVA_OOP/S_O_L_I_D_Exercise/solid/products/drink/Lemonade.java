package JAVA_OOP.S_O_L_I_D_Exercise.solid.products.drink;

public class Lemonade extends BaseDrink {

    public static final double CALORIES_PER_100_GRAMS = 53;
    public static final double DENSITY = 0.7;

    public Lemonade(double milliliters) {
        super(CALORIES_PER_100_GRAMS, DENSITY, milliliters);
    }

}
