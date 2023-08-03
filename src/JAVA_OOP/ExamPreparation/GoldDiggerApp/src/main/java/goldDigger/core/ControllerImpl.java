package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;

    private int discoverersExcluded;
    private int spotsInspected;

    public ControllerImpl() {
        this.setDiscovererRepository();
        this.setSpotRepository();
        this.setDiscoverersExcluded(0);
        this.setSpotsInspected(0);
    }

    public DiscovererRepository getDiscovererRepository() {
        return this.discovererRepository;
    }

    private void setDiscovererRepository() {
        this.discovererRepository = new DiscovererRepository();
    }

    public SpotRepository getSpotRepository() {
        return this.spotRepository;
    }

    private void setSpotRepository() {
        this.spotRepository = new SpotRepository();
    }

    public int getDiscoverersExcluded() {
        return this.discoverersExcluded;
    }

    public void setDiscoverersExcluded(int discoverersExcluded) {
        this.discoverersExcluded = discoverersExcluded;
    }

    public int getSpotsInspected() {
        return this.spotsInspected;
    }

    public void setSpotsInspected(int spotsInspected) {
        this.spotsInspected = spotsInspected;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;
        switch (kind) {
            case "Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            case "Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case "Geologist":
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
        }
        this.getDiscovererRepository().add(discoverer);
        return String.format(ConstantMessages.DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        this.getSpotRepository().add(new SpotImpl(spotName, exhibits));
        return String.format(ConstantMessages.SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = this.getDiscovererRepository().byName(discovererName);
        if (discoverer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST, discovererName));
        }
        this.getDiscovererRepository().remove(discoverer);
        return String.format(ConstantMessages.DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        Spot spotToInspect = this.getSpotRepository().byName(spotName);
        List<Discoverer> availableDiscoverers = this.getDiscovererRepository().getCollection().stream().filter(discoverer -> discoverer.getEnergy() > 45).collect(Collectors.toList());
        if (availableDiscoverers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        Operation operation = new OperationImpl();
        OperationImpl.discoverersExcludedCounter = 0;
        this.setDiscoverersExcluded(0);
        operation.startOperation(spotToInspect, availableDiscoverers);
        this.setSpotsInspected(this.getSpotsInspected() + 1);
        this.setDiscoverersExcluded(OperationImpl.discoverersExcludedCounter);
        return String.format(ConstantMessages.INSPECT_SPOT, spotName, this.getDiscoverersExcluded());
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append(String.format(ConstantMessages.FINAL_SPOT_INSPECT, this.getSpotsInspected())).append(System.lineSeparator());
        statistics.append(ConstantMessages.FINAL_DISCOVERER_INFO).append(System.lineSeparator());
        this.getDiscovererRepository().getCollection().forEach(statistics::append);
        return statistics.toString().trim();
    }
}
