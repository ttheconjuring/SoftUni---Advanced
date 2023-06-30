package JAVA_OOP.InheritanceExercise.Animals;

public class Kitten extends Cat {

    private final static String KITTEN_GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, KITTEN_GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }

}
