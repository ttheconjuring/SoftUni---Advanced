package StacksAndQueuesExercise;

import java.util.*;
import java.util.stream.Collectors;

public class PoisonousPlants {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ============== Solution 1 (mine) ==============

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> inputList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int dayCounter = 0;
        List<Integer> theDayBeforeList = new ArrayList<>(inputList);

        while (true) {
            for (int i = inputList.size() - 1; i >= 1; i--) {
                if (inputList.get(i - 1) < inputList.get(i)) {
                    inputList.remove(i);
                }
            }
            if (theDayBeforeList.equals(inputList)) {
                break;
            } else {
                dayCounter++;
                theDayBeforeList = new ArrayList<>(inputList);
            }
        }

        System.out.println(dayCounter);

        // ============== Solution 2 (rework from Borovaneca, not mine) ==============

        /* int[] inputArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> firstStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            firstStack.push(inputArray[i]);
        }

        ArrayDeque<Integer> secondStack = new ArrayDeque<>();

        int dayCounter = 0;

        while (true) {
            int beforeFirstStackSize = firstStack.size();
            while (!firstStack.isEmpty()) {
                int pop = firstStack.pop();
                if (firstStack.size() >= 1) {
                    int peek = firstStack.peek();
                    if (!(pop > peek)) {
                        secondStack.push(pop);
                    }
                } else {
                    secondStack.push(pop);
                }
            }

            int afterFirstStackSize = secondStack.size();

            if (beforeFirstStackSize == afterFirstStackSize) {
                break;
            } else {
                while (!secondStack.isEmpty()) {
                    firstStack.push(secondStack.pop());
                }
                dayCounter++;
            }
        }

        System.out.println(dayCounter); */

        scanner.close();
    }
}



