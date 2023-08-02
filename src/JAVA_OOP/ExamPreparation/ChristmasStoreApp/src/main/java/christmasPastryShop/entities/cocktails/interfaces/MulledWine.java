package christmasPastryShop.entities.cocktails.interfaces;

public class MulledWine extends BaseCocktail {

    private final static double DEFAULT_MULLED_WINE_PRICE = 3.50;

    public MulledWine(String name, int size, String brand) {
        super(name, size, DEFAULT_MULLED_WINE_PRICE, brand);
    }
}
