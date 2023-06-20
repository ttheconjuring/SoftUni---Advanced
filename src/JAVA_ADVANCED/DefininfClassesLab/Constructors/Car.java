package DefininfClassesLab.Constructors;

public class Car {

    private String brand;

    private String model;

    private int horsePower;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void carInfo() {
        System.out.println("The car is: " + this.getBrand() + " " + this.getModel() + " - " + this.getHorsePower() + " HP.");
    }

    public Car(String brand) {
        this.setBrand(brand);
        setModel("unknown");
        setHorsePower(-1);
    }

    public Car(String brand, String model, int horsePower) {
        this(brand);
        setModel(model);
        setHorsePower(horsePower);
    }

}
