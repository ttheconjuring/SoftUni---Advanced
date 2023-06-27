package JAVA_OOP.EncapsulationExercise.FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String teamName;
            String playerName;
            Team team;
            Team teamFound;
            List<Team> teamList = new ArrayList<>();
            String command = bufferedReader.readLine();
            while (!command.equals("END")) {
                String[] commandArray = command.split(";");
                switch (commandArray[0]) {
                    case "Team":
                        teamName = commandArray[1];
                        team = new Team(teamName);
                        teamList.add(team);
                        break;
                    case "Add":
                        teamName = commandArray[1];
                        teamFound = findTeamWithName(teamName, teamList);
                        if (teamFound == null) {
                            // throw new IllegalArgumentException("Team " + teamName + " does not exist.");
                            System.out.println("Team " + teamName + " does not exist.");
                        } else {
                            playerName = commandArray[2];
                            int endurance = Integer.parseInt(commandArray[3]);
                            int sprint = Integer.parseInt(commandArray[4]);
                            int dribble = Integer.parseInt(commandArray[5]);
                            int passing = Integer.parseInt(commandArray[6]);
                            int shooting = Integer.parseInt(commandArray[7]);
                            try {
                                Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                                teamFound.addPlayer(player);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case "Remove":
                        teamName = commandArray[1];
                        teamFound = findTeamWithName(teamName, teamList);
                        if (teamFound == null) {
                            // throw new IllegalArgumentException("Team " + teamName + "does not exist.");
                            System.out.println("Team " + teamName + " does not exist.");
                        } else {
                            playerName = commandArray[2];
                            try {
                                teamFound.removePlayer(playerName);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case "Rating":
                        teamName = commandArray[1];
                        teamFound = findTeamWithName(teamName, teamList);
                        if (teamFound == null) {
                            // throw new IllegalArgumentException("Team " + teamName + "does not exist.");
                            System.out.println("Team " + teamName + " does not exist.");
                        } else {
                            System.out.println(teamName + " - " + Math.round(teamFound.getRating()));
                        }
                        break;
                }
                command = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Team findTeamWithName(String name, List<Team> teamList) {
        return teamList.stream().filter(team1 -> team1.getName().equals(name)).findFirst().orElse(null);
    }

}
