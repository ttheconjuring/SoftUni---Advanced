package SetsAndMapsAdvancedExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] inputArray = scanner.nextLine().toCharArray();
        Map<Character, Integer> characterOccurrencesMap = new TreeMap<>();

        for (int i = 0; i < inputArray.length; i++) {
            characterOccurrencesMap.putIfAbsent(inputArray[i], 0);
            characterOccurrencesMap.put(inputArray[i], characterOccurrencesMap.get(inputArray[i]) + 1);
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : characterOccurrencesMap.entrySet()) {
            System.out.printf("%c: %d time/s%n", characterIntegerEntry.getKey(), characterIntegerEntry.getValue());
        }

        scanner.close();
    }

}
