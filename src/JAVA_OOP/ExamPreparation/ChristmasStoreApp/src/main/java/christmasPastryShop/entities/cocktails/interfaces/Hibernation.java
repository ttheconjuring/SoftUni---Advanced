package christmasPastryShop.entities.cocktails.interfaces;

public class Hibernation extends BaseCocktail {

    private final static double DEFAULT_HIBERNATION_PRICE = 4.50;

    public Hibernation(String name, int size, String brand) {
        super(name, size, DEFAULT_HIBERNATION_PRICE, brand);
    }
}
