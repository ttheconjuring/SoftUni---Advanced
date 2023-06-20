package DefiningClassesExercise.RawData;

public class Car {

    private String model;

    private Engine engine;

    private Cargo cargo;

    private Tire tire;

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Tire getTire() {
        return this.tire;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public Car(String model, Engine engine, Cargo cargo, Tire tire) {
        setModel(model);
        setEngine(engine);
        setCargo(cargo);
        setTire(tire);
    }
}
