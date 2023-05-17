package SetsAndMapsAdvancedLab;

import java.util.*;

public class CitiesByContinentAndCountry {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> continentCountryCityListMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputArray = scanner.nextLine().split("\\s+");
            String continent = inputArray[0];
            continentCountryCityListMap.putIfAbsent(continent, new LinkedHashMap<>());
            String country = inputArray[1];
            String city = inputArray[2];
            continentCountryCityListMap.get(continent).putIfAbsent(country, new ArrayList<>());
            continentCountryCityListMap.get(continent).get(country).add(city);
        }

        for (Map.Entry<String, Map<String, List<String>>> stringMapEntry : continentCountryCityListMap.entrySet()) {
            System.out.println(stringMapEntry.getKey() + ":");
            for (Map.Entry<String, List<String>> stringListEntry : stringMapEntry.getValue().entrySet()) {
                System.out.print("  " + stringListEntry.getKey() + " -> ");
                System.out.print(String.join(", ", stringListEntry.getValue()));
                System.out.println();
            }
        }

        scanner.close();
    }

}
