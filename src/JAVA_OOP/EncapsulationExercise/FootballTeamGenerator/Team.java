package JAVA_OOP.EncapsulationExercise.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

    private String name;
    private final List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.length() == 0 || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        Player player = this.players.stream().filter(player1 -> player1.getName().equals(name)).findFirst().orElse(null);
        if (player == null) {
            throw new IllegalArgumentException("Player " + name + " is not in " + this.getName() + " team.");
        }
        this.players.remove(player);
    }

    public double getRating() {
        return this.players.stream().mapToDouble(Player::overallSkillLevel).sum() / this.players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

}
