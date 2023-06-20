package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class ItsChocolateTime {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayDeque<Double> milkQueue = new ArrayDeque<>();
            double[] milk = Arrays.stream(bufferedReader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            for (int i = 0; i < milk.length; i++) {
                milkQueue.offer(milk[i]);
            }
            ArrayDeque<Double> cacaoPowderStack = new ArrayDeque<>();
            double[] cacaoPowder = Arrays.stream(bufferedReader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            for (int i = 0; i < cacaoPowder.length; i++) {
                cacaoPowderStack.push(cacaoPowder[i]);
            }
            int milkChocolate = 0;
            int darkChocolate = 0;
            int bakingChocolate = 0;
            while (!milkQueue.isEmpty() && !cacaoPowderStack.isEmpty()) {
                double cacaoPercentage = (cacaoPowderStack.peek() / (milkQueue.peek() + cacaoPowderStack.peek())) * 100;
                if (cacaoPercentage == 30.00) {
                    milkChocolate++;
                    milkQueue.poll();
                    cacaoPowderStack.pop();
                } else if (cacaoPercentage == 50.00) {
                    darkChocolate++;
                    milkQueue.poll();
                    cacaoPowderStack.pop();
                } else if (cacaoPercentage == 100.00) {
                    bakingChocolate++;
                    milkQueue.poll();
                    cacaoPowderStack.pop();
                } else {
                    milkQueue.offer(milkQueue.poll() + 10);
                    cacaoPowderStack.pop();
                }
            }
            if (milkChocolate > 0 && darkChocolate > 0 && bakingChocolate > 0) {
                System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
            } else {
                System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
            }
            if (bakingChocolate > 0) {
                System.out.println("# Baking Chocolate --> " + bakingChocolate);
            }
            if (darkChocolate > 0) {
                System.out.println("# Dark Chocolate --> " + darkChocolate);
            }
            if (milkChocolate > 0) {
                System.out.println("# Milk Chocolate --> " + milkChocolate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
