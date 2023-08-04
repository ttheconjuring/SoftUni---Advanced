package football.entities.player;

public class Women extends BasePlayer {

    private final static double DEFAULT_KILOGRAMS = 60;
    private final static int DEFAULT_STRENGTH_INCREASING_VALUE = 115;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, DEFAULT_KILOGRAMS, strength);
    }

    @Override
    public void stimulation() {
        this.setStrength(this.getStrength() + DEFAULT_STRENGTH_INCREASING_VALUE);
    }
}
