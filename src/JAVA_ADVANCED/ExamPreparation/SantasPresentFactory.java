package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class SantasPresentFactory {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
            int[] materials = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < materials.length; i++) {
                materialsStack.push(materials[i]);
            }
            ArrayDeque<Integer> magicQueue = new ArrayDeque<>();
            int[] magics = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < magics.length; i++) {
                magicQueue.offer(magics[i]);
            }
            int doll = 0;
            int woodenTrain = 0;
            int teddyBear = 0;
            int bicycle = 0;
            boolean taskDone = false;
            while (!magicQueue.isEmpty() && !materialsStack.isEmpty()) {
                if (magicQueue.peek() == 0 && materialsStack.peek() == 0) {
                    magicQueue.poll();
                    materialsStack.pop();
                } else if (magicQueue.peek() == 0) {
                    magicQueue.poll();
                } else if (materialsStack.peek() == 0) {
                    materialsStack.pop();
                }
                if (magicQueue.isEmpty()) {
                    break;
                }
                if (materialsStack.isEmpty()) {
                    break;
                }
                int magic = magicQueue.poll();
                int material = materialsStack.pop();
                int totalMagicLevel = magic * material;
                switch (totalMagicLevel) {
                    case 150:
                        doll++;
                        break;
                    case 250:
                        woodenTrain++;
                        break;
                    case 300:
                        teddyBear++;
                        break;
                    case 400:
                        bicycle++;
                        break;
                    default:
                        if (totalMagicLevel < 0) {
                            materialsStack.push(magic + material);
                        } else if (totalMagicLevel > 0) {
                            materialsStack.push(material + 15);
                        }
                }
                if ((doll >= 1 && woodenTrain >= 1) || (teddyBear >= 1 && bicycle >= 1)) {
                    taskDone = true;
                }
            }
            if (taskDone) {
                System.out.println("The presents are crafted! Merry Christmas!");
            } else {
                System.out.println("No presents this Christmas!");
            }
            if (!materialsStack.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                while (!materialsStack.isEmpty()) {
                    sb.append(materialsStack.pop()).append(", ");
                }
                sb.deleteCharAt(sb.length() - 2);
                System.out.printf("Materials left: %s%n", sb);
            }
            if (!magicQueue.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                while (!magicQueue.isEmpty()) {
                   sb.append(magicQueue.poll()).append(", ");
                }
                sb.deleteCharAt(sb.length() - 2);
                System.out.printf("Magic left: %s%n", sb);
            }
            if(bicycle > 0) {
                System.out.println("Bicycle: " + bicycle);
            }
            if(doll > 0) {
                System.out.println("Doll: " + doll);
            }
            if(teddyBear > 0) {
                System.out.println("Teddy bear: " + teddyBear);
            }
            if(woodenTrain > 0) {
                System.out.println("Wooden train: " + woodenTrain);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
