package DefiningClassesExercise.PokemonTrainer;

public class Trainer {

    private String name;
    private int numberOfBadges;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public Trainer() {}

    public Trainer(String name) {
        setName(name);
        setNumberOfBadges(0);
    }

}
