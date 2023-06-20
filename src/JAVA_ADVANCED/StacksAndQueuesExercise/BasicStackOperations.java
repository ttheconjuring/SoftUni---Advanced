package StacksAndQueuesExercise;

import java.util.*;

public class BasicStackOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nsx = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int n = nsx[0];
        int s = nsx[1];
        int x = nsx[2];

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) {
            numbersStack.push(numbers[i]);
        }

        for (int i = 0; i < s; i++) {
            numbersStack.pop();
        }

        boolean isPresent = numbersStack.contains(x);

        if (numbersStack.isEmpty()) {
            System.out.println("0");
        } else if (isPresent) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(numbersStack));
        }

        scanner.close();
    }

}
