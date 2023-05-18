package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> userIpMessagesCountMap = new TreeMap<>();

        while (!input.equals("end")) {
            String[] inputArray = input.split(" ");
            String IP = inputArray[0].substring(inputArray[0].indexOf('=') + 1);
            // String message = inputArray[1].substring(inputArray[1].indexOf('=') + 1);
            String user = inputArray[2].substring(inputArray[2].indexOf('=') + 1);
            userIpMessagesCountMap.putIfAbsent(user, new LinkedHashMap<>());
            userIpMessagesCountMap.get(user).putIfAbsent(IP, 0);
            userIpMessagesCountMap.get(user).put(IP, userIpMessagesCountMap.get(user).get(IP) + 1);
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> stringMapEntry : userIpMessagesCountMap.entrySet()) {
            System.out.println(stringMapEntry.getKey() + ":");
            StringBuilder message = new StringBuilder();
            for (Map.Entry<String, Integer> stringIntegerEntry : stringMapEntry.getValue().entrySet()) {
                message.append(stringIntegerEntry.getKey()).append(" => ").append(stringIntegerEntry.getValue()).append(", ");
            }
            message.replace(message.length() - 2, message.length(), ".");
            System.out.println(message);
        }

        scanner.close();
    }

}
