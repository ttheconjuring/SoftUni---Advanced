package DefiningClassesExercise.PokemonTrainer;

public class Pokemon {

    private String name;
    private String element;
    private int health;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Pokemon(){}

    public Pokemon(String name, String element, int health) {
        setName(name);
        setElement(element);
        setHealth(health);
    }
}
