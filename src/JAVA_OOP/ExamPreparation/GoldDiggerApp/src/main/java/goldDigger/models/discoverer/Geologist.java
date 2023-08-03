package goldDigger.models.discoverer;

public class Geologist extends BaseDiscoverer {

    private final static double INITIAL_UNITS_OF_ENERGY = 100;

    public Geologist(String name) {
        super(name, INITIAL_UNITS_OF_ENERGY);
    }

}
