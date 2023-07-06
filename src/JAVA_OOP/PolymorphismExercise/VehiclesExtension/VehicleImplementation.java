package JAVA_OOP.PolymorphismExercise.VehiclesExtension;

import java.text.DecimalFormat;

public abstract class VehicleImplementation implements Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public VehicleImplementation(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    private void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    private double getTankCapacity() {
        return tankCapacity;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    @Override
    public void drive(double distance) {
        double fuelRequiredToCompleteTheJourney = this.getFuelConsumption() * distance;
        if (fuelRequiredToCompleteTheJourney <= this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - fuelRequiredToCompleteTheJourney);
            DecimalFormat format = new DecimalFormat("#.##");
            System.out.printf("%s travelled %s km\n", this.getClass().getSimpleName(), format.format(distance));
        } else {
            System.out.printf("%s needs refueling\n", this.getClass().getSimpleName());
        }
    }

    @Override
    public void refuel(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if (this.getFuelQuantity() + fuel > this.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuelQuantity(this.getFuelQuantity() + fuel);
    }

}
