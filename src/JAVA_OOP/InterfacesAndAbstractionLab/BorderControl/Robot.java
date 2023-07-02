package JAVA_OOP.InterfacesAndAbstractionLab.BorderControl;

public class Robot implements Identifiable {

    private final String id;
    private final String model;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }

}
