package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PastryShop {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayDeque<Integer> liquidsQueue = Arrays.stream(bufferedReader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
            ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
            Arrays.stream(bufferedReader.readLine().split("\\s+")).map(Integer::parseInt).forEach(ingredientsStack::push);
            int biscuit = 0;
            int cake = 0;
            int pastry = 0;
            int pie = 0;
            while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
                int sum = liquidsQueue.peek() + ingredientsStack.peek();
                switch (sum) {
                    case 25:
                        biscuit++;
                        liquidsQueue.poll();
                        ingredientsStack.pop();
                        break;
                    case 50:
                        cake++;
                        liquidsQueue.poll();
                        ingredientsStack.pop();
                        break;
                    case 75:
                        pastry++;
                        liquidsQueue.poll();
                        ingredientsStack.pop();
                        break;
                    case 100:
                        pie++;
                        liquidsQueue.poll();
                        ingredientsStack.pop();
                        break;
                    default:
                        liquidsQueue.poll();
                        ingredientsStack.push(ingredientsStack.pop() + 3);
                }
            }
            if (biscuit > 0 && cake > 0 && pastry > 0 && pie > 0) {
                System.out.println("Great! You succeeded in cooking all the food!");
            } else {
                System.out.println("What a pity! You didn't have enough materials to cook everything.");
            }
            if (liquidsQueue.isEmpty()) {
                System.out.println("Liquids left: none");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Liquids left: ");
                while (!liquidsQueue.isEmpty()) {
                    sb.append(liquidsQueue.poll()).append(", ");
                }
                sb.deleteCharAt(sb.length() - 2);
                System.out.println(sb);
            }
            if (ingredientsStack.isEmpty()) {
                System.out.println("Ingredients left: none");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Ingredients left: ");
                while (!ingredientsStack.isEmpty()) {
                    sb.append(ingredientsStack.pop()).append(", ");
                }
                sb.deleteCharAt(sb.length() - 2);
                System.out.println(sb);
            }
            System.out.println("Biscuit: " + biscuit);
            System.out.println("Cake: " + cake);
            System.out.println("Pie: " + pie);
            System.out.println("Pastry: " + pastry);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
