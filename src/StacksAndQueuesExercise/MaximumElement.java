package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.startsWith("1")) {
                numbersStack.push(Integer.parseInt(input.split("\\s+")[1]));
            } else {
                if (input.equals("2")) {
                    numbersStack.pop();
                } else if (input.equals("3")) {
                    System.out.println(Collections.max(numbersStack));
                }
            }
        }

        scanner.close();
    }

}
