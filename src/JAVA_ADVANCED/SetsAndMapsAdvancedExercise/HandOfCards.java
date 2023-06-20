package SetsAndMapsAdvancedExercise;

import java.util.*;

public class HandOfCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> playerDeckCardsMap = new LinkedHashMap<>();

        while (!input.equals("JOKER")){
            String[] inputArray = input.split(": ");
            String name = inputArray[0];
            playerDeckCardsMap.putIfAbsent(name, new HashSet<>());
            playerDeckCardsMap.get(name).addAll(List.of(inputArray[1].split(", ")));
            input = scanner.nextLine();
        }

        Map<String, Integer> powerPointsMap = new HashMap<>();
        powerPointsMap.put("2", 2);
        powerPointsMap.put("3", 3);
        powerPointsMap.put("4", 4);
        powerPointsMap.put("5", 5);
        powerPointsMap.put("6", 6);
        powerPointsMap.put("7", 7);
        powerPointsMap.put("8", 8);
        powerPointsMap.put("9", 9);
        powerPointsMap.put("10", 10);
        powerPointsMap.put("J", 11);
        powerPointsMap.put("Q", 12);
        powerPointsMap.put("K", 13);
        powerPointsMap.put("A", 14);

        Map<String, Integer> typesPointsMap = new HashMap<>();
        typesPointsMap.put("S", 4);
        typesPointsMap.put("H", 3);
        typesPointsMap.put("D", 2);
        typesPointsMap.put("C", 1);


        for (Map.Entry<String, Set<String>> stringSetEntry : playerDeckCardsMap.entrySet()) {
            int total = 0;
            for (String s : stringSetEntry.getValue()) {
                String power = s.substring(0, s.length() - 1);
                String type = s.substring(s.length() - 1);
                total += (powerPointsMap.get(power) * typesPointsMap.get(type));
            }
            System.out.println(stringSetEntry.getKey() + ": " + total);
        }

        scanner.close();
    }

}
