package JAVA_OOP.PolymorphismExercise.Vehicles;

public class Car extends VehicleImplementation {

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 0.9);
    }

}
