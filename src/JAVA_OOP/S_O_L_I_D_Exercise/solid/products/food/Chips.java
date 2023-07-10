package JAVA_OOP.S_O_L_I_D_Exercise.solid.products.food;

public class Chips extends BaseFood {

    private static final double CALORIES_PER_100_GRAMS = 529;

    public Chips(double grams) {
        super(CALORIES_PER_100_GRAMS, grams);
    }

}
