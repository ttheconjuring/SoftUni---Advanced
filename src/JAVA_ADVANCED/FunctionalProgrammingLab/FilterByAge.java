package FunctionalProgrammingLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class FilterByAge {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            Map<String, Integer> nameAgeMap = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                String[] inputArray = bufferedReader.readLine().split(", ");
                String name = inputArray[0];
                int age = Integer.parseInt(inputArray[1]);
                nameAgeMap.putIfAbsent(name, age);
            }
            String condition = bufferedReader.readLine();
            int age = Integer.parseInt(bufferedReader.readLine());
            String format = bufferedReader.readLine();
            switch (condition) {
                case "younger":
                    switch (format) {
                        case "name":
                            nameAgeMap.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() <= age).forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey()));
                            break;
                        case "age":
                            nameAgeMap.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() <= age).forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getValue()));
                            break;
                        case "name age":
                            nameAgeMap.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() <= age).forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue()));
                            break;
                    }
                    break;
                case "older":
                    switch (format) {
                        case "name":
                            nameAgeMap.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() >= age).forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey()));
                            break;
                        case "age":
                            nameAgeMap.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() >= age).forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getValue()));
                            break;
                        case "name age":
                            nameAgeMap.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() >= age).forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue()));
                            break;
                    }
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
