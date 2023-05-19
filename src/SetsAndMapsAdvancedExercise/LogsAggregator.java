package SetsAndMapsAdvancedExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, Integer>> userIPdurationMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputArray = scanner.nextLine().split("\\s+");
            String IP = inputArray[0];
            String user = inputArray[1];
            int duration = Integer.parseInt(inputArray[2]);
            userIPdurationMap.putIfAbsent(user, new TreeMap<>());
            userIPdurationMap.get(user).putIfAbsent(IP, 0);
            userIPdurationMap.get(user).put(IP, userIPdurationMap.get(user).get(IP) + duration);
        }

        for (Map.Entry<String, Map<String, Integer>> stringMapEntry : userIPdurationMap.entrySet()) {
            StringBuilder output = new StringBuilder();
            output.append(stringMapEntry.getKey()).append(": ");
            int totalDuration = 0;
            for (Map.Entry<String, Integer> stringIntegerEntry : stringMapEntry.getValue().entrySet()) {
                totalDuration += stringIntegerEntry.getValue();
            }
            output.append(totalDuration).append(" [");
            for (Map.Entry<String, Integer> stringIntegerEntry : stringMapEntry.getValue().entrySet()) {
                output.append(stringIntegerEntry.getKey()).append(", ");
            }
            output.replace(output.length() - 2, output.length(), "]");
            System.out.println(output);
        }


        scanner.close();
    }

}
