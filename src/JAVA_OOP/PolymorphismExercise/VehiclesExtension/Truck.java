package JAVA_OOP.PolymorphismExercise.VehiclesExtension;

public class Truck extends VehicleImplementation {
    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 1.6, tankCapacity);
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel * 0.95);
    }

}
