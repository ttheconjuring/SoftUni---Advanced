package robotService.entities.robot;

public class MaleRobot extends BaseRobot {

    private final static int DEFAULT_KILOGRAMS = 9;

    public MaleRobot(String name, String kind, double price) {
        super(name, kind, DEFAULT_KILOGRAMS, price);
    }

    @Override
    public void eating() {
        this.setKilograms(this.getKilograms() + 3);
    }
}
