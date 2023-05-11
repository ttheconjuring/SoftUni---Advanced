package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nsx = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int n = nsx[0];
        int s = nsx[1];
        int x = nsx[2];

        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            numbersQueue.offer(numbers[i]);
        }

        for (int i = 0; i < s; i++) {
            numbersQueue.poll();
        }

        boolean isPresent = numbersQueue.contains(x);

        if(numbersQueue.isEmpty()) {
            System.out.println("0");
        } else if(isPresent) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(numbersQueue));
        }

        scanner.close();
    }

}
