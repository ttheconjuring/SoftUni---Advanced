package JAVA_OOP.PolymorphismExercise.VehiclesExtension;

public class Bus extends VehicleImplementation {
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    private boolean busIsEmpty = true;

    private boolean isBusIsEmpty() {
        return this.busIsEmpty;
    }

    public void setBusIsEmpty(boolean busIsEmpty) {
        this.busIsEmpty = busIsEmpty;
    }

    @Override
    public void drive(double distance) {
        if (!this.isBusIsEmpty()) {
            super.setFuelConsumption(this.getFuelConsumption() + 1.4);
            super.drive(distance);
            super.setFuelConsumption(this.getFuelConsumption() - 1.4);
        } else {
            super.drive(distance);
        }
    }

}
