package JAVA_OOP.PolymorphismExercise.Vehicles;

public class Truck extends VehicleImplementation {

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 1.6);
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel * 0.95);
    }

}
