package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class AutumnCocktails {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
            int[] ingredients = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < ingredients.length; i++) {
                ingredientsQueue.offer(ingredients[i]);
            }
            ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
            int[] freshness = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < freshness.length; i++) {
                freshnessStack.push(freshness[i]);
            }
            int pearSour = 0;
            int theHarvest = 0;
            int appleHinny = 0;
            int highFashion = 0;
            boolean done = false;
            while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
                if (ingredientsQueue.peek() == 0) {
                    ingredientsQueue.pop();
                    continue;
                }
                int product = ingredientsQueue.peek() * freshnessStack.peek();
                switch (product) {
                    case 150:
                        pearSour++;
                        ingredientsQueue.poll();
                        freshnessStack.pop();
                        break;
                    case 250:
                        theHarvest++;
                        ingredientsQueue.poll();
                        freshnessStack.pop();
                        break;
                    case 300:
                        appleHinny++;
                        ingredientsQueue.poll();
                        freshnessStack.pop();
                        break;
                    case 400:
                        highFashion++;
                        ingredientsQueue.poll();
                        freshnessStack.pop();
                        break;
                    default:
                        ingredientsQueue.offer(ingredientsQueue.poll() + 5);
                        freshnessStack.pop();
                }
                if (pearSour > 0) {
                    if (theHarvest > 0) {
                        if (appleHinny > 0) {
                            if (highFashion > 0) {
                                done = true;
                            }
                        }
                    }
                }
            }
            if (done) {
                System.out.println("It's party time! The cocktails are ready!");
            } else {
                System.out.println("What a pity! You didn't manage to prepare all cocktails.");
            }
            if (!ingredientsQueue.isEmpty()) {
                int sum = 0;
                while (!ingredientsQueue.isEmpty()) {
                    sum += ingredientsQueue.poll();
                }
                System.out.println("Ingredients left: " + sum);
            }
            if(appleHinny > 0) {
                System.out.println("# Apple Hinny --> " + appleHinny);
            }
            if(highFashion > 0) {
                System.out.println("# High Fashion --> " + highFashion);
            }
            if(pearSour > 0) {
                System.out.println("# Pear Sour --> " + pearSour);
            }
            if(theHarvest > 0) {
                System.out.println("# The Harvest --> " + theHarvest);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
