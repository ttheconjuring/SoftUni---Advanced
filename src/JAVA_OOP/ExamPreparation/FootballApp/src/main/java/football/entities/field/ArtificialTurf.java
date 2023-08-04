package football.entities.field;

public class ArtificialTurf extends BaseField {

    private final static int DEFAULT_CAPACITY = 150;

    public ArtificialTurf(String name) {
        super(name, DEFAULT_CAPACITY);
    }
}
