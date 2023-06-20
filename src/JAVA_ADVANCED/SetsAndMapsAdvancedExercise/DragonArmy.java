package SetsAndMapsAdvancedExercise;

import java.util.*;

public class DragonArmy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<Integer>>> typeNameStatsMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] inputArray = scanner.nextLine().split("\\s+");
            String type = inputArray[0];
            String name = inputArray[1];
            int damage = 45;
            int health = 250;
            int armor = 10;
            if (!inputArray[2].equals("null")) {
                damage = Integer.parseInt(inputArray[2]);
            }
            if (!inputArray[3].equals("null")) {
                health = Integer.parseInt(inputArray[3]);
            }
            if (!inputArray[4].equals("null")) {
                armor = Integer.parseInt(inputArray[4]);
            }
            typeNameStatsMap.putIfAbsent(type, new TreeMap<>());
            if (typeNameStatsMap.get(type).containsKey(name)) {
                typeNameStatsMap.get(type).get(name).set(0, damage);
                typeNameStatsMap.get(type).get(name).set(1, health);
                typeNameStatsMap.get(type).get(name).set(2, armor);
            } else {
                typeNameStatsMap.get(type).put(name, new ArrayList<>());
                typeNameStatsMap.get(type).get(name).add(damage);
                typeNameStatsMap.get(type).get(name).add(health);
                typeNameStatsMap.get(type).get(name).add(armor);
            }
        }

        for (Map.Entry<String, Map<String, List<Integer>>> stringMapEntry : typeNameStatsMap.entrySet()) {
            double totalDamage = 0;
            double totalHealth = 0;
            double totalArmor = 0;
            for (Map.Entry<String, List<Integer>> stringListEntry : stringMapEntry.getValue().entrySet()) {
                totalDamage += stringListEntry.getValue().get(0);
                totalHealth += stringListEntry.getValue().get(1);
                totalArmor += stringListEntry.getValue().get(2);
            }
            double averageDamage = totalDamage / stringMapEntry.getValue().size();
            double averageHealth = totalHealth / stringMapEntry.getValue().size();
            double averageArmor = totalArmor / stringMapEntry.getValue().size();
            StringBuilder output = new StringBuilder();
            output.append(stringMapEntry.getKey()).append("::(").append(String.format("%.2f", averageDamage)).append("/").append(String.format("%.2f", averageHealth)).append("/").append(String.format("%.2f", averageArmor)).append(")");
            System.out.println(output);
            for (Map.Entry<String, List<Integer>> stringListEntry : stringMapEntry.getValue().entrySet()) {
                output = new StringBuilder();
                output.append("-").append(stringListEntry.getKey()).append(" -> damage: ").append(stringListEntry.getValue().get(0)).append(", health: ").append(stringListEntry.getValue().get(1)).append(", armor: ").append(stringListEntry.getValue().get(2));
                System.out.println(output);
            }
        }

        scanner.close();
    }

}
