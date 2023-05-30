package DefiningClassesExercise.CarSalesman;

public class Engine {

    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public Engine() {

    }

    public Engine(String model, String power) {
        setModel(model);
        setPower(power);
        setDisplacement("n/a");
        setEfficiency("n/a");
    }

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }
}
