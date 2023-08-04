package football.entities.field;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseField implements Field {

    private String name;
    private int capacity;
    private final Collection<Supplement> supplements;
    private final Collection<Player> players;

    protected BaseField(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    @Override
    public int sumEnergy() {
        return this.getSupplements().stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (this.getPlayers().size() < this.getCapacity()) {
            this.getPlayers().add(player);
        } else {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removePlayer(Player player) {
        this.getPlayers().remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.getSupplements().add(supplement);
    }

    @Override
    public void drag() {
        this.getPlayers().forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {
        return String.format("%s (%s):", this.getName(), this.getClass().getSimpleName()) + System.lineSeparator() +
                String.format("Player: %s", !this.getPlayers().isEmpty() ? this.getPlayers().stream().map(Player::getName).collect(Collectors.joining(" ")) : "none") + System.lineSeparator() +
                String.format("Supplement: %d", this.getSupplements().size()) + System.lineSeparator() +
                String.format("Energy: %d", this.sumEnergy()) + System.lineSeparator();
    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private int getCapacity() {
        return this.capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
