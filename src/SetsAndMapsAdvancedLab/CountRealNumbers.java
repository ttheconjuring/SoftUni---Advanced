package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] realNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        int n = realNumbers.length;

        Map<Double, Integer> realNumberOccurrencesMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            realNumberOccurrencesMap.putIfAbsent(realNumbers[i], 0);
            realNumberOccurrencesMap.put(realNumbers[i], realNumberOccurrencesMap.get(realNumbers[i]) + 1);
        }

        for (Map.Entry<Double, Integer> doubleIntegerEntry : realNumberOccurrencesMap.entrySet()) {
            System.out.printf("%.1f -> %d%n", doubleIntegerEntry.getKey(), doubleIntegerEntry.getValue());
        }

        scanner.close();
    }

}
