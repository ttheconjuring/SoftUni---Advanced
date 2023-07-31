package robotService.entities.services;

public class MainService extends BaseService {

    private final static int DEFAULT_CAPACITY = 30;

    public MainService(String name) {
        super(name, DEFAULT_CAPACITY);
    }
}
