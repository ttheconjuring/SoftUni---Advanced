package JAVA_OOP.PolymorphismExercise.Vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImplementation implements Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    public VehicleImplementation(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    private void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    private double getFuelConsumption() {
        return fuelConsumption;
    }

    private void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public void drive(double distance) {
        if (this.getFuelConsumption() * distance <= this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - (this.getFuelConsumption() * distance));
            DecimalFormat format = new DecimalFormat("#.##");
            System.out.printf("%s travelled %s km\n", this.getClass().getSimpleName(), format.format(distance));
        } else {
            System.out.printf("%s needs refueling\n", this.getClass().getSimpleName());
        }
    }

    @Override
    public void refuel(double fuel) {
        this.setFuelQuantity(this.getFuelQuantity() + fuel);
    }

}
