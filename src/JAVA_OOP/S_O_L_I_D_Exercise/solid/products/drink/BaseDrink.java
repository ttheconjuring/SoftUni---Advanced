package JAVA_OOP.S_O_L_I_D_Exercise.solid.products.drink;

public abstract class BaseDrink implements Drink {

    private final double CALORIES_PER_100_GRAMS;
    public final double DENSITY;
    private final double milliliters;

    public BaseDrink(double CALORIES_PER_100_GRAMS, double DENSITY, double milliliters) {
        this.CALORIES_PER_100_GRAMS = CALORIES_PER_100_GRAMS;
        this.DENSITY = DENSITY;
        this.milliliters = milliliters;
    }

    private double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * (this.getMilliliters() * DENSITY);
    }

    @Override
    public double getLiters() {
        return this.getMilliliters() / 1000;
    }

    @Override
    public double getDENSITY() {
        return this.DENSITY;
    }

}
