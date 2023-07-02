package JAVA_OOP.InterfacesAndAbstractionLab.BorderControl;

public class Citizen implements Identifiable {

    private final String name;
    private final int age;
    private final String id;

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String getId() {
        return this.id;
    }

}
