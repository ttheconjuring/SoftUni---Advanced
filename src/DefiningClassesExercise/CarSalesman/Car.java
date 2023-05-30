package DefiningClassesExercise.CarSalesman;

public class Car {

    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car() {

    }

    public Car(String model, Engine engine) {
        setModel(model);
        setEngine(engine);
        setWeight("n/a");
        setColor("n/a");
    }

    public Car(String model, Engine engine, String weight) {
        setModel(model);
        setEngine(engine);
        setWeight("n/a");
        setColor("n/a");
    }

    public Car(String model, Engine engine, String weight, String color) {
        setModel(model);
        setEngine(engine);
        setWeight(weight);
        setColor(color);
    }

    @Override
    public String toString() {
        return String.format("%s:%n%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s%n", this.getModel(), this.getEngine().getModel(), this.getEngine().getPower(), this.getEngine().getDisplacement(), this.getEngine().getEfficiency(), this.getWeight(), this.getColor());
    }

}
