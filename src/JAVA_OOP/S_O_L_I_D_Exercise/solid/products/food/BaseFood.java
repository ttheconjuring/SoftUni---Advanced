package JAVA_OOP.S_O_L_I_D_Exercise.solid.products.food;

public abstract class BaseFood implements Food {

    private final double CALORIES_PER_100_GRAMS;

    private final double grams;

    public BaseFood(double CALORIES_PER_100_GRAMS, double grams) {
        this.CALORIES_PER_100_GRAMS = CALORIES_PER_100_GRAMS;
        this.grams = grams;
    }

    private double getGrams() {
        return grams;
    }

    @Override
    public double getCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * this.getGrams();
    }

    @Override
    public double getKilograms() {
        return this.getGrams() / 1000;
    }

}
