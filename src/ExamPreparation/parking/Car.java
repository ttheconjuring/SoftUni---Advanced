package ExamPreparation.parking;

public class Car {

    private String manufacturer;
    private String model;
    private int year;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Car(String manufacturer, String model, int year) {
        setManufacturer(manufacturer);
        setModel(model);
        setYear(year);
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", getManufacturer(), getModel(), getYear());
    }

}
