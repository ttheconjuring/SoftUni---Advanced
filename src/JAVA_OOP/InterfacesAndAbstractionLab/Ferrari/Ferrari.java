package JAVA_OOP.InterfacesAndAbstractionLab.Ferrari;

public class Ferrari implements Car {

    private final String driverName;
    private static final String MODEL = "488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", MODEL, this.brakes(), this.gas(), this.driverName);
    }

}
