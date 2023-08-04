package football.repositories;

import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;

public class SupplementRepositoryImpl implements SupplementRepository {

    private final Collection<Supplement> supplements;

    public SupplementRepositoryImpl() {
        this.supplements = new ArrayList<>();
    }

    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public void add(Supplement supplement) {
        this.getSupplements().add(supplement);
    }

    @Override
    public boolean remove(Supplement supplement) {
        return this.getSupplements().remove(supplement);
    }

    @Override
    public Supplement findByType(String type) {
        return this.getSupplements().stream().filter(supplement -> supplement.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
