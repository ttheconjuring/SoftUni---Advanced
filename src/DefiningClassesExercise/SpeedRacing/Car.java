package DefiningClassesExercise.SpeedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostFor1Kilometer;
    private int distanceTravelled;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostFor1Kilometer() {
        return fuelCostFor1Kilometer;
    }

    public void setFuelCostFor1Kilometer(double fuelCostFor1Kilometer) {
        this.fuelCostFor1Kilometer = fuelCostFor1Kilometer;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public Car(String model, double fuelAmount, double fuelCostFor1Kilometer) {
        setModel(model);
        setFuelAmount(fuelAmount);
        setFuelCostFor1Kilometer(fuelCostFor1Kilometer);
        setDistanceTravelled(0);
    }

    public double theMaximumDistanceACarCanTravel() {
        return this.fuelAmount / this.fuelCostFor1Kilometer;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.getModel(), this.getFuelAmount(), this.getDistanceTravelled());
    }

}
