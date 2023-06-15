package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Blacksmith {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
            int[] steel = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < steel.length; i++) {
                steelQueue.offer(steel[i]);
            }
            ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
            int[] carbon = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < carbon.length; i++) {
                carbonStack.push(carbon[i]);
            }
            int gladius = 0;
            int shamshir = 0;
            int katana = 0;
            int sabre = 0;
            int swords = 0;
            while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
                int sum = steelQueue.peek() + carbonStack.peek();
                switch (sum) {
                    case 70:
                        gladius++;
                        swords++;
                        steelQueue.poll();
                        carbonStack.pop();
                        break;
                    case 80:
                        shamshir++;
                        swords++;
                        steelQueue.poll();
                        carbonStack.pop();
                        break;
                    case 90:
                        katana++;
                        swords++;
                        steelQueue.poll();
                        carbonStack.pop();
                        break;
                    case 110:
                        sabre++;
                        swords++;
                        steelQueue.poll();
                        carbonStack.pop();
                        break;
                    default:
                        steelQueue.poll();
                        carbonStack.push(carbonStack.pop() + 5);
                }
            }
            if (swords > 0) {
                System.out.println("You have forged " + swords + " swords.");
            } else {
                System.out.println("You did not have enough resources to forge a sword.");
            }
            if (steelQueue.isEmpty()) {
                System.out.println("Steel left: none");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Steel left: ");
                while (!steelQueue.isEmpty()) {
                    sb.append(steelQueue.poll()).append(", ");
                }
                sb.deleteCharAt(sb.length() - 2);
                System.out.println(sb);
            }
            if (carbonStack.isEmpty()) {
                System.out.println("Carbon left: none");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Carbon left: ");
                while (!carbonStack.isEmpty()) {
                    sb.append(carbonStack.pop()).append(", ");
                }
                sb.deleteCharAt(sb.length() - 2);
                System.out.println(sb);
            }
            if (gladius > 0) {
                System.out.println("Gladius: " + gladius);
            }
            if (katana > 0) {
                System.out.println("Katana: " + katana);
            }
            if (sabre > 0) {
                System.out.println("Sabre: " + sabre);
            }
            if (shamshir > 0) {
                System.out.println("Shamshir: " + shamshir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
