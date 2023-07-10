package JAVA_OOP.S_O_L_I_D_Exercise.solid.products.food;

public class Chocolate extends BaseFood {

    public static final double CALORIES_PER_100_GRAMS = 575;

    public Chocolate(double grams) {
        super(CALORIES_PER_100_GRAMS, grams);
    }

}
