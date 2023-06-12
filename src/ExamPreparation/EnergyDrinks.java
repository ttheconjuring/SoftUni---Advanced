package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class EnergyDrinks {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayDeque<Integer> miligramsOfCaffeineStack = new ArrayDeque<>();
            int[] miligramsOfCaffein = Arrays.stream(bufferedReader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < miligramsOfCaffein.length; i++) {
                miligramsOfCaffeineStack.push(miligramsOfCaffein[i]);
            }
            ArrayDeque<Integer> energyDrinksQueue = new ArrayDeque<>();
            int[] energyDrinks = Arrays.stream(bufferedReader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < energyDrinks.length; i++) {
                energyDrinksQueue.offer(energyDrinks[i]);
            }
            int totalCaffeine = 0;
            while (!miligramsOfCaffeineStack.isEmpty() && !energyDrinksQueue.isEmpty()) {
                int product = miligramsOfCaffeineStack.peek() * energyDrinksQueue.peek();
                if (totalCaffeine + product <= 300) {
                    miligramsOfCaffeineStack.pop();
                    energyDrinksQueue.poll();
                    totalCaffeine += product;
                } else {
                    miligramsOfCaffeineStack.pop();
                    energyDrinksQueue.offer(energyDrinksQueue.poll());
                    totalCaffeine -= 30;
                    if (totalCaffeine < 0) {
                        totalCaffeine = 0;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            if (!energyDrinksQueue.isEmpty()) {
                sb.append("Drinks left: ");
                while (!energyDrinksQueue.isEmpty()) {
                    sb.append(energyDrinksQueue.poll()).append(", ");
                }
                sb.deleteCharAt(sb.length() - 2);
                sb.append(System.lineSeparator());
            } else {
                System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
            }
            sb.append(String.format("Stamat is going to sleep with %d mg caffeine.", totalCaffeine));
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
