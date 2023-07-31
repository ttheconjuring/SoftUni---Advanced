package robotService.entities.supplements;

public abstract class BaseSupplement implements Supplement {

    private final int hardness;
    private final double price;

    protected BaseSupplement(int hardness, double price) {
        this.hardness = hardness;
        this.price = price;
    }

    @Override
    public int getHardness() {
        return this.hardness;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
