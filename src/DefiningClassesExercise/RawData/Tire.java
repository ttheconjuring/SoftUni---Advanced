package DefiningClassesExercise.RawData;

public class Tire {

    private double tire1Pressure;
    private int tire1Age;
    private double tire2Pressure;
    private int tire2Age;
    private double tire3Pressure;
    private int tire3Age;
    private double tire4Pressure;
    private int tire4Age;

    public double getTire1Pressure() {
        return tire1Pressure;
    }

    public void setTire1Pressure(double tire1Pressure) {
        this.tire1Pressure = tire1Pressure;
    }

    public int getTire1Age() {
        return tire1Age;
    }

    public void setTire1Age(int tire1Age) {
        this.tire1Age = tire1Age;
    }

    public double getTire2Pressure() {
        return tire2Pressure;
    }

    public void setTire2Pressure(double tire2Pressure) {
        this.tire2Pressure = tire2Pressure;
    }

    public int getTire2Age() {
        return tire2Age;
    }

    public void setTire2Age(int tire2Age) {
        this.tire2Age = tire2Age;
    }

    public double getTire3Pressure() {
        return tire3Pressure;
    }

    public void setTire3Pressure(double tire3Pressure) {
        this.tire3Pressure = tire3Pressure;
    }

    public int getTire3Age() {
        return tire3Age;
    }

    public void setTire3Age(int tire3Age) {
        this.tire3Age = tire3Age;
    }

    public double getTire4Pressure() {
        return tire4Pressure;
    }

    public void setTire4Pressure(double tire4Pressure) {
        this.tire4Pressure = tire4Pressure;
    }

    public int getTire4Age() {
        return tire4Age;
    }

    public void setTire4Age(int tire4Age) {
        this.tire4Age = tire4Age;
    }

    public Tire(double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age, double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age) {
        setTire1Pressure(tire1Pressure);
        setTire1Age(tire1Age);
        setTire2Pressure(tire2Pressure);
        setTire2Age(tire2Age);
        setTire3Pressure(tire3Pressure);
        setTire3Age(tire3Age);
        setTire4Pressure(tire4Pressure);
        setTire4Age(tire4Age);
    }

    public boolean hasPressureLessThan1() {
        return (tire1Pressure < 1) || (tire2Pressure < 1) || (tire3Pressure < 1) || (tire4Pressure < 1);
    }

}
