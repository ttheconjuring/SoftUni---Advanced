package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class OperationImpl implements Operation {

    public static int discoverersExcludedCounter;

    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        List<Discoverer> availableDiscoverers = discoverers.stream().filter(Discoverer::canDig).collect(Collectors.toList());
        List<String> exhibits = new ArrayList<>(spot.getExhibits());
        while (!availableDiscoverers.isEmpty() && !exhibits.isEmpty()) {
            if (availableDiscoverers.get(0).canDig()) {
                availableDiscoverers.get(0).dig();
                availableDiscoverers.get(0).getMuseum().getExhibits().add(exhibits.get(0));
                exhibits.remove(0);
            } else {
                availableDiscoverers.remove(0);
                discoverersExcludedCounter++;
            }
        }
    }
}
