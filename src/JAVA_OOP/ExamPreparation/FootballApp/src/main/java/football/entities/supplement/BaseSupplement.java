package football.entities.supplement;

public abstract class BaseSupplement implements Supplement {

    private int energy;
    private double price;

    protected BaseSupplement(int energy, double price) {
        this.setEnergy(energy);
        this.setPrice(price);
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    private void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

}
