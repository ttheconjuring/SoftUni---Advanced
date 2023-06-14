package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FoodFinder {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayDeque<Character> vowelsQueue = new ArrayDeque<>();
            char[] vowels = bufferedReader.readLine().replace(" ", "").toCharArray();
            for (int i = 0; i < vowels.length; i++) {
                vowelsQueue.offer(vowels[i]);
            }
            ArrayDeque<Character> consonantsStack = new ArrayDeque<>();
            char[] consonants = bufferedReader.readLine().replace(" ", "").toCharArray();
            for (int i = 0; i < consonants.length; i++) {
                consonantsStack.push(consonants[i]);
            }
            Set<Character> lettersSet = new HashSet<>(List.of('p', 'e', 'a', 'r', 'f', 'l', 'o', 'u', 'k', 'i', 'v'));
            Set<Character> foundLettersSet = new HashSet<>();
            while (!consonantsStack.isEmpty()) {
                if (lettersSet.contains(vowelsQueue.peek())) {
                    foundLettersSet.add(vowelsQueue.peek());
                }
                vowelsQueue.offer(vowelsQueue.poll());
                if (lettersSet.contains(consonantsStack.peek())) {
                    foundLettersSet.add(consonantsStack.peek());
                }
                consonantsStack.pop();
            }
            int wordCounter = 0;
            boolean pearFound = false;
            boolean flourFound = false;
            boolean porkFound = false;
            boolean oliveFound = false;
            if (foundLettersSet.containsAll(List.of('p', 'e', 'a', 'r'))) {
                wordCounter++;
                pearFound = true;
            }
            if (foundLettersSet.containsAll(List.of('f', 'l', 'o', 'u', 'r'))) {
                wordCounter++;
                flourFound = true;
            }
            if (foundLettersSet.containsAll(List.of('p', 'o', 'r', 'k'))) {
                wordCounter++;
                porkFound = true;
            }
            if (foundLettersSet.containsAll(List.of('o', 'l', 'i', 'v', 'e'))) {
                wordCounter++;
                oliveFound = true;
            }
            System.out.println("Words found: " + wordCounter);
            if (pearFound) {
                System.out.println("pear");
            }
            if (flourFound) {
                System.out.println("flour");
            }
            if (porkFound) {
                System.out.println("pork");
            }
            if (oliveFound) {
                System.out.println("olive");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
