package goldDigger.models.discoverer;

public class Anthropologist extends BaseDiscoverer {

    private final static double INITIAL_UNITS_OF_ENERGY = 40;

    public Anthropologist(String name) {
        super(name, INITIAL_UNITS_OF_ENERGY);
    }

}
