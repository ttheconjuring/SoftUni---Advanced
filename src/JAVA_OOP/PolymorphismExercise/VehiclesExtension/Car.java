package JAVA_OOP.PolymorphismExercise.VehiclesExtension;

public class Car extends VehicleImplementation {

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 0.9, tankCapacity);
    }
}
