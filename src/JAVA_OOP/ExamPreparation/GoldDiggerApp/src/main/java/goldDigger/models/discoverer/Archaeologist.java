package goldDigger.models.discoverer;

public class Archaeologist extends BaseDiscoverer {

    private final static double INITIAL_UNITS_OF_ENERGY = 60;

    public Archaeologist(String name) {
        super(name, INITIAL_UNITS_OF_ENERGY);
    }

}
