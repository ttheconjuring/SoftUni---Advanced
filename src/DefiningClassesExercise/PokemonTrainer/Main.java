package DefiningClassesExercise.PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            Map<Trainer, List<Pokemon>> trainerPokemonListMap = new LinkedHashMap<>();
            String command = bufferedReader.readLine();
            while (!command.equals("Tournament")) {
                String[] inputArray = command.split(" ");
                String trainerName = inputArray[0];
                String pokemonName = inputArray[1];
                String pokemonElement = inputArray[2];
                int pokemonHealth = Integer.parseInt(inputArray[3]);
                Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
                boolean trainerExists = false;
                for (Trainer trainer : trainerPokemonListMap.keySet()) {
                    if (trainer.getName().equals(trainerName)) {
                        trainerExists = true;
                        trainerPokemonListMap.get(trainer).add(pokemon);
                        break;
                    }
                }
                if (!trainerExists) {
                    Trainer trainer = new Trainer(trainerName);
                    trainerPokemonListMap.put(trainer, new ArrayList<>());
                    trainerPokemonListMap.get(trainer).add(pokemon);
                }
                command = bufferedReader.readLine();
            }
            command = bufferedReader.readLine();
            while (!command.equals("End")) {
                for (Map.Entry<Trainer, List<Pokemon>> trainerListEntry : trainerPokemonListMap.entrySet()) {
                    boolean pokemonFound = false;
                    for (Pokemon pokemon : trainerListEntry.getValue()) {
                        if (pokemon.getElement().equals(command)) {
                            pokemonFound = true;
                            break;
                        }
                    }
                    if (pokemonFound) {
                        trainerListEntry.getKey().setNumberOfBadges(trainerListEntry.getKey().getNumberOfBadges() + 1);
                    } else {
                        for (Pokemon pokemon : trainerListEntry.getValue()) {
                            pokemon.setHealth(pokemon.getHealth() - 10);
                        }
                        trainerListEntry.getValue().removeIf(pokemon -> pokemon.getHealth() <= 0);
                    }
                }
                command = bufferedReader.readLine();
            }
            // Sort the map by the trainer's name
            List<Map.Entry<Trainer, List<Pokemon>>> entries = new ArrayList<>(trainerPokemonListMap.entrySet());
            entries.sort((entry1, entry2) -> Integer.compare(entry2.getKey().getNumberOfBadges(), entry1.getKey().getNumberOfBadges()));
            // Create a new LinkedHashMap to store the sorted entries
            /*Map<Trainer, List<Pokemon>> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<Trainer, List<Pokemon>> entry : entries) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }*/
            for (Map.Entry<Trainer, List<Pokemon>> trainerListEntry : entries) {
                System.out.println(trainerListEntry.getKey().getName() + " " + trainerListEntry.getKey().getNumberOfBadges() + " " + trainerListEntry.getValue().size());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
