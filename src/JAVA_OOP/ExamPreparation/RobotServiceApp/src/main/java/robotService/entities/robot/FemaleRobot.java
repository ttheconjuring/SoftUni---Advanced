package robotService.entities.robot;

public class FemaleRobot extends BaseRobot {

    private final static int DEFAULT_KILOGRAMS = 7;

    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, DEFAULT_KILOGRAMS, price);
    }

    @Override
    public void eating() {
        this.setKilograms(this.getKilograms() + 1);
    }
}
