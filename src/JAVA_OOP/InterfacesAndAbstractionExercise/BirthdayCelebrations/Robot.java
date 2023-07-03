package JAVA_OOP.InterfacesAndAbstractionExercise.BirthdayCelebrations;

public class Robot implements Identifiable {

    private final String id;
    private final String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }

}
