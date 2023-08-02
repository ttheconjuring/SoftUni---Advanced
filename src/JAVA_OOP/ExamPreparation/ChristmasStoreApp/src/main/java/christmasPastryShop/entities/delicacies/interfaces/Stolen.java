package christmasPastryShop.entities.delicacies.interfaces;

public class Stolen extends BaseDelicacy {

    private final static double INITIAL_STOLEN_PORTION = 250;

    public Stolen(String name, double price) {
        super(name, INITIAL_STOLEN_PORTION, price);
    }
}
