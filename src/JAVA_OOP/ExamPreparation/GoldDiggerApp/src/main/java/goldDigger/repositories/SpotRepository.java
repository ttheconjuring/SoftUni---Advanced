package goldDigger.repositories;

import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SpotRepository implements Repository<Spot> {

    private Collection<Spot> spots;

    public SpotRepository() {
        this.setSpots();
    }

    @Override
    public Collection<Spot> getCollection() {
        return Collections.unmodifiableCollection(this.spots);
    }

    private void setSpots() {
        this.spots = new ArrayList<>();
    }

    @Override
    public void add(Spot entity) {
        this.spots.add(entity);
    }

    @Override
    public boolean remove(Spot entity) {
        return this.spots.remove(entity);
    }

    @Override
    public Spot byName(String name) {
        return this.spots.stream().filter(spot -> spot.getName().equals(name)).findFirst().orElse(null);
    }
}
