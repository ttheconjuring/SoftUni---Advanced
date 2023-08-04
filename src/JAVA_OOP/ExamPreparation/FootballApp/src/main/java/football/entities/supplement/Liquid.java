package football.entities.supplement;

public class Liquid extends BaseSupplement {

    private final static int DEFAULT_ENERGY = 90;
    private final static double DEFAULT_PRICE = 25;

    public Liquid() {
        super(DEFAULT_ENERGY, DEFAULT_PRICE);
    }
}
