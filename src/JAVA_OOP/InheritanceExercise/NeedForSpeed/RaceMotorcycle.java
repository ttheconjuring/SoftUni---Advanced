package JAVA_OOP.InheritanceExercise.NeedForSpeed;

public class RaceMotorcycle extends Motorcycle {

    public RaceMotorcycle (double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(8);
    }

}
