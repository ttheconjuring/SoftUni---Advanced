package football.entities.player;

public class Men extends BasePlayer {

    private final static double DEFAULT_KILOGRAMS = 85.50;
    private final static int DEFAULT_STRENGTH_INCREASING_VALUE = 145;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, DEFAULT_KILOGRAMS, strength);
    }

    @Override
    public void stimulation() {
        this.setStrength(this.getStrength() + DEFAULT_STRENGTH_INCREASING_VALUE);
    }
}
