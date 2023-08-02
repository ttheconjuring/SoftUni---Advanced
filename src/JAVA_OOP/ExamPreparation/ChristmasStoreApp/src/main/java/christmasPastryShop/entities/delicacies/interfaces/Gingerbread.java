package christmasPastryShop.entities.delicacies.interfaces;

public class Gingerbread extends BaseDelicacy {

    private final static double INITIAL_GINGERBREAD_PORTION = 200;

    public Gingerbread(String name, double price) {
        super(name, INITIAL_GINGERBREAD_PORTION, price);
    }
}
