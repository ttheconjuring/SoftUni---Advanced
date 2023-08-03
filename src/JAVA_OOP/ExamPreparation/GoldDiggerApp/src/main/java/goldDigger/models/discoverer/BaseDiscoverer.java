package goldDigger.models.discoverer;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

public abstract class BaseDiscoverer implements Discoverer {

    private String name;
    private double energy;
    private Museum museum;

    protected BaseDiscoverer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.setMuseum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    private void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public boolean canDig() {
        return this.getEnergy() > 0;
    }

    @Override
    public Museum getMuseum() {
        return this.museum;
    }

    private void setMuseum() {
        this.museum = new BaseMuseum();
    }

    @Override
    public void dig() {
        if (this.getEnergy() - 15 >= 0) {
            this.setEnergy(this.getEnergy() - 15);
        } else {
            this.setEnergy(0);
        }
    }

    @Override
    public String toString() {
        return String.format(ConstantMessages.FINAL_DISCOVERER_NAME, this.getName()) + System.lineSeparator() +
                String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY, this.getEnergy()) + System.lineSeparator() +
                String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS, !this.getMuseum().getExhibits().isEmpty() ? String.join(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, this.getMuseum().getExhibits()) : "None") + System.lineSeparator();
    }

}
