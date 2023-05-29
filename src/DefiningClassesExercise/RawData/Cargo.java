package DefiningClassesExercise.RawData;

public class Cargo {

    private int cargoWeight;
    private String cargoType;

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public Cargo(int cargoWeight, String cargoType) {
        setCargoWeight(cargoWeight);
        setCargoType(cargoType);
    }
}
