package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ApocalypsePreparation {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayDeque<Integer> textilesQueue = new ArrayDeque<>();
            int[] textiles = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < textiles.length; i++) {
                textilesQueue.offer(textiles[i]);
            }
            ArrayDeque<Integer> medicamentsStack = new ArrayDeque<>();
            int[] medicaments = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < medicaments.length; i++) {
                medicamentsStack.push(medicaments[i]);
            }
            int patch = 0;
            int bandage = 0;
            int medKit = 0;
            while (!textilesQueue.isEmpty() && !medicamentsStack.isEmpty()) {
                int sum = textilesQueue.peek() + medicamentsStack.peek();
                switch (sum) {
                    case 30:
                        patch++;
                        textilesQueue.poll();
                        medicamentsStack.pop();
                        break;
                    case 40:
                        bandage++;
                        textilesQueue.poll();
                        medicamentsStack.pop();
                        break;
                    case 100:
                        medKit++;
                        textilesQueue.poll();
                        medicamentsStack.pop();
                        break;
                    default:
                        if (sum > 100) {
                            medKit++;
                            textilesQueue.poll();
                            medicamentsStack.pop();
                            int remainingResources = sum - 100;
                            medicamentsStack.push(medicamentsStack.pop() + remainingResources);
                        } else {
                            textilesQueue.poll();
                            medicamentsStack.push(medicamentsStack.pop() + 10);
                        }
                }
            }
            if (textilesQueue.isEmpty() && medicamentsStack.isEmpty()) {
                System.out.println("Textiles and medicaments are both empty.");
            } else if (textilesQueue.isEmpty()) {
                System.out.println("Textiles are empty.");
            } else {
                System.out.println("Medicaments are empty.");
            }
            Map<String, Integer> itemNameAmountMap = new HashMap<>();
            itemNameAmountMap.put("Patch", patch);
            itemNameAmountMap.put("Bandage", bandage);
            itemNameAmountMap.put("MedKit", medKit);
            itemNameAmountMap.entrySet().removeIf(entry -> entry.getValue() == 0);
            if (!itemNameAmountMap.isEmpty()) {
                itemNameAmountMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey())).forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
            }
            if (!medicamentsStack.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Medicaments left: ");
                while (!medicamentsStack.isEmpty()) {
                    sb.append(medicamentsStack.pop()).append(", ");
                }
                sb.deleteCharAt(sb.length() - 2);
                System.out.println(sb);
            }
            if (!textilesQueue.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Textiles left: ");
                while (!textilesQueue.isEmpty()) {
                    sb.append(textilesQueue.poll()).append(", ");
                }
                sb.deleteCharAt(sb.length() - 2);
                System.out.println(sb);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
